package com.univerlist.commonui.components.snackbar

import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.Composable

@Composable
fun MilesHealthSnackbarHost(
    hostStateController: SnackbarHostStateController
) {
    SnackbarHost(
        hostState = hostStateController.snackbarHostState,
        snackbar = {
            SnackbarWithType(
                snackbarType = hostStateController.snackbarType,
                snackbarData = it
            )
        }
    )
}
