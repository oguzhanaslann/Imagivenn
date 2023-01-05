package com.univerlist.commonui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.heightIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BottomSheetContent(
    modifier: Modifier = Modifier,
    content : @Composable () -> Unit
) {
    Box(
        modifier = modifier.heightIn(min = 1.dp), // to avoid crash when content is empty
    ) {
        content()
    }
}
