package com.univerlist.commonui.components.snackbar

import androidx.compose.material3.SnackbarData
import androidx.compose.runtime.Composable

enum class SnackbarType { Neutral, Error; }

@Composable
fun SnackbarWithType(
    snackbarType: SnackbarType,
    snackbarData: SnackbarData
) {
    when (snackbarType) {
        SnackbarType.Neutral -> NeutralSnackbar(snackbarData)
        SnackbarType.Error -> ErrorSnackbar(snackbarData)
    }
}
