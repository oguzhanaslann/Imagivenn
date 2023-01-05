package com.univerlist.commonui.components

import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
fun MilesHealthDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = DividerDefaults.Thickness,
    color: Color = LocalContentColor.current.copy(0.1f)
) {
    Divider(
        modifier = modifier,
        thickness = thickness,
        color = color
    )
}
