package com.univerlist.commonui.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.widget.CalendarView
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.viewinterop.AndroidView
import com.univerlist.commonui.theme.MilesHealthTheme
import java.util.*

@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    name = "ALERT NIGHT"
)
@Preview(
    uiMode = UI_MODE_NIGHT_NO,
    name = "Alert light"
)
@Composable
fun previewDatePickerDialog() {
    MilesHealthTheme {
        DatePickerDialog(
            title = "select a date",
            positiveButtonTitle = "Confirm",
            dismissButtonTitle = "Cancel",
            onDismissRequest = {},
            onDateSelected = {}
        )
    }
}

@Composable
fun DatePickerDialog(
    title: String,
    positiveButtonTitle: String,
    dismissButtonTitle: String,
    onDismissRequest: () -> Unit,
    onDateSelected: (Date) -> Unit,
    nowAsLong: Long = remember { Date().time },
    minYear: Int = 1950,
    startDate: Date? = null,
) {

    val isMenuExpanded = remember { mutableStateOf(false) }

    val yearOptions = rememberSaveable {
        val calendar = Calendar.getInstance()
        val currentYear = calendar.get(Calendar.YEAR)
        (minYear..currentYear).toList()
            .map { it.toString() }
            .reversed()
    }

    var calendarState by remember {
        mutableStateOf(Calendar.getInstance().apply { time = startDate ?: Date() })
    }

    val selectedYear = remember(calendarState) {
        derivedStateOf {
            calendarState.get(Calendar.YEAR)
        }
    }


    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Title2(text = title)

                DatePickerItemDropdownMenu(
                    initialText = selectedYear.value.toString(),
                    itemList = yearOptions,
                    onItemSelected = {
                        calendarState = getNewCalendarWith(calendarState, it.toInt())
                        isMenuExpanded.value = false
                    },
                    isMenuExpanded = isMenuExpanded.value,
                    onExpandMenu = { isMenuExpanded.value = true },
                    onDismissRequest = { isMenuExpanded.value = false },
                )
            }
        },
        text = {
            Column(modifier = Modifier.fillMaxWidth()) {
                AndroidView(
                    modifier = Modifier.fillMaxWidth(),
                    factory = {
                        val calendarView = CalendarView(it)
                        calendarView.maxDate = nowAsLong
                        calendarView.setDate(calendarState.timeInMillis, true, true)
                        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
                            calendarState =
                                getNewCalendarWith(calendarState, year, month, dayOfMonth)
                        }
                        calendarView
                    },
                    update = {
                        it.date = calendarState.timeInMillis
                        it.setOnDateChangeListener { _, year, month, dayOfMonth ->
                            calendarState =
                                getNewCalendarWith(calendarState, year, month, dayOfMonth)
                        }
                    }
                )
            }
        },
        confirmButton = {
            StandardButton(onClick = { onDateSelected(calendarState.time) }) {
                Caption(text = positiveButtonTitle)
            }
        },
        dismissButton = {
            StandardTextButton(
                onClick = onDismissRequest,
                colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.onSurface)
            ) {
                Caption(text = dismissButtonTitle)
            }
        }
    )
}

private fun getNewCalendarWith(
    calendarState: Calendar,
    year: Int,
): Calendar {
    return Calendar.getInstance().apply {
        time = calendarState.time
        set(Calendar.YEAR, year)
    }
}

private fun getNewCalendarWith(
    calendarState: Calendar,
    year: Int,
    month: Int,
    dayOfMonth: Int
): Calendar {
    return Calendar.getInstance().apply {
        time = calendarState.time
        set(Calendar.YEAR, year)
        set(Calendar.MONTH, month)
        set(Calendar.DAY_OF_MONTH, dayOfMonth)
    }
}

@Composable
private fun DatePickerItemDropdownMenu(
    initialText: String,
    isMenuExpanded: Boolean,
    itemList: List<String>,
    onExpandMenu: () -> Unit = {},
    onItemSelected: (String) -> Unit,
    onDismissRequest: () -> Unit
) {

    Box(
        modifier = Modifier
            .wrapContentSize(Alignment.TopStart)
    ) {
        DropdownMenu(
            modifier = Modifier.sizeIn(maxHeight = 300.dp),
            expanded = isMenuExpanded,
            onDismissRequest = onDismissRequest
        ) {
            itemList.fastForEach {
                DropdownMenuItem(
                    onClick = { onItemSelected(it) },
                    text = { Text(text = it, style = MaterialTheme.typography.bodyMedium) },
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { onExpandMenu() }
        ) {
            Body(text = initialText, textStyle = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.width(4.dp))
            Icon(
                modifier = Modifier.size(16.dp),
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = "Drop down icon"
            )
        }
    }
}
