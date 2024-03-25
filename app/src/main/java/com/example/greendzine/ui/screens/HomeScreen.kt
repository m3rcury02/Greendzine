package com.example.greendzine.ui.screens


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.drawText
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.example.greendzine.R
import com.example.greendzine.VerticalGradient
import com.example.greendzine.data.EmpData
import com.example.greendzine.data.EmpProd
import com.example.greendzine.ui.theme.GreenPrimary
import kotlin.time.times

@Composable
fun HomeScreen() {
    val empData = EmpData()
    val empProds by remember { mutableStateOf(empData.loadEmpProd()) }
    VerticalGradient {
        Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            LogoWithBadge()
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50.dp))
                    .background(Color(0x655e5e5e))
                    .width(360.dp),
                    contentAlignment = Alignment.TopCenter
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(50.dp))
                       ,
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .background(Color(0xFF1A2C2C))
                            .clip(RoundedCornerShape(50.dp))
                            .padding(horizontal = 32.dp, vertical = 16.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Employee Productivity Dashboard",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                }
                ProductivityBars(empProds = empProds)
            }

        }
    }
}


@Composable
fun ProductivityBars(empProds: List<EmpProd>) {
    Column(
        modifier = Modifier
            .padding(horizontal = 32.dp,vertical = 64.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        empProds.forEach { empProd ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Productivity on ${empProd.Day}", color = Color.White)
                Text(text = "${empProd.ProdPerc}%")
            }

            LinearProgressIndicator(
                progress = { empProd.ProdPerc / 200f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(12.dp)
                    .clip(RoundedCornerShape(50))
                ,
                color = GreenPrimary,
                trackColor = Color.Transparent,
                strokeCap = StrokeCap.Round
            )
        }
    }
}


@Composable
fun LogoWithBadge() {
    Row {
        Spacer(modifier = Modifier.weight(1F))
        IconButton(
            onClick = { /*TODO: Handle click*/ },
            modifier = Modifier
                .padding(8.dp)
                .size(70.dp),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.care),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
        }
    }
    BadgedBox(
        badge = {
            Badge(
                containerColor = Color(0x5a5a5a5a),
                modifier = Modifier.size(32.dp)
            ) {
                Text("4", fontSize = 20.sp)
            }
        },
        modifier = Modifier
            .size(80.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.moptrologo),
            contentDescription = "Favorite",
            modifier = Modifier.size(100.dp)
        )
    }
    Spacer(modifier = Modifier.height(32.dp))
}

@Preview
@Composable
private fun PrevHome() {
    HomeScreen()
}