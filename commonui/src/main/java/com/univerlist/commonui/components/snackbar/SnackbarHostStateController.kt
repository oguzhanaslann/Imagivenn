package com.univerlist.commonui.components.snackbar

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class SnackbarHostStateController(
    val snackbarHostState: SnackbarHostState,
    var snackbarType: SnackbarType = SnackbarType.Neutral,
    private val coroutineScope: CoroutineScope
) {
    private fun updateTypeTo(type: SnackbarType) {
        this.snackbarType = type
    }

    fun showNeutralSnackbar(
        snackbarLabel : String
    ) {
        updateTypeTo(SnackbarType.Neutral)
        coroutineScope.launch {
            snackbarHostState.showSnackbar(snackbarLabel)
        }
    }

    fun showErrorSnackbar(
        snackbarLabel : String
    ) {
        updateTypeTo(SnackbarType.Error)
        coroutineScope.launch {
            snackbarHostState.showSnackbar(snackbarLabel)
        }
    }
}

@Composable
fun rememberSnackbarHostStateController(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    snackbarHostState: SnackbarHostState = remember {
        SnackbarHostState()
    },
    snackbarType: SnackbarType = SnackbarType.Neutral
) = remember(snackbarHostState, snackbarType, coroutineScope) {
    SnackbarHostStateController(snackbarHostState, snackbarType, coroutineScope)
}
