package com.univerlist.commonui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    primaryContainer = md_theme_light_primaryContainer,
    onPrimaryContainer = md_theme_light_onPrimaryContainer,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    secondaryContainer = md_theme_light_secondaryContainer,
    onSecondaryContainer = md_theme_light_onSecondaryContainer,
    tertiary = md_theme_light_tertiary,
    onTertiary = md_theme_light_onTertiary,
    tertiaryContainer = md_theme_light_tertiaryContainer,
    onTertiaryContainer = md_theme_light_onTertiaryContainer,
    error = md_theme_light_error,
    errorContainer = md_theme_light_errorContainer,
    onError = md_theme_light_onError,
    onErrorContainer = md_theme_light_onErrorContainer,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    surfaceVariant = md_theme_light_surfaceVariant,
    onSurfaceVariant = md_theme_light_onSurfaceVariant,
    outline = md_theme_light_outline,
    inverseOnSurface = md_theme_light_inverseOnSurface,
    inverseSurface = md_theme_light_inverseSurface,
    inversePrimary = md_theme_light_inversePrimary,
    surfaceTint = md_theme_light_surfaceTint,
)

private val DarkColorScheme = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
    tertiary = md_theme_dark_tertiary,
    onTertiary = md_theme_dark_onTertiary,
    tertiaryContainer = md_theme_dark_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer,
    error = md_theme_dark_error,
    errorContainer = md_theme_dark_errorContainer,
    onError = md_theme_dark_onError,
    onErrorContainer = md_theme_dark_onErrorContainer,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    outline = md_theme_dark_outline,
    inverseOnSurface = md_theme_dark_inverseOnSurface,
    inverseSurface = md_theme_dark_inverseSurface,
    inversePrimary = md_theme_dark_inversePrimary,
    surfaceTint = md_theme_dark_surfaceTint,
)

@Immutable
data class OnBackgroundVariant(
    val onBackgroundVariant: Color,
    val success : Color,
    val onSuccess: Color,
)

val LocalExtendedColors = staticCompositionLocalOf {
    OnBackgroundVariant(
        onBackgroundVariant = Color.Unspecified,
        success = Color.Unspecified,
        onSuccess = Color.Unspecified,
    )
}

@Composable
fun MilesHealthTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColorsEnabled: Boolean = false, // TODO: Update this when dynamic colors are determined to be used or not,
    content: @Composable () -> Unit
) {

    val dynamicColor = (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) && dynamicColorsEnabled
    val colorScheme = when {
        dynamicColor && darkTheme -> dynamicDarkColorScheme(LocalContext.current)
        dynamicColor && !darkTheme -> dynamicLightColorScheme(LocalContext.current)
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.CUPCAKE && !view.isInEditMode) {
        SideEffect {
            val activity = view.context as Activity
            val window = (activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme

            window.navigationBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars =
                !darkTheme
        }
    }

    val onBackgroundVariantExtentColors = when {
        darkTheme -> OnBackgroundVariant(
            onBackgroundVariant = onBackgroundVariant_dark,
            success = successColor,
            onSuccess = onSuccessColor
        )
        else -> OnBackgroundVariant(
            onBackgroundVariant = onBackgroundVariant_light,
            success = successColor,
            onSuccess = onSuccessColor
        )
    }

    CompositionLocalProvider(LocalExtendedColors provides onBackgroundVariantExtentColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content,
            shapes = shapes
        )
    }
}

object MilesHealthTheme {

    // delegate MaterialTheme.colorScheme to MilesHealthTheme.colorScheme
    val colorScheme: ColorScheme
        @Composable
        get() = MaterialTheme.colorScheme

    // delegate MaterialTheme.typography to MilesHealthTheme.typography
    val typography: Typography
        @Composable
        get() = MaterialTheme.typography

    // delegate MaterialTheme.shapes to MilesHealthTheme.shapes
    val shapes: Shapes
        @Composable
        get() = MaterialTheme.shapes

    val onBackgroundVariant: Color
        @Composable
        get() = LocalExtendedColors.current.onBackgroundVariant

    val success: Color
        @Composable
        get() = LocalExtendedColors.current.success

    val onSuccess: Color
        @Composable
        get() = LocalExtendedColors.current.onSuccess

}

val ColorScheme.onBackgroundVariant: Color
    @Composable
    get() = MilesHealthTheme.onBackgroundVariant

val ColorScheme.success: Color
    @Composable
    get() = MilesHealthTheme.success

val ColorScheme.onSuccess: Color
    @Composable
    get() = MilesHealthTheme.onSuccess
