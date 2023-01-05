package com.univerlist.commonui.components.snackbar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.univerlist.commonui.components.Headline
import com.univerlist.commonui.theme.MilesHealthTheme
import com.univerlist.commonui.theme.horizontalPadding
import com.univerlist.commonui.theme.horizontalPaddingSmall
import com.univerlist.commonui.theme.verticalPaddingMedium

@Composable
fun DefaultSnackbar(
    modifier: Modifier = Modifier,
    containerColor: Color = MilesHealthTheme.colorScheme.surface,
    contentColor: Color = MilesHealthTheme.colorScheme.onSurface,
    shape: CornerBasedShape = MilesHealthTheme.shapes.large,
    content: @Composable () -> Unit = {}
) {
    Snackbar(
        modifier = Modifier
            .height(90.dp)
            .padding(horizontal = MilesHealthTheme.horizontalPadding)
            .padding(bottom = MilesHealthTheme.verticalPaddingMedium)
            .then(modifier),
        containerColor = containerColor,
        contentColor = contentColor,
        shape = shape,
        content = content
    )
}

@Composable
fun NeutralSnackbar(snackbarData: SnackbarData) {
    DefaultSnackbar {
        Row {
            Icon(
                imageVector = Icons.Filled.Done,
                contentDescription = "",
                tint = MilesHealthTheme.colorScheme.onSurface
            )
            Headline(
                text = snackbarData.visuals.message,
                textAlign = TextAlign.Center,
                color = MilesHealthTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
fun ErrorSnackbar(snackbarData: SnackbarData) {
    DefaultSnackbar(
        containerColor = MilesHealthTheme.colorScheme.error,
        contentColor = MilesHealthTheme.colorScheme.onError
    ) {
        Row {
            Icon(
                imageVector = Icons.Filled.Done,
                contentDescription = "",
                tint = MilesHealthTheme.colorScheme.onError
            )
            Spacer(modifier = Modifier.width(MilesHealthTheme.horizontalPaddingSmall))
            Headline(
                text = snackbarData.visuals.message,
                textAlign = TextAlign.Center,
                color = MilesHealthTheme.colorScheme.onError
            )
        }
    }
}
