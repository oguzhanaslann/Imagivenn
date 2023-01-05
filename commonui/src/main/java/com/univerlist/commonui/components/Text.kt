package com.univerlist.commonui.components

import android.view.View
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.viewinterop.AndroidView
import androidx.emoji2.widget.EmojiTextView
import com.univerlist.commonui.theme.button
import com.univerlist.commonui.theme.caption
import com.univerlist.commonui.theme.caption2
import com.univerlist.commonui.theme.headline

@Composable
fun LargeTitle(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
    color: Color = Color.Unspecified,
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.displaySmall,
        textAlign = textAlign,
        color = color
    )
}

@Composable
fun Title1(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
    color: Color = Color.Unspecified,
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.headlineLarge,
        textAlign = textAlign,
        color = color
    )
}

@Composable
fun Title2(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
    color: Color = Color.Unspecified,
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.headlineMedium,
        textAlign = textAlign,
        color = color
    )
}

@Composable
fun Title3(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
    color: Color = Color.Unspecified,
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.headlineSmall,
        textAlign = textAlign,
        color = color
    )
}

@Composable
fun Headline(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
    color: Color = Color.Unspecified,
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.headline,
        textAlign = textAlign,
        color = color
    )
}

@Composable
fun SubHeadline(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.titleSmall,
    textAlign: TextAlign? = null,
    color: Color = Color.Unspecified,
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        textAlign = textAlign,
        color = color
    )
}


@Composable
fun Body(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    textAlign: TextAlign? = null,
    color: Color = Color.Unspecified,
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        textAlign = textAlign,
        color = color
    )
}

@Composable
fun Caption(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.caption,
    fontWeight: FontWeight? = null,
    textAlign: TextAlign? = null,
    color: Color = Color.Unspecified,
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        textAlign = textAlign,
        color = color,
        fontWeight = fontWeight
    )
}

@Composable
fun Caption2(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.caption2,
    fontWeight: FontWeight? = null,
    textAlign: TextAlign? = null,
    color: Color = Color.Unspecified,
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        textAlign = textAlign,
        color = color,
        fontWeight = fontWeight
    )
}

@Composable
fun ButtonText(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
    color: Color = Color.Unspecified,
) {
    Caption(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        textStyle = MaterialTheme.typography.button,
        color = color
    )
}

@Composable
fun Footnote(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
    color: Color = Color.Unspecified,
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.labelSmall,
        textAlign = textAlign,
        color = color
    )
}

@Composable
fun EmojiView(
    emoji: String,
    textStyle: TextStyle = TextStyle.Default,
    color : Color = LocalContentColor.current
) {
    val headlineSize = textStyle.fontSize.value
    val emojiColor = color.toArgb()

    AndroidView(
        factory = {
            EmojiTextView(it).apply {
                setTextColor(emojiColor)
                text = emoji
                textSize = headlineSize
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }
        },
        update = {
            it.text = emoji
            it.setTextColor(emojiColor)
            it.textSize = headlineSize
        }
    )
}
