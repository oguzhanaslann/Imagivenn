package com.univerlist.common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

sealed class DataState<out T> {
    object Loading : DataState<Nothing>()
    object Initial : DataState<Nothing>()
    data class Success<T>(val data: T) : DataState<T>()
    data class Error(val exception: String) : DataState<Nothing>()
}

val DataState<*>?.isLoading: Boolean
    get() = this != null && this is DataState.Loading

val DataState<*>?.isInitial: Boolean
    get() = this != null && this is DataState.Initial

val DataState<*>?.isNotLoading: Boolean
    get() = !isLoading

val DataState<*>.isSuccess: Boolean
    get() = this is DataState.Success

val DataState<*>.isError: Boolean
    get() = this is DataState.Error

val DataState<*>.isFinalized: Boolean
    get() = (this != DataState.Loading && this != DataState.Initial)

inline fun <T> DataState<T>.isLoading(crossinline block: (isLoading: Boolean) -> Unit): DataState<T> {
    block(this is DataState.Loading)
    return this
}

inline fun <T> DataState<T>.onLoading(crossinline block: () -> Unit): DataState<T> {
    if (this is DataState.Loading) {
        block()
    }
    return this
}

inline fun <T> DataState<T>.onInitial(crossinline block: () -> Unit): DataState<T> {
    if (this is DataState.Initial) {
        block()
    }
    return this
}

fun <T> DataState<T>.onSuccess(block: (T) -> Unit): DataState<T> {
    if (this is DataState.Success) {
        block(this.data)
    }
    return this
}

inline fun <T> DataState<T>.onError(crossinline block: (error: String) -> Unit): DataState<T> {
    if (this is DataState.Error) {
        block(this.exception)
    }
    return this
}

inline fun <T> DataState<T>.isFinalized(crossinline block: () -> Unit): DataState<T> {
    if (isFinalized) {
        block()
    }
    return this
}

inline fun <reified T, reified R> DataState<T>.mapByState(
    crossinline block: (T) -> R?,
): DataState<R> {
    return when (this) {
        is DataState.Error -> DataState.Error(this.exception)
        DataState.Initial -> DataState.Initial
        DataState.Loading -> DataState.Loading
        is DataState.Success -> {
            val r = block(this.data)
            when (r) {
                null -> DataState.Error("Error Null Data")
                else -> DataState.Success(r)
            }
        }
    }
}

suspend fun <T, K> DataState<T>.mappedBy(
    mapper: suspend (T) -> K,
): DataState<K> {
    return when (this) {
        is DataState.Error -> DataState.Error(this.exception)
        DataState.Initial -> DataState.Initial
        DataState.Loading -> DataState.Loading
        is DataState.Success -> DataState.Success(mapper(this.data))
    }
}

fun <T> DataState<T>.data(): T? {
    return if (this is DataState.Success) this.data else null
}

fun <T> DataState<T>.data(default: T): T {
    return if (this is DataState.Success) this.data else default
}

fun <T> DataState<List<T>>.onData(block: (List<T>) -> Unit): DataState<List<T>> {
    if (this is DataState.Success && this.data.isNotEmpty()) {
        block(this.data)
    }
    return this
}

val <T> DataState<List<T>>.hasData: Boolean
    get() = this is DataState.Success && this.data.isNotEmpty()

fun <T> DataState<List<T>>.onEmpty(block: () -> Unit): DataState<List<T>> {
    if (this is DataState.Success && this.data.isEmpty()) {
        block()
    }
    return this
}

fun <T> Result<T>.toDataState(): DataState<T> {
    val finalState = when {
        isSuccess -> DataState.Success(getOrNull()!!)
        isFailure -> DataState.Error(UnknownError)
        else -> DataState.Error(UnknownError)
    }

    return finalState
}

fun <T, K, R> DataState<T>.combineWith(other: DataState<K>, map: (T, K) -> R): DataState<R> {
    return when {
        this is DataState.Success && other is DataState.Success -> DataState.Success(map(this.data,
            other.data))
        this is DataState.Error -> DataState.Error(this.exception)
        other is DataState.Error -> DataState.Error(other.exception)
        this is DataState.Loading || other is DataState.Loading -> DataState.Loading
        else -> DataState.Initial
    }
}

fun <T, K, L, R> DataState<T>.combineWith(
    other: DataState<K>,
    other2: DataState<L>,
    map: (T, K, L) -> R,
): DataState<R> {
    return when {
        this is DataState.Success && other is DataState.Success && other2 is DataState.Success -> DataState.Success(
            map(this.data, other.data, other2.data))
        this is DataState.Error -> DataState.Error(this.exception)
        other is DataState.Error -> DataState.Error(other.exception)
        other2 is DataState.Error -> DataState.Error(other2.exception)
        this is DataState.Loading || other is DataState.Loading || other2 is DataState.Loading -> DataState.Loading
        else -> DataState.Initial
    }
}

fun <T, K> DataState<T>.combineWith(other: DataState<K>): DataState<Pair<T, K>> {
    return when {
        this is DataState.Success && other is DataState.Success -> DataState.Success(this.data to other.data)
        this is DataState.Error -> DataState.Error(this.exception)
        other is DataState.Error -> DataState.Error(other.exception)
        this is DataState.Loading || other is DataState.Loading -> DataState.Loading
        else -> DataState.Initial
    }
}

fun <T> Flow<DataState<T>>.reduceToDataFlow(): Flow<T> =
    filter { it is DataState.Success }.map { (it as DataState.Success).data }


fun <T, K> DataState<List<T>>.mapList(mapper: (T) -> K): DataState<List<K>> {
    return when (this) {
        is DataState.Error -> DataState.Error(this.exception)
        DataState.Initial -> DataState.Initial
        DataState.Loading -> DataState.Loading
        is DataState.Success -> {
            val list = this.data.map(mapper)
            DataState.Success(list)
        }
    }
}
