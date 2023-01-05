@file:Suppress("MagicNumber")

package com.univerlist.commonui.theme

import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
// Warning : Do not forget to keep these sync with theme.xml colors
val md_theme_light_primary = Color(0xFF4DB9FF)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFFC2E8FF)
val md_theme_light_onPrimaryContainer = Color(0xFF001E2B)
val md_theme_light_secondary = Color(0xFF007DFF)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFD7E2FF)
val md_theme_light_onSecondaryContainer = Color(0xFF001A40)
val md_theme_light_tertiary = Color(0xFFda772d)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFFEAE6FF)
val md_theme_light_onTertiaryContainer = Color(0xFF001F24)
val md_theme_light_error = Color(0xFFFA548A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Color(0xFFF6FEFF)
val md_theme_light_onBackground = Color(0xFF001F24)
val md_theme_light_surface = Color(0xFFD9F0FF)
val md_theme_light_onSurface = Color(0xFF172B4D)
val md_theme_light_surfaceVariant = Color(0xFFDDE3EA)
val md_theme_light_onSurfaceVariant = Color(0xFF172B4D)
val md_theme_light_outline = Color(0xFFF4F5F7)
val md_theme_light_inverseOnSurface = Color(0xFFD0F8FF)
val md_theme_light_inverseSurface = Color(0xFF00363D)
val md_theme_light_inversePrimary = Color(0xFF75D1FF)
val md_theme_light_shadow = Color(0xFF000000)
val md_theme_light_surfaceTint = Color(0xFF006688)

val onBackgroundVariant_light = Color(0xFF7A869A)
val successColor = Color(0xFF40C255)
val onSuccessColor = Color(0xFFFFFFFF)

val md_theme_dark_primary = Color(0xFF4DB9FF)
val md_theme_dark_onPrimary = Color(0xFFF4F8F9)
val md_theme_dark_primaryContainer = Color(0xFF004D67)
val md_theme_dark_onPrimaryContainer = Color(0xFFC2E8FF)
val md_theme_dark_secondary = Color(0xFF007DFF)
val md_theme_dark_onSecondary = Color(0xFFAEB5C5)
val md_theme_dark_secondaryContainer = Color(0xFF004491)
val md_theme_dark_onSecondaryContainer = Color(0xFFD7E2FF)
val md_theme_dark_tertiary = Color(0xFFda772d)
val md_theme_dark_onTertiary = Color(0xFFFFFFFF)
val md_theme_dark_tertiaryContainer = Color(0xFF743500)
val md_theme_dark_onTertiaryContainer = Color(0xFFFFDBC8)
val md_theme_dark_error = Color(0xFFFA548A)
val md_theme_dark_errorContainer = Color(0xFFCBA8A5)
val md_theme_dark_onError = Color(0xFFFFFFFF)
val md_theme_dark_onErrorContainer = Color(0xFF410002)
val md_theme_dark_background = Color(0xFF0F1624)
val md_theme_dark_onBackground = Color(0xFFF6FBFB)
val md_theme_dark_surface = Color(0xFFD9F0FF)
val md_theme_dark_onSurface = Color(0xFF172B4D)
val md_theme_dark_surfaceVariant = Color(0xFF41474d)
val md_theme_dark_onSurfaceVariant = Color(0xFFF6FBFB)
val md_theme_dark_outline = Color(0xFF8A9297)
val md_theme_dark_inverseOnSurface = Color(0xFF001F24)
val md_theme_dark_inverseSurface = Color(0xFF97F0FF)
val md_theme_dark_inversePrimary = Color(0xFF006688)
val md_theme_dark_shadow = Color(0xFF000000)
val md_theme_dark_surfaceTint = Color(0xFF75D1FF)

val onBackgroundVariant_dark = Color(0xFF7A869A)

val seed = Color(0xFFD9F0FF)

@Composable
fun switchColors(): SwitchColors {
    return SwitchDefaults.colors(
        checkedThumbColor = MilesHealthTheme.colorScheme.onPrimary,
        checkedTrackColor = MilesHealthTheme.colorScheme.primary,
        checkedBorderColor = Color.Transparent,
        uncheckedThumbColor = MilesHealthTheme.colorScheme.background,
        uncheckedTrackColor = MilesHealthTheme.colorScheme.onBackgroundVariant,
        uncheckedBorderColor = Color.Transparent,
    )
}

val bottomSheetScrimColor get() = Color.Black.copy(0.5f)
