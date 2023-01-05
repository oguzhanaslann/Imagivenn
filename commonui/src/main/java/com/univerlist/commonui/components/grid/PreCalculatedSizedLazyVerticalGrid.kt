package com.univerlist.commonui.components.grid

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.max

@Composable
fun PreCalculatedSizedLazyVerticalGrid(
    modifier: Modifier = Modifier,
    itemsVerticalPadding: Dp,
    itemsHorizontalPadding: Dp,
    itemMinWidth: Dp,
    itemHeight: Dp,
    itemCount: Int,
    content: LazyGridScope.() -> Unit,
) {

    BoxWithConstraints {
        val itemsPerRow = remember { floor((maxWidth / (itemMinWidth + itemsHorizontalPadding))) }
        val itemsPerRowPositive = remember { max(1f, itemsPerRow) } // Avoid division by zero
        val columnCount = remember { ceil((itemCount / itemsPerRowPositive)) }

        val viewMaxHeight =
            remember { ((itemHeight) * columnCount) + (itemsVerticalPadding * (columnCount - 1)) }

        Column(
            modifier = modifier
                .fillMaxWidth()
                .sizeIn(minHeight = itemHeight, maxHeight = viewMaxHeight)
        ) {
            LazyVerticalGrid(
                modifier = Modifier.fillMaxWidth(),
                columns = GridCells.Adaptive(itemMinWidth),
                verticalArrangement = Arrangement.spacedBy(itemsVerticalPadding),
                horizontalArrangement = Arrangement.spacedBy(itemsHorizontalPadding),
                content = content
            )
        }
    }
}

@Composable
fun PreCalculatedSizedLazyVerticalGrid(
    modifier: Modifier = Modifier,
    spanCount: Int,
    itemHeight: Dp,
    itemCount: Int,
    itemsVerticalPadding: Dp = 0.dp,
    content: LazyGridScope.() -> Unit,
) {

    BoxWithConstraints(
        modifier = modifier
    ) {
        val columnCount = remember {
            val columnCount = ceil((itemCount.toFloat() / spanCount.toFloat()))
            max(1f, columnCount)
        }
        val viewMaxHeight =
            remember { ((itemHeight) * columnCount) + (itemsVerticalPadding * (columnCount - 1)) }
        Column(
            modifier = modifier
                .fillMaxWidth()
                .sizeIn(minHeight = itemHeight, maxHeight = viewMaxHeight)
        ) {
            LazyVerticalGrid(
                modifier = Modifier.fillMaxWidth(),
                columns = GridCells.Fixed(spanCount),
                verticalArrangement = Arrangement.spacedBy(itemsVerticalPadding),
                content = content
            )
        }

    }
}
