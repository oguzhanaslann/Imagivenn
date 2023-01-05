package com.univerlist.commonui.components.dialog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FullScreenDialog(
    showDialog: Boolean,
    onDismissRequest: () -> Unit,
    content: @Composable BoxScope.() -> Unit
) {
    MilesHealthDialog(
        showDialog = showDialog,
        onDismissRequest = onDismissRequest,
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                this.content()
            }
        }
    )
}
