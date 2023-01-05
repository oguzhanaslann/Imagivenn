package com.univerlist.commonui.components

import androidx.compose.foundation.Image
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import coil.compose.SubcomposeAsyncImage
import com.univerlist.commonui.util.emptyComposable

@Composable
fun ShapeableImage(
    modifier: Modifier = Modifier,
    painter: Painter? = null,
    shape: Shape = RectangleShape,
    placeHolderColor: Color = Color.LightGray,
    contentScale: ContentScale = ContentScale.Crop,
    contentDescription: String? = null
) {
    Surface(
        modifier = modifier,
        shape = shape,
        color = if (painter == null) placeHolderColor else placeHolderColor.copy(0f)
    ) {
        if (painter != null) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = contentScale
            )
        }
    }
}

@Composable
fun ShapeableImage(
    modifier: Modifier = Modifier,
    imageUrl: String,
    shape: Shape = RectangleShape,
    placeHolderColor: Color = Color.LightGray,
    contentScale: ContentScale = ContentScale.Crop,
    contentDescription: String? = null
) {

    PreviewDispatchedView(
        mainContent = {
            when {
                imageUrl.isNotEmpty() -> SubcomposeAsyncImage(
                    modifier = modifier,
                    model = imageUrl,
                    contentDescription = contentDescription,
                    loading = { EmptyImageSurface(modifier, shape, placeHolderColor) },
                    error = { EmptyImageSurface(modifier, shape, placeHolderColor) },
                    success = {
                        ShapeableImage(
                            modifier = modifier,
                            painter = painter,
                            shape = shape,
                            placeHolderColor = placeHolderColor,
                            contentScale = contentScale,
                            contentDescription = contentDescription
                        )
                    },
                    contentScale = contentScale
                )
                else -> EmptyImageSurface(modifier, shape, placeHolderColor)
            }
        },
        previewContent = { EmptyImageSurface(modifier, shape, placeHolderColor) }
    )
}

@Composable
private fun EmptyImageSurface(
    modifier: Modifier,
    shape: Shape,
    placeHolderColor: Color
) {
    Surface(
        modifier = modifier,
        shape = shape,
        color = placeHolderColor,
        content = emptyComposable
    )
}
