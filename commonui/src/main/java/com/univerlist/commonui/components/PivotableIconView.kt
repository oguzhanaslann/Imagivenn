package com.univerlist.commonui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun PivotableIconView(
    modifier : Modifier = Modifier,
    pivotFactory : () -> Boolean,
    icon : ImageVector,
    contentDescription : String? = null
) {
    val flipAnimationState by animateFloatAsState(targetValue = if (pivotFactory()) 180f else 0f)
    Icon(
        modifier = modifier.rotate(flipAnimationState),
        imageVector = icon,
        contentDescription = contentDescription
    )
}
