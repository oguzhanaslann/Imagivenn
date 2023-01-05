package com.univerlist.common.validator

import java.util.regex.Pattern

class FullNameValidator: Validator<String> {
    override fun validate(t: String): Boolean {
        return FULL_NAME_REGEX.matcher(t).matches()
    }

    companion object {
        private val FULL_NAME_REGEX = Pattern.compile("^[a-zA-Z ]*\$")
    }
}
