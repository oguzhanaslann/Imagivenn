package com.univerlist.commonui.util

import android.content.Context
import android.net.Uri
import androidx.annotation.DrawableRes

fun getUriOfDrawable(context: Context, @DrawableRes drawableId: Int): Uri = context.run {
    Uri.parse("android.resource://$packageName/$drawableId")
}

fun getUrlOfDrawable(context: Context, @DrawableRes drawableId: Int): String =
    getUriOfDrawable(context, drawableId).toString()
