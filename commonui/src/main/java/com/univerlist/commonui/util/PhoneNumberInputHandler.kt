package com.univerlist.commonui.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.core.text.isDigitsOnly

object PhoneNumberInputHandler {
    const val phoneNumberMask = "000-000-00-00"
    const val maxCharsForPhoneNumber = 10
    private val dividerIndices = listOf(2, 5, 7) // i.e. 2 means put space after index 2
    private val numberOffsets =
        listOf(2, 5, 7, 9, 13) // last index of all individual, xxx(_) <- here
    private const val phoneNumberMaskDivider = '-'

    fun mobileNumberFilter(
        text: AnnotatedString,
        placeHolderColor: Color
    ): TransformedText {

        // change the length
        val trimmed =
            if (text.text.length >= maxCharsForPhoneNumber) text.text.substring(0 until maxCharsForPhoneNumber) else text.text

        val annotatedString = AnnotatedString.Builder().run {
            for (i in trimmed.indices) {
                append(trimmed[i])
                if (i in dividerIndices) {
                    append(phoneNumberMaskDivider)
                }
            }
            pushStyle(SpanStyle(color = placeHolderColor))
            append(
                phoneNumberMask.takeLast(
                    phoneNumberMask.length - length
                )
            )
            toAnnotatedString()
        }

        val phoneNumberOffsetMapper = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                if (offset <= numberOffsets[0]) return offset
                if (offset <= numberOffsets[1]) return offset + 1
                if (offset <= numberOffsets[2]) return offset + 2
                if (offset <= numberOffsets[3]) return offset + 3
                return numberOffsets[4]
            }

            override fun transformedToOriginal(offset: Int): Int {
                if(text.isEmpty()) return 0
                if (offset <= numberOffsets[0]) return offset
                if (offset <= numberOffsets[1]) return offset - 1
                if (offset <= numberOffsets[2]) return offset - 2
                if (offset <= numberOffsets[3]) return offset - 3
                return numberOffsets[3] // intentional index 3
            }
        }

        return TransformedText(annotatedString, phoneNumberOffsetMapper)
    }

    fun isValidPhoneNumber(phoneNumber: String): Boolean {
        return maxCharsForPhoneNumber == phoneNumber.length && phoneNumber.isDigitsOnly()
    }
}
