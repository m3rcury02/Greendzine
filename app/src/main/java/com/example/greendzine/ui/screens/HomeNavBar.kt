package com.example.greendzine.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.greendzine.EndGradient
import com.example.greendzine.Route
import com.example.greendzine.VerticalGradient
import com.example.greendzine.ui.theme.GreenPrimary


data class BottomNavigationItem(
    val title: String,
    val icon: ImageVector,
)

@Composable
fun HomeNavBar() {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavigationItem(
            title = Route.HOMEPAGE, icon = Icons.Filled.Home
        ), BottomNavigationItem(
            title = Route.PROFILE,
            icon = Icons.Filled.AccountCircle,
        )
    )
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    VerticalGradient {
        Scaffold(bottomBar = {
            EndGradient() {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStartPercent = 50, topEndPercent = 50))
                        .background(Color(0xFF0F2323))

                ) {
                    NavigationBar(
                        containerColor = Color.Transparent,
                        modifier = Modifier.height(64.dp)
                    ) {
                        items.forEachIndexed { index, item ->
                            NavigationBarItem(selected = selectedItemIndex == index, onClick = {
                                selectedItemIndex = index
                                navController.navigate(item.title)
                            }, icon = {
                                Box(
                                    modifier = Modifier
                                        .size(if (selectedItemIndex == index) 184.dp else 48.dp)

                                ) {
                                    Icon(
                                        imageVector = item.icon,
                                        contentDescription = null,
                                        tint = GreenPrimary,
                                        modifier = Modifier
                                            .size(40.dp)
                                            .align(Alignment.Center)
                                    )
                                }
                            })
                        }
                    }
                }
            }
        }) {
            NavHost(
                navController = navController,
                startDestination = Route.HOMEPAGE,
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
            ) {
                composable(route = Route.PROFILE) {
                    ProfileScreen()
                }
                composable(route = Route.HOMEPAGE) {
                    HomeScreen()
                }
            }
        }
    }
}

@Preview
@Composable
private fun PrevNavBar() {
    HomeNavBar()
}


