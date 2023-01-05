package com.univerlist.commonui.components

import androidx.annotation.RawRes
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.univerlist.commonui.theme.MilesHealthTheme
import com.univerlist.commonui.util.emptyComposable

@Composable
fun LottieAnimationView(
    modifier: Modifier = Modifier,
    @RawRes animation: Int,
    iterations: Int = LottieConstants.IterateForever,
    isPlaying: Boolean = true,
    restartOnPlay: Boolean = false,
) {
    PreviewDispatchedView(
        mainContent = {
            LottieAnimationContent(animation, iterations, isPlaying, restartOnPlay, modifier)
        },
        previewContent = {
            Surface(
                modifier = modifier,
                color = MilesHealthTheme.colorScheme.surface,
                content = emptyComposable
            )
        }
    )
}

@Composable
private fun LottieAnimationContent(
    animation: Int,
    iterations: Int,
    isPlaying: Boolean,
    restartOnPlay: Boolean,
    modifier: Modifier
) {
    val speed by remember {
        mutableStateOf(1f)
    }

    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(animation)
    )

    val progress by animateLottieCompositionAsState(
        // pass the composition created above
        composition,

        // Iterates Forever
        iterations = iterations,

        // pass isPlaying we created above,
        // changing isPlaying will recompose
        // Lottie and pause/play
        isPlaying = isPlaying,

        // pass speed we created above,
        // changing speed will increase Lottie
        speed = speed,

        // this makes animation to restart
        // when paused and play
        // pass false to continue the animation
        // at which is was paused
        restartOnPlay = restartOnPlay

    )

    LottieAnimation(
        modifier = modifier,
        composition = composition,
        progress = progress
    )
}
