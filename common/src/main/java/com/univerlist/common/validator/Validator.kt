package com.univerlist.common.validator

fun interface Validator<T> {
    fun validate(t: T): Boolean
}
