package com.univerlist.commonui.components.textInput

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.univerlist.commonui.theme.MilesHealthTheme
import com.univerlist.commonui.theme.onBackgroundVariant

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MilesHealthTextInputColors(
    from: Color = MilesHealthTheme.colorScheme.onBackground,
) = TextFieldDefaults.textFieldColors(
    textColor = from,
    disabledTextColor = from.copy(alpha = 0.5f),
    containerColor = MilesHealthTheme.colorScheme.background,
    placeholderColor = from.copy(alpha = 0.5f),
    disabledPlaceholderColor = from.copy(alpha = 0.5f),
    unfocusedLeadingIconColor = from.copy(alpha = 0.5f),
    focusedLeadingIconColor = from.copy(alpha = 0.5f),
    unfocusedTrailingIconColor = from.copy(alpha = 0.5f),
    focusedTrailingIconColor = from.copy(alpha = 0.5f),
    focusedIndicatorColor = MilesHealthTheme.colorScheme.onBackgroundVariant,
    unfocusedIndicatorColor = MilesHealthTheme.colorScheme.onBackgroundVariant,
    disabledIndicatorColor = MilesHealthTheme.colorScheme.onBackgroundVariant,
    errorIndicatorColor = MilesHealthTheme.colorScheme.error,
    disabledLeadingIconColor = from.copy(alpha = 0.5f),
    disabledTrailingIconColor = from.copy(alpha = 0.5f),
)
