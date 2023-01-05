package com.univerlist.commonui.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import com.univerlist.commonui.theme.MilesHealthTheme

@Composable
fun MilesHealthCard(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    colors: CardColors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface,
    ),
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        shape = shape,
        modifier = modifier,
        colors = colors,
        content = content
    )
}

@Preview
@Composable
fun previewMilesHealthCard() {
    MilesHealthTheme {
        MilesHealthCard {

        }
    }
}
