package com.univerlist.camera

import android.content.Context
import android.util.Size
import androidx.camera.core.Camera
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.camera.core.UseCaseGroup
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.google.common.util.concurrent.ListenableFuture
import com.univerlist.commonui.theme.MilesHealthTheme
import java.util.concurrent.Executor

/**
 *   It is the responsibility of the application to close the image once done with it.
 *  If the images are not closed then it may block further images from being produced
 *  (causing the preview to stall) or drop images as determined by the configured
 *  backpressure strategy. The exact behavior is configurable via
 *  {@link ImageAnalysis.Builder#setBackpressureStrategy(int)}.
 *
 *  do not forget to call proxy.close() after using it via onImageProxy
 * */
@Composable
fun CameraView(
    modifier: Modifier = Modifier,
    onImageProxy: (ImageProxy) -> Unit = {}
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
    val cameraSelection = remember {
        mutableStateOf(CameraSelector.LENS_FACING_BACK)
    }

    Box(modifier = modifier) {
        AndroidView(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            factory = { ctx ->
                val previewView = PreviewView(ctx)
                bindCameraUseCases(
                    ctx = ctx,
                    cameraProviderFuture = cameraProviderFuture,
                    previewView = previewView,
                    cameraSelection = cameraSelection.value,
                    lifecycleOwner = lifecycleOwner,
                    onImageProxy = onImageProxy
                )

                previewView
            },
            update = { previewView ->
                bindCameraUseCases(
                    ctx = previewView.context,
                    cameraProviderFuture = cameraProviderFuture,
                    previewView = previewView,
                    cameraSelection = cameraSelection.value,
                    lifecycleOwner = lifecycleOwner,
                    onImageProxy = onImageProxy,
                )
            }
        )
    }
}

@Suppress("LongParameterList")
private fun bindCameraUseCases(
    ctx: Context,
    cameraProviderFuture: ListenableFuture<ProcessCameraProvider>,
    previewView: PreviewView,
    cameraSelection: Int,
    lifecycleOwner: LifecycleOwner,
    onCameraReady: (Camera) -> Unit = {},
    onImageProxy: (ImageProxy) -> Unit = {},
) {
    val executor = ContextCompat.getMainExecutor(ctx)
    cameraProviderFuture.addListener({
        val cameraProvider = cameraProviderFuture.get()
        val preview = androidx.camera.core.Preview.Builder().build().also {
            it.setSurfaceProvider(previewView.surfaceProvider)
        }

        val cameraSelector = CameraSelector.Builder()
            .requireLensFacing(cameraSelection)
            .build()

        cameraProvider.unbindAll()

        runCatching {
            val useCaseGroup = UseCaseGroup.Builder()
                .addUseCase(preview)
                .apply {
                    val imageAnalysis = getImageAnalysis(executor, onImageProxy)
                    addUseCase(imageAnalysis)
                }
                .build()

            val camera = cameraProvider.bindToLifecycle(
                lifecycleOwner,
                cameraSelector,
                useCaseGroup
            )

            onCameraReady(camera)
        }
    }, executor)
}

fun getImageAnalysis(
    executor: Executor,
    onImageProxy: (ImageProxy) -> Unit = {},
): ImageAnalysis = with(ImageAnalysis.Builder()) {
    setTargetResolution(Size(640, 480))
    setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
    build()
}.apply {
    setAnalyzer(executor) { proxy -> onImageProxy(proxy) }
}

@Preview
@Composable
fun previewCameraView() {
    MilesHealthTheme {
        CameraView()
    }
}
