package com.example.greendzine.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.greendzine.Route
import com.example.greendzine.VerticalGradient


data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

@Composable
fun HomeScreen() {
    val navController = rememberNavController()


    val items = listOf(
        BottomNavigationItem(
            title = Route.HOMEPAGE,
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
        ),
        BottomNavigationItem(
            title = Route.PROFILE,
            selectedIcon = Icons.Filled.AccountCircle,
            unselectedIcon = Icons.Outlined.AccountCircle,
        )
    )
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    Scaffold(

        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                        selectedItemIndex = index
                        navController.navigate(item.title)
                    }, icon = { Icon(imageVector = if (index == selectedItemIndex) item.selectedIcon else item.unselectedIcon, contentDescription = null) })
                }
            }
        }
    ) {
        VerticalGradient()
        NavHost(navController = navController, startDestination = Route.HOMEPAGE, modifier = Modifier.padding(it)) {
            composable(route = Route.PROFILE) {
                ProfileScreen()
            }
            composable(route = Route.HOMEPAGE) {
                HomePage()
            }
        }
    }
}


@Composable
fun HomePage() {
    VerticalGradient()
    Text(text = "Home Screen")

    
}
@Composable
fun ProfileScreen() {
    Text(text = "Profile Screen")
}
