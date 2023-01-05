package com.univerlist.commonui.components.shimmer
interface ShimmerEffectFactory {

    fun create(
        baseAlpha: Float,
        highlightAlpha: Float,
        direction: ShimmerDirection,
        dropOff: Float,
        intensity: Float,
        tilt: Float
    ): ShimmerEffect
}
