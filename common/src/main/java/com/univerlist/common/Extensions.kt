package com.univerlist.common

import java.math.BigDecimal

fun String.indexRangeOf(sub: String): Pair<Int, Int>? {
    val start = indexOf(sub)
    return when (start != -1) {
        true -> Pair(start, start + sub.length - 1)
        false -> null
    }
}


fun Pair<Int ,Int>?.toRange() : IntRange? {
    val pair = this ?: return null
    require(first <= second)  { "cannot convert a range with $first, $second. first > second" }
    return first..second
}

fun String.isDigitsOnly(): Boolean = all { it.isDigit() }

fun <T> generateListByConditionOrEmpty(condition: Boolean, factory: () -> List<T>): List<T> {
    return if (condition) factory() else emptyList()
}

fun String.insert(index: Int, string: String): String {
    return this.substring(0, index) + string + this.substring(index)
}

fun BigDecimal.copy(): BigDecimal {
    return BigDecimal(this.toString())
}
