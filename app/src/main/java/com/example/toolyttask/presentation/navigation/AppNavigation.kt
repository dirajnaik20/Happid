package com.example.toolyttask.presentation.navigation

enum class Screen {
    LANDING,
    STARTED,
    LOGIN,
    OTP,
    PROFILE,
}
sealed class NavigationItem(val route: String) {
    object Landing : NavigationItem(Screen.LANDING.name)
    object Started : NavigationItem(Screen.STARTED.name)
    object Login : NavigationItem(Screen.LOGIN.name)
    object OTP : NavigationItem(Screen.OTP.name)
    object Profile : NavigationItem(Screen.PROFILE.name)
}