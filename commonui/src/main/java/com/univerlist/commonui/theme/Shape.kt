package com.univerlist.commonui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

const val SHAPE_EXTRA_SMALL = 4
const val SHAPE_SMALL = 6
const val SHAPE_MEDIUM = 12
const val SHAPE_LARGE = 16
const val SHAPE_EXTRA_LARGE = 20

val shapes = Shapes(
    extraSmall = RoundedCornerShape(SHAPE_EXTRA_SMALL.dp),
    small = RoundedCornerShape(SHAPE_SMALL.dp),
    medium = RoundedCornerShape(SHAPE_MEDIUM.dp),
    large = RoundedCornerShape(SHAPE_LARGE.dp),
    extraLarge = RoundedCornerShape(SHAPE_EXTRA_LARGE.dp)
)
