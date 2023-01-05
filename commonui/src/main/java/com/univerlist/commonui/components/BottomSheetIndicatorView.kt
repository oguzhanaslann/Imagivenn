package com.univerlist.commonui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.univerlist.commonui.theme.MilesHealthTheme
import com.univerlist.commonui.util.emptyComposable

@Composable
fun BottomSheetIndicatorView(
    modifier: Modifier = Modifier,
    width: Dp = 48.dp,
    height: Dp = 4.dp,
    shapes: Shape = MilesHealthTheme.shapes.extraSmall,
    color: Color = MilesHealthTheme.colorScheme.surfaceVariant,
) {
    Surface(
        modifier = modifier
            .size(width = width, height = height),
        shape = shapes,
        color = color,
        content = emptyComposable
    )
}

@Preview(showBackground = true)
@Composable
fun previewBottomSheetIndicatorView() {
    MilesHealthTheme {
        BottomSheetIndicatorView(
            modifier = Modifier.padding(16.dp)
        )
    }
}
