package com.example.filmappcompose.View

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun DetailPage(
    navController : NavController
){
    Box(
        modifier = Modifier
    ){
        Text(
            text = "detail page"
        )
    }
}