package com.example.greendzine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.greendzine.ui.screens.Login
import com.example.greendzine.ui.theme.GreendzineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GreendzineTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    VerticalGradient()
                    Login()
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
            Login()
        }
    }
}
