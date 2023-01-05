package com.univerlist.commonui.components.dialog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.univerlist.commonui.theme.MilesHealthTheme

@Composable
fun MilesHealthIconDialog(
    showDialog: Boolean,
    onDismissRequest: () -> Unit,
    topIconContainerSize: Dp = 80.dp,
    content: @Composable () -> Unit,
    icon: @Composable () -> Unit,
    headerLeft: @Composable () -> Unit = {},
    headerRight: @Composable () -> Unit = {},
    contentAlignment: Alignment = Alignment.Center,
    dialogContainerBackground: Color = Color.Transparent,
) {
    MilesHealthDefaultDialog(
        showDialog = showDialog,
        onDismissRequest = onDismissRequest,
        contentAlignment = contentAlignment,
        dialogContainerBackground = dialogContainerBackground,
    ) {
        DialogBody(
            topIconContainerSize = topIconContainerSize,
            content = content,
            icon = icon,
            headerLeft = headerLeft,
            headerRight = headerRight,
        )
    }
}

@Composable
fun DialogBody(
    modifier: Modifier = Modifier,
    topIconContainerSize: Dp = 80.dp,
    content: @Composable () -> Unit,
    icon: @Composable () -> Unit,
    headerLeft: @Composable () -> Unit = {},
    headerRight: @Composable () -> Unit = {},
) {
    val topIconSizeHalf = remember { topIconContainerSize / 2 }
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Box {
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = topIconSizeHalf)
            ) {
                Surface(
                    modifier = modifier,
                    shape = MilesHealthTheme.shapes.medium,
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                    ) {
                        DialogHeader(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.TopCenter),
                            topIconSizeHalf = topIconSizeHalf,
                            headerLeft = headerLeft,
                            headerRight = headerRight,
                        )

                        Box(
                            modifier = Modifier
                                .align(Alignment.TopCenter)
                                .padding(top = topIconSizeHalf)
                        ) {
                            content()
                        }
                    }
                }
            }

            Box(
                modifier = Modifier
                    .size(topIconContainerSize)
                    .align(Alignment.TopCenter),
                contentAlignment = Alignment.Center
            ) {
                DialogTopIcon(
                    modifier = Modifier.size(topIconContainerSize)
                ) {
                    icon()
                }
            }
        }
    }
}

@Composable
private fun DialogHeader(
    modifier: Modifier = Modifier,
    topIconSizeHalf: Dp,
    headerLeft: @Composable () -> Unit,
    headerRight: @Composable () -> Unit,
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = topIconSizeHalf)
    ) {

        val (headerLeftView, headerRightView) = createRefs()
        val containerCenterGuide = createGuidelineFromStart(0.5f)

        Box(
            modifier = Modifier
                .constrainAs(headerLeftView) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(containerCenterGuide, margin = topIconSizeHalf)
                    width = Dimension.fillToConstraints
                }
        ) {
            headerLeft()
        }

        Box(
            modifier = Modifier
                .constrainAs(headerRightView) {
                    top.linkTo(parent.top)
                    start.linkTo(containerCenterGuide, margin = topIconSizeHalf)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        ) {
            headerRight()
        }
    }
}

@Composable
fun DialogTopIcon(
    modifier: Modifier = Modifier,
    containerColor: Color = MilesHealthTheme.colorScheme.primary,
    contentColor: Color = MilesHealthTheme.colorScheme.onPrimary,
    shape: Shape = MilesHealthTheme.shapes.large,
    icon: @Composable () -> Unit,
) {
    Surface(
        modifier = Modifier
            .then(modifier),
        color = containerColor,
        contentColor = contentColor,
        shape = shape
    ) {
        Box {
            Box(modifier = Modifier.align(Alignment.Center)) {
                icon()
            }
        }
    }
}
