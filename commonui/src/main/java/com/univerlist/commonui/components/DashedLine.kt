@file:Suppress("FunctionNaming")
package com.univerlist.commonui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.univerlist.commonui.theme.MilesHealthTheme
import com.univerlist.commonui.theme.onBackgroundVariant

@Immutable
data class DashEffect(
    val on: Float,
    val off: Float,
) {
    companion object {
        fun from(onOffPair: Pair<Float, Float>) = DashEffect(onOffPair.first, onOffPair.second)
    }
}

@Immutable
@Stable
class DashPathEffects(builderBlock: Builder.() -> Unit) {
    private val effectList: List<DashEffect>

    init {
        val builder = Builder()
        builder.builderBlock()
        effectList = builder.build()
    }

    fun toFloatArray(): FloatArray {
        val floatArray = FloatArray(effectList.size * 2)
        effectList.forEachIndexed { index, dashEffect ->
            floatArray[index * 2] = dashEffect.on
            floatArray[index * 2 + 1] = dashEffect.off
        }
        return floatArray
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DashPathEffects

        if (effectList != other.effectList) return false

        effectList.forEachIndexed { index, dashEffect ->
            if (dashEffect != other.effectList[index]) return false
        }

        return true
    }

    override fun hashCode(): Int {
        return effectList.hashCode()
    }

    class Builder {
        private val effectList: MutableList<DashEffect> = mutableListOf()

        fun effect(dashEffect: DashEffect): Builder {
            effectList.add(dashEffect)
            return this
        }

        fun effect(builder: () -> DashEffect): Builder {
            effectList.add(builder())
            return this
        }

        fun effect(on: Float, off: Float): Builder {
            effectList.add(DashEffect(on, off))
            return this
        }

        fun effect(onOffPair: Pair<Float, Float>): Builder {
            effectList.add(DashEffect.from(onOffPair))
            return this
        }

        fun build() = effectList
    }
}

@Composable
fun HorizontalDashedLine(
    modifier: Modifier = Modifier,
    color: Color,
    lineWidth: Dp = 0.dp,
    lineStrokeCap: StrokeCap = StrokeCap.Round,
    dashEffects: DashPathEffects = remember { DashPathEffects { effect(50f, 20f) } },
) {
    val floatArrayOfDashEffects = remember(dashEffects) { dashEffects.toFloatArray() }

    val pathEffect = PathEffect.dashPathEffect(
        intervals = floatArrayOfDashEffects,
        phase = 0f
    )
    Canvas(
        modifier
            .fillMaxWidth()
            .height(lineWidth)
    ) {

        drawLine(
            color = color,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            pathEffect = pathEffect,
            strokeWidth = lineWidth.toPx(),
            cap = lineStrokeCap,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun previewDashedLine() {
    MilesHealthTheme {
        Surface(
            color = MilesHealthTheme.colorScheme.background
        ) {
            Box(
                modifier = Modifier.padding(16.dp),
            ) {
                HorizontalDashedLine(
                    modifier = Modifier.align(Alignment.Center),
                    color = MilesHealthTheme.colorScheme.onBackgroundVariant,
                    lineWidth = 2.dp
                )
            }
        }
    }
}

@Composable
fun VerticalDashedLine(
    modifier: Modifier = Modifier,
    color: Color,
    lineWidth: Dp = 0.dp,
    lineStrokeCap: StrokeCap = StrokeCap.Round,
    dashEffects: DashPathEffects = remember { DashPathEffects { effect(50f, 10f) } },
) {
    val floatArrayOfDashEffects = remember(dashEffects) { dashEffects.toFloatArray() }

    val pathEffect = PathEffect.dashPathEffect(
        intervals = floatArrayOfDashEffects,
        phase = 0f
    )
    Canvas(
        modifier
            .fillMaxHeight()
            .width(lineWidth)
    ) {

        drawLine(
            color = color,
            start = Offset(0f, 0f),
            end = Offset(0f, size.height),
            pathEffect = pathEffect,
            strokeWidth = lineWidth.toPx(),
            cap = lineStrokeCap,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun previewVerticalDashedLine() {
    MilesHealthTheme {
        Surface(
            modifier = Modifier.heightIn(max = 200.dp),
            color = MilesHealthTheme.colorScheme.background
        ) {
            Box(
                modifier = Modifier.padding(16.dp),
            ) {
                VerticalDashedLine(
                    modifier = Modifier.align(Alignment.Center),
                    color = MilesHealthTheme.colorScheme.onBackgroundVariant,
                    lineWidth = 0.dp
                )
            }
        }
    }
}
