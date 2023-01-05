package com.univerlist.commonui.components.textInput

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.input.VisualTransformation
import com.univerlist.commonui.R
import com.univerlist.commonui.components.Caption
import com.univerlist.commonui.theme.caption

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MilesHealthTextInputView(
    modifier: Modifier = Modifier,
    value: String,
    title: String,
    onValueChanged: (String) -> Unit,
    titleColor: Color = Color.Unspecified,
    textFieldColors: TextFieldColors = MilesHealthTextInputColors(),
    transformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    enabled: Boolean = true,
    singleLine : Boolean = true,
    inputContentDescription: String? = null,
    leadingIcon: @Composable () -> Unit = {},
    trailingIcon: @Composable () -> Unit = {}
) {

    val inputGeneralDescription =
        stringResource(id = R.string.content_description_input_field, title)
    val contentDescriptionField: String = remember {
        inputContentDescription ?: inputGeneralDescription
    }

    Column(
        modifier = modifier
    ) {
        Caption(
            text = title,
            color = titleColor
        )

        BasicTextField(
            modifier = Modifier
                .semantics {
                    contentDescription = contentDescriptionField
                    testTag = contentDescriptionField
                    this.stateDescription = value
                },
            value = value,
            onValueChange = onValueChanged,
            singleLine = singleLine,
            enabled = enabled,
            visualTransformation = transformation,
            textStyle = MaterialTheme.typography.caption,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            interactionSource = interactionSource,
            decorationBox = { innerTextField ->
                TextFieldDefaults.TextFieldDecorationBox(
                    value = value,
                    innerTextField = {
                        Column(Modifier.fillMaxWidth()) { innerTextField() }
                    },
                    enabled = enabled,
                    singleLine = true,
                    visualTransformation = transformation,
                    interactionSource = interactionSource,
                    leadingIcon = leadingIcon,
                    trailingIcon = trailingIcon,
                    colors = textFieldColors
                )
            }
        )
    }
}
