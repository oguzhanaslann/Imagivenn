package com.univerlist.commonui.base

import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import java.util.Objects

abstract class Screen(val route: String) {
    companion object {
        fun route(routeBase: String, vararg screenArgs: String): String {
            var route = routeBase
            screenArgs.forEach { route = route.plus("/{$it}") }
            return route
        }
    }
}

fun NavHostController.navigate(screen: Screen) {
    navigate(screen.route)
}


fun NavHostController.navigate(screen: Screen, builder: NavOptionsBuilder.() -> Unit) {
    navigate(screen.route,builder)
}
