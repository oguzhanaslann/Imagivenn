package com.univerlist.common.validator

import java.util.regex.Pattern

class EmailValidator : Validator<String> {

    override fun validate(t: String): Boolean {
        return EMAIL_REGEX.matcher(t).matches()
    }

    companion object {
        val EMAIL_REGEX = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )
    }
}

fun isAcceptableEmailInput(email: String): Boolean {
    return email.contains(" ").not()
}
