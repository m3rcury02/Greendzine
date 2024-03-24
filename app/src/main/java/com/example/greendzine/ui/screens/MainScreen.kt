package com.example.greendzine.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.greendzine.Route


@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.LOGIN) {
        composable(route = Route.LOGIN) {
            Login(
                navigateToHome = {
                    navController.navigate(Route.HOMESCREEN) {
                        popUpTo(Route.LOGIN) { inclusive = true }
                    }
                }
            )
        }
        composable(route = Route.HOMESCREEN) {
            HomeScreen()
        }
    }
}

