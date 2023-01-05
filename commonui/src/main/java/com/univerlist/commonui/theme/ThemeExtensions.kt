package com.univerlist.commonui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import com.univerlist.commonui.R



val Typography.title3
    @Composable
    get() = MaterialTheme.typography.headlineSmall

val Typography.headline
    @Composable
    get() = MaterialTheme.typography.titleLarge

val Typography.caption
    @Composable
    get() = MaterialTheme.typography.labelLarge

val Typography.button
    @Composable
    get() = MaterialTheme.typography.caption

val Typography.caption2
    @Composable
    get() = MaterialTheme.typography.labelMedium

val Typography.title1
    @Composable
    get() = MaterialTheme.typography.headlineLarge

val MilesHealthTheme.horizontalPaddingxSmall
    @Composable
    get() = dimensionResource(id = R.dimen.horizontal_content_padding_xsmall)

val MilesHealthTheme.horizontalPaddingSmall
    @Composable
    get() = dimensionResource(id = R.dimen.horizontal_content_padding_small)

val MilesHealthTheme.horizontalPaddingMedium
    @Composable
    get() = dimensionResource(id = R.dimen.horizontal_content_padding_medium)

val MilesHealthTheme.horizontalPadding
    @Composable
    get() = dimensionResource(id = R.dimen.horizontal_content_padding)

val MilesHealthTheme.horizontalPaddingLarge
    @Composable
    get() = dimensionResource(id = R.dimen.horizontal_content_padding_large)

val MilesHealthTheme.horizontalPaddingxLarge
    @Composable
    get() = dimensionResource(id = R.dimen.vertical_content_padding_xxlarge)

val MilesHealthTheme.horizontalPaddingxxLarge
    @Composable
    get() = dimensionResource(id = R.dimen.horizontal_content_padding_xxlarge)

val MilesHealthTheme.horizontalPaddingxxxLarge
    @Composable
    get() = dimensionResource(id = R.dimen.horizontal_content_padding_xxxlarge)

val MilesHealthTheme.verticalPaddingxSmall
    @Composable
    get() = dimensionResource(id = R.dimen.vertical_content_padding_xsmall)

val MilesHealthTheme.verticalPaddingSmall
    @Composable
    get() = dimensionResource(id = R.dimen.vertical_content_padding_small)

val MilesHealthTheme.verticalPaddingMedium
    @Composable
    get() = dimensionResource(id = R.dimen.vertical_content_padding_medium)

val MilesHealthTheme.verticalPadding
    @Composable
    get() = dimensionResource(id = R.dimen.vertical_content_padding)

val MilesHealthTheme.verticalPaddingLarge
    @Composable
    get() = dimensionResource(id = R.dimen.vertical_content_padding_large)

val MilesHealthTheme.verticalPaddingxLarge
    @Composable
    get() = dimensionResource(id = R.dimen.vertical_content_padding_xlarge)

val MilesHealthTheme.verticalPaddingxxLarge
    @Composable
    get() = dimensionResource(id = R.dimen.vertical_content_padding_xxlarge)

val MilesHealthTheme.largeButtonHeight
    @Composable
    get() = dimensionResource(id = R.dimen.large_button_height)

fun Color.lowerEmphasis(defaultAlpha: Float = 0.5f): Color {
    return this.copy(alpha = defaultAlpha)
}
