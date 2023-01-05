package com.univerlist.common

fun <T> generateListOf(
    size: Int,
    block: () -> T,
): List<T> {
    val mutableList = mutableListOf<T>()
    repeat(size) {
        mutableList.add(block())
    }
    return mutableList
}

fun <T> generateListOfIndexed(
    size: Int,
    block: (Int) -> T,
): List<T> {
    val mutableList = mutableListOf<T>()
    repeat(size) {
        mutableList.add(block(it))
    }
    return mutableList
}

inline fun <T> generateListReversedIndexed(
    size: Int,
    block: (Int) -> T,
): List<T> {
    val mutableList = mutableListOf<T>()
    for (index in (size - 1) downTo 0) {
        mutableList.add(block(index))
    }
    return mutableList
}

inline fun doWhenOnlyDigit(input: String, block: (String) -> Unit) {
    if (input.isDigitsOnly()) {
        block(input)
    }
}

inline fun doWhenOnlyDigit(input: String, maxLength: Int, block: (String) -> Unit) {
    if (input.isDigitsOnly() && input.length <= maxLength) {
        block(input)
    }
}

fun<T> tryOr(defaultValue: T,block : () -> T): T {
    return try {
        block()
    } catch (e: Exception) {
        defaultValue
    }
}
