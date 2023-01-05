package com.univerlist.commonui.util

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import com.univerlist.commonui.base.lineHeightMultiplier

@Composable
fun onColorFor(color: Color): Color {
    return when (color) {
        MaterialTheme.colorScheme.primary -> MaterialTheme.colorScheme.onPrimary
        MaterialTheme.colorScheme.primaryContainer ->  MaterialTheme.colorScheme.onPrimaryContainer
        MaterialTheme.colorScheme.secondary ->  MaterialTheme.colorScheme.onSecondary
        MaterialTheme.colorScheme.secondaryContainer ->  MaterialTheme.colorScheme.onSecondaryContainer
        MaterialTheme.colorScheme.tertiary ->  MaterialTheme.colorScheme.onTertiary
        MaterialTheme.colorScheme.tertiaryContainer ->  MaterialTheme.colorScheme.onTertiaryContainer
        MaterialTheme.colorScheme.background ->  MaterialTheme.colorScheme.onBackground
        MaterialTheme.colorScheme.surface ->  MaterialTheme.colorScheme.onSurface
        MaterialTheme.colorScheme.surfaceVariant ->  MaterialTheme.colorScheme.onSurfaceVariant
        MaterialTheme.colorScheme.inverseSurface -> MaterialTheme.colorScheme.inverseOnSurface
        else -> Color.Unspecified
    }
}

val emptyComposable
    get() = @Composable {}

fun composable(view: @Composable () -> Unit): @Composable () -> Unit {
    return { view() }
}


fun unspecifiedLineHeight(percentage: Float = lineHeightMultiplier) =
    TextUnit.Unspecified.times(percentage)
