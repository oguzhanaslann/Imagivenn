package com.univerlist.commonui.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import timber.log.Timber

// dial number
fun Context.tryDialNumber(number: String?) {
    try {
        val uri = Uri.parse("tel:$number") ?: return
        val intent = Intent(Intent.ACTION_DIAL,uri)
        startActivity(intent)
    } catch (runtimeException: RuntimeException) {
        Timber.e("runtime exception when dialing number : $number, reason: ${runtimeException.message}")
        return
    } catch (nullPointerException: NullPointerException) {
        Timber.e("Null pointer exception when dialing number : $number, reason: ${nullPointerException.message}")
    }
}

// open in location in maps
fun Context.tryOpenInMaps(latitude: Double, longitude: Double) {
    try {
        val uri = Uri.parse("geo:$latitude,$longitude") ?: return
        val intent = Intent(Intent.ACTION_VIEW,uri)
        startActivity(intent)
    } catch (runtimeException: RuntimeException) {
        Timber.e("runtime exception when opening in maps : $latitude, $longitude, reason: ${runtimeException.message}")
        return
    } catch (nullPointerException: NullPointerException) {
        Timber.e("Null pointer exception when opening in maps : $latitude, $longitude, reason: ${nullPointerException.message}")
    }
}

fun Context.tryOpenInMaps(location: android.location.Location) {
    tryOpenInMaps(location.latitude, location.longitude)
}
