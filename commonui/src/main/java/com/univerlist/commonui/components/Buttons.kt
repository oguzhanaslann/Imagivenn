package com.univerlist.commonui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import com.univerlist.commonui.theme.MilesHealthTheme
import com.univerlist.commonui.theme.largeButtonHeight

@Composable
fun LargeButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    color : ButtonColors = ButtonDefaults.buttonColors(),
    shape: Shape = MaterialTheme.shapes.small,
    content: @Composable RowScope.() -> Unit
) {
    StandardButton(
        modifier = modifier
            .fillMaxWidth()
            .height(MilesHealthTheme.largeButtonHeight),
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        color = color,
        content = content
    )
}

@Composable
fun LargeOutlineButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(),
    border: BorderStroke =  BorderStroke(
        width = ButtonDefaults.outlinedButtonBorder.width,
        color = MilesHealthTheme.colorScheme.primary
    ),
    content: @Composable RowScope.() -> Unit
) {
    StandardOutlineButton(
        modifier = modifier
            .fillMaxWidth()
            .height(MilesHealthTheme.largeButtonHeight),
        onClick = onClick,
        enabled = enabled,
        shape = MaterialTheme.shapes.small,
        colors = colors,
        border = border,
        content = content
    )
}

@Composable
fun StandardButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.small,
    color : ButtonColors = ButtonDefaults.buttonColors(),
    content: @Composable RowScope.() -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        colors = color,
        content = content
    )
}

@Composable
fun StandardOutlineButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.small,
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(),
    border: BorderStroke =  BorderStroke(
        width = ButtonDefaults.outlinedButtonBorder.width,
        color = MilesHealthTheme.colorScheme.primary
    ),
    content: @Composable RowScope.() -> Unit
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        content = content,
        colors = colors,
        border = border
    )
}

@Composable
fun StandardTextButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.textButtonColors(),
    content: @Composable RowScope.() -> Unit
) {
    TextButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        shape = MaterialTheme.shapes.small,
        content = content,
        colors = colors
    )
}
