package com.univerlist.commonui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.Normal,
        fontSize = 64.sp,
        lineHeight = lineHeight140Percent(64.sp),
    ),
    displayMedium = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.Normal,
        fontSize = 52.sp,
        lineHeight = lineHeight140Percent(52.sp),
    ),
    displaySmall = TextStyle(
        fontFamily = inter,
        // title large
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        fontStyle = FontStyle.Normal,
        letterSpacing = (-1).sp,
        lineHeight = lineHeight140Percent(28.sp),
    ),
    headlineLarge = TextStyle(
        fontFamily = inter,
        // title1
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        fontStyle = FontStyle.Normal,
        lineHeight = lineHeight140Percent(24.sp),
    ),
    headlineMedium = TextStyle(
        fontFamily = inter,
        // title2
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        fontStyle = FontStyle.Normal,
        lineHeight = lineHeight140Percent(20.sp),
        ),
    headlineSmall = TextStyle(
        fontFamily = inter,
        // title3
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        fontStyle = FontStyle.Normal,
        lineHeight = lineHeight140Percent(18.sp),
    ),
    titleLarge = TextStyle(
        fontFamily = inter,
        // headline
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        fontStyle = FontStyle.Normal,
        lineHeight = lineHeight140Percent(16.sp),
    ),
    titleMedium = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = lineHeight140Percent(14.sp),
    ),
    titleSmall = TextStyle(
        fontFamily = inter,
        // subhead
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontSize = 13.sp,
        lineHeight = lineHeight140Percent(13.sp),
    ),
    bodyLarge = TextStyle(
        fontFamily = inter,
        // body - larger
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = lineHeight140Percent(18.sp),
    ),
    bodyMedium = TextStyle(
        fontFamily = inter,
        // body
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = lineHeight140Percent(16.sp),
    ),
    bodySmall = TextStyle(
        fontFamily = inter,
        // body - smaller
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        fontSize = 14.sp,
        lineHeight = lineHeight140Percent(14.sp),
    ),
    labelLarge = TextStyle(
        fontFamily = inter,
        // caption 1
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        fontSize = 14.sp,
        lineHeight = lineHeight140Percent(14.sp)
    ),
    labelMedium = TextStyle(
        fontFamily = inter,
        //caption 2
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        fontSize = 12.sp,
        lineHeight = lineHeight140Percent(12.sp)
    ),
    labelSmall = TextStyle(
        fontFamily = inter,
        // for footnotes
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = lineHeight140Percent(10.sp)
    )
)

fun lineHeight140Percent(fontSize: TextUnit) = (fontSize * 1.4)
