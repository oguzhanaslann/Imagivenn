package com.univerlist.common


fun Any?.isNull() = this == null

inline fun <T, R> Result<T>.mapByResult(
    crossinline block: (T) -> R?
): Result<R> {
    return when {
        isFailure -> Result.failure(this.exceptionOrNull()!!)
        isSuccess -> {
            val r = block(this.getOrNull()!!)
            when {
                r.isNull() -> Result.failure(UnknownError(NullDataError))
                else -> Result.success(r!!)
            }
        }

        else -> Result.failure(UnknownError(NullDataError))
    }
}

suspend inline fun <T, R> Result<T>.mapByResultSuspend(
    crossinline block: suspend (T) -> R?
): Result<R> {
    return when {
        isFailure -> Result.failure(this.exceptionOrNull() ?: UnknownError())
        isSuccess -> {
            val r = this.getOrNull()?.let { block(it) }
            when {
                r.isNull() -> Result.failure(UnknownError(NullDataError))
                else -> Result.success(r!!)
            }
        }

        else -> Result.failure(UnknownError(NullDataError))
    }
}

inline fun <T, K, R> Result<T>.mappedWithDependency(
    dependencyMapBlock: (T) -> Result<K>?,
    mapBlock: (K) -> R
): Result<R> {
    return when {
        this.isFailure -> Result.failure(this.exceptionOrNull() ?: UnknownError())
        isSuccess -> {
            val result = this.getOrNull()?.let { dependencyMapBlock(it) }
            when {
                result?.getOrNull() == null -> Result.failure(UnknownError(NullDataError))
                result.getOrNull() != null -> {
                    val dependencyResult = result.getOrNull()!!
                    val finalResult = mapBlock(dependencyResult)
                    Result.success(finalResult)
                }
                else -> Result.failure(UnknownError(NullDataError))
            }
        }
        else -> Result.failure(UnknownError(NullDataError))
    }
}

suspend inline fun <T, K, R> Result<T>.mappedWithDependencySuspend(
    dependencyBlock: suspend (T) -> Result<K>?,
    mapBlock: suspend (T, K) -> R
): Result<R> {
    return when {
        this.isFailure -> Result.failure(this.exceptionOrNull() ?: UnknownError())
        isSuccess -> {
            val result = this.getOrNull()?.let { dependencyBlock(it) }
            when {
                result?.getOrNull() == null -> Result.failure(UnknownError(NullDataError))
                result.getOrNull() != null && getOrNull() != null -> {
                    val dependencyResult = result.getOrNull()!!
                    val thisResult = getOrNull()!!
                    val finalResult = mapBlock(thisResult, dependencyResult)
                    Result.success(finalResult)
                }
                else -> Result.failure(UnknownError(NullDataError))
            }
        }
        else -> Result.failure(UnknownError(NullDataError))
    }
}

suspend fun <T> Result<T>.resolve(
    onSuccess: suspend () -> Unit,
    onFail: suspend () -> Unit
) {
    when {
        isSuccess -> {
            onSuccess()
        }

        isFailure -> {
            onFail()
        }
    }
}

suspend fun <T, R> Result<T>.combine(
    otherResult: Result<R>,
    onSuccess: suspend () -> Unit,
    onMainResultFail: suspend () -> Unit,
    onOtherResultFail: suspend () -> Unit
) {
    when {
        this.isSuccess && otherResult.isSuccess -> {
            onSuccess()
        }

        isFailure -> {
            onMainResultFail()
        }

        otherResult.isFailure -> {
            onOtherResultFail()
        }
    }
}

suspend fun <T, R> Result<T>.chain(
    resultBuilderBlock: suspend () -> Result<R>,
    onSuccess: suspend () -> Unit,
    onMainResultFail: suspend () -> Unit,
    onOtherResultFail: suspend () -> Unit
) {
    when {
        isSuccess -> {
            val otherResult = resultBuilderBlock()
            otherResult.resolve(
                onSuccess = onSuccess ,
                onFail = onOtherResultFail
            )
        }

        isFailure -> {
            onMainResultFail()
        }
    }
}





fun <T> Result.Companion.from(t: T?) =
    if (t != null) Result.success(t) else Result.failure(Exception("Null Data "))
