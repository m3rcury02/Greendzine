package com.example.greendzine.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greendzine.VerticalGradient
import com.example.greendzine.data.EmpData
import com.example.greendzine.data.Employees
import com.example.greendzine.ui.theme.GreenPrimary

@Composable
fun ProfileScreen() {
    var searchText by remember {
        mutableStateOf("")
    }
        VerticalGradient {
            Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
               LogoWithBadge()
                TextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    shape = RoundedCornerShape(40),
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = null,
                            tint = Color.White
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color(0xFF141615),
                        focusedContainerColor = Color(0xFF141615),
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent
                    ),
                    placeholder = {
                        Text(
                            "Search by name",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    },
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 24.dp)
                )
                EmpList(employeeList = EmpData().loadEmpData(), searchText = searchText)
            }
        }

}

@Composable
fun EmpList(employeeList: List<Employees>, searchText: String) {
    val filteredList = employeeList.filter { it.Name.contains(searchText, ignoreCase = true) }
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        items(filteredList) {
            EmpCard(employees = it)
        }
    }
}


@Composable
fun EmpCard(employees: Employees) {

    BadgedBox(
        badge = {
            Badge(
                containerColor = Color(0x5a5a5a5a),
                modifier = Modifier
                    .size(32.dp)
                    .offset(x = (-32).dp, y = 32.dp)
                    .border(1.dp, Color.Black, CircleShape)
            ) {
                Text(employees.ID.toString(), fontSize = 20.sp, color = Color.White)
            }
        },

        ) {
        Card(
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 20.dp)
                .fillMaxSize(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF111816))
        ) {
            Column(modifier = Modifier.padding(10.dp)) {

                val empIdText = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append("EMP ID  :   ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(employees.ID.toString())
                    }
                }
                Text(text = empIdText, fontSize = 16.sp, modifier = Modifier.padding(8.dp))

                val nameText = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append("Name    :   ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(employees.Name)
                    }
                }
                Text(text = nameText, fontSize = 16.sp, modifier = Modifier.padding(8.dp))

                val dobText = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append("DOB       :  ")
                    }
                    withStyle(style = SpanStyle(color = Color(0xffB77420))) {
                        append(employees.DOB)
                    }
                }
                Text(text = dobText, fontSize = 16.sp, modifier = Modifier.padding(8.dp))

                val roleText = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append("Role       :   ")
                    }
                    withStyle(style = SpanStyle(color = GreenPrimary)) {
                        append(employees.Role)
                    }
                }
                Text(text = roleText, fontSize = 16.sp, modifier = Modifier.padding(8.dp))
            }
        }
    }

}

@Preview
@Composable
private fun PrevProf() {
    ProfileScreen()
}