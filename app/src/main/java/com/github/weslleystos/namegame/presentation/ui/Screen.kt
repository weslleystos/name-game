package com.github.weslleystos.namegame.presentation.ui

sealed class Screen(val route: String) {
    data object StartScreen: Screen("start")
    data object GameScreen: Screen("game/{type}")
}

fun Screen.GameScreen.getRoute(type: String): String {
    return route.replace("{type}", type)
}