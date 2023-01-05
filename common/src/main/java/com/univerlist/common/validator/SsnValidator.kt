package com.univerlist.common.validator

import com.univerlist.common.isDigitsOnly

class SsnValidator : Validator<String> {
    override fun validate(t: String): Boolean {
        return t.isDigitsOnly() && t.length == SSN_LENGTH
    }

    companion object {
        internal const val SSN_LENGTH = 11
    }
}

fun isAcceptableSSNInput(input: String): Boolean {
    return input.length <= SsnValidator.SSN_LENGTH && input.isDigitsOnly()
}
