package com.univerlist.commonui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalInspectionMode

@Composable
fun PreviewDispatchedView(
    mainContent: @Composable () -> Unit,
    previewContent: @Composable () -> Unit
) {
    if (LocalInspectionMode.current) {
        previewContent()
    } else {
         mainContent()
    }
}
