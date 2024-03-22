package com.example.greendzine.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.greendzine.R
import com.example.greendzine.ui.theme.GreenPrimary
import com.example.greendzine.ui.theme.GreyField

@Composable
fun Login() {

    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 54.dp, vertical = 164.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        TitleLogo()
        TextBox(Modifier.fillMaxWidth().padding(4.dp))
    }

}

@Composable
fun TitleLogo() {
    Image(modifier=Modifier.size(88.dp),painter = painterResource(id = R.drawable.gzlogo2x), contentDescription = "GT Logo")
    Text(text = "#We are Electric")
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun TextBox(modifier: Modifier) {
    var email by remember{
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }
    TextField(modifier = modifier,value = email, onValueChange = {email=it}, label = { Text(text = "E-mail")}, shape = RoundedCornerShape(percent = 50), colors = TextFieldDefaults.colors(
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        unfocusedContainerColor = GreyField
    ))
    TextField(visualTransformation = PasswordVisualTransformation(),modifier = modifier,value = password, onValueChange = {password=it}, label = { Text(text = "Password")}, shape = RoundedCornerShape(percent = 50), colors = TextFieldDefaults.colors(
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        unfocusedContainerColor = GreyField
    ))
    Spacer(modifier = Modifier.height(16.dp))
    ElevatedButton(modifier = modifier,onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
        containerColor = GreenPrimary)
    ) {
        Text(text = "Login")
    }
    TextButton(onClick = { /*TODO*/ }) {
        Text(text = "Forgot Password?")
    }
}

@Preview(showBackground = true)
@Composable
private fun PrevLogin() {
    Login()
}