package com.hgh.hotelcompose.screen


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController



@Composable
fun Home(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Homepage", style = TextStyle(fontSize = 50.sp))
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}