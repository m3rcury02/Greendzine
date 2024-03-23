package com.example.greendzine.ui.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.greendzine.Route
import com.example.greendzine.ui.Screen


data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateBack:()->Unit,
    navigateToProfile: () -> Unit,
    navigateToHome: () -> Unit
) {
    val navController = rememberNavController()
    val items= listOf(
        BottomNavigationItem(
            title = Route.HOMESCREEN,
            selectedIcon= Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
        ),
        BottomNavigationItem(
            title = Route.PROFILE,
            selectedIcon= Icons.Filled.AccountCircle,
            unselectedIcon = Icons.Outlined.AccountCircle,
        )
    )

    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    Scaffold (
        bottomBar = {
            NavigationBar {
                items.forEachIndexed{ index, item->
                    NavigationBarItem(selected = selectedItemIndex==index , onClick = {
                        selectedItemIndex=index
                        when (item.title) {
                            Route.HOMESCREEN -> navigateToHome()
                            Route.PROFILE -> navigateToProfile()
                        }
                    }, icon = { Icon(imageVector = if(index==selectedItemIndex){item.selectedIcon}else item.unselectedIcon,contentDescription = null ) })

                }


            }
        }
    ){it
        Column(

        ) {
            Text(text = "Home Screen")
            Button(onClick = navigateBack) {
                Text(text = "GO to login page")
            }
        }
    }



}


@Composable
fun ProfileScreen(navigateToHome: () -> Unit) {
    Text(text = "Profile Screen")
}
