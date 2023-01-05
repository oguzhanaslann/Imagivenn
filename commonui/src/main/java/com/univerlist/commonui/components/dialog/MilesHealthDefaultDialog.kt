package com.univerlist.commonui.components.dialog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.univerlist.commonui.util.emptyComposable

@Composable
fun MilesHealthDefaultDialog(
    showDialog: Boolean,
    onDismissRequest: () -> Unit,
    contentAlignment: Alignment = Alignment.Center,
    dialogContainerBackground: Color = Color.Transparent,
    dialogBody: @Composable () -> Unit,
) {
    MilesHealthDialog(
        showDialog = showDialog,
        onDismissRequest = onDismissRequest,
        content = {
            BoxWithConstraints(
                modifier = Modifier.fillMaxSize()
            ) {
                val maxHeightOfDialog = min(maxHeight * 0.9f, 700.dp)
                val maxWidthOfDialog = min(maxWidth * 0.815f, 560.dp)

                Surface(
                    modifier = Modifier.fillMaxSize()
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = onDismissRequest
                        ),
                    color = Color.Transparent,
                    content = emptyComposable
                )

                Surface(
                    modifier = Modifier
                        .heightIn(max = maxHeightOfDialog)
                        .widthIn(max = maxWidthOfDialog)
                        .align(contentAlignment),
                    color = dialogContainerBackground,
                    content = { dialogBody() }
                )
            }
        }
    )
}
