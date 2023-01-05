package com.univerlist.commonui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle

@Composable
fun SpannableText(
    modifier : Modifier = Modifier,
    spanRange: IntRange?,
    text: String,
    onSpanClicked: (() -> Unit)? = null,
    textStyle: TextStyle = TextStyle.Default,
    spanColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
) {
    if (spanRange != null) {
        require(spanRange.first >= text.indices.first && spanRange.last <= text.indices.last)
    }

    Row(
        modifier = if (onSpanClicked != null) modifier.clickable { onSpanClicked() } else modifier
    ) {

        Text(
            buildAnnotatedString {

                text.forEachIndexed { index, char ->
                    if (spanRange != null && index in spanRange) {
                        withStyle(
                            SpanStyle(
                                fontStyle = textStyle.fontStyle,
                                fontFamily = textStyle.fontFamily,
                                color = spanColor,
                                fontSize = textStyle.fontSize,
                                fontWeight = textStyle.fontWeight,
                            )
                        ) {
                            append(char)
                        }
                    } else {
                        withStyle(
                            style = SpanStyle(
                                fontStyle = textStyle.fontStyle,
                                color = textColor,
                                fontFamily = textStyle.fontFamily,
                                fontSize = textStyle.fontSize,
                                fontWeight = textStyle.fontWeight,
                            )
                        ) {
                            append(char)
                        }
                    }
                }
            },
            textAlign = textAlign,
        )
    }
}
