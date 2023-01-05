package com.univerlist.commonui.util

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun CornerBasedShape.bottomCornersFlatten(): CornerBasedShape {
    return this.copy(
        bottomStart = CornerSize(0.dp),
        bottomEnd = CornerSize(0.dp)
    )
}

fun CornerBasedShape.topCornersFlatten(): CornerBasedShape {
    return this.copy(
        topStart = CornerSize(0.dp),
        topEnd = CornerSize(0.dp)
    )
}

fun CornerBasedShape.startCornersFlatten(): CornerBasedShape {
    return this.copy(
        topStart = CornerSize(0.dp),
        bottomStart = CornerSize(0.dp)
    )
}

fun CornerBasedShape.endCornersFlatten(): CornerBasedShape {
    return this.copy(
        topEnd = CornerSize(0.dp),
        bottomEnd = CornerSize(0.dp)
    )
}

fun Modifier.horizontalListInnerPadding(isLastIndex: Boolean, paddingEnd: Dp) = when {
    isLastIndex -> this
    else -> this.padding(end = paddingEnd)
}

fun Modifier.verticalListInnerPadding(isFirstIndex: Boolean, paddingTop: Dp) = when {
    isFirstIndex -> this
    else -> this.padding(top = paddingTop)
}


@OptIn(ExperimentalMaterialApi::class)
suspend fun ModalBottomSheetState.showIfNotVisible() {
    if (!isVisible) {
        show()
    }
}

@OptIn(ExperimentalMaterialApi::class)
suspend fun ModalBottomSheetState.hideIfVisible() {
    if (isVisible) {
        hide()
    }
}
