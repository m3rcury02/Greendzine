package com.example.greendzine.ui

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
}
