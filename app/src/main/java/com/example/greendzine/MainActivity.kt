package com.example.greendzine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.greendzine.ui.screens.HomeScreen
import com.example.greendzine.ui.screens.Login
import com.example.greendzine.ui.screens.ProfileScreen
import com.example.greendzine.ui.theme.GreendzineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            GreendzineTheme {
                val navController = rememberNavController()

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val barColor=Color.Black.toArgb()


                    VerticalGradient()
                    NavHost(navController=navController, startDestination = Route.LOGIN){
                    composable(route=Route.LOGIN){
                        Login (
                            navigateToHome = {
                                navController.navigate(Route.HOMESCREEN)
                            }
                        )
                    }
                    composable(route=Route.HOMESCREEN){
                        HomeScreen (
                            navigateBack = {
                                navController.popBackStack()
                            },
                            navigateToProfile={
                                navController.navigate(Route.PROFILE)
                            },
                            navigateToHome = {}
                        )
                    }
                        composable(route= Route.PROFILE){
                            ProfileScreen (
                                navigateToHome = {
                                    navController.navigate(Route.HOMESCREEN)
                                }
                            )
                        }
                }
                }
            }
        }
    }
}




@Composable
fun VerticalGradient() {
    val gradient = Brush.verticalGradient(
        listOf(Color.Black, Color(0xff000e09)),
        startY = 0.0f,
        endY = Float.POSITIVE_INFINITY
    )
    Box(modifier = Modifier.background(gradient))

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GreendzineTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            VerticalGradient()
        }
    }
}

object Route{
    const val LOGIN = "Login"
    const val HOMESCREEN="HomeScreen"
    const val PROFILE="ProfileScreen"
}