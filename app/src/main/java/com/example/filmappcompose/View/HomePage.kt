package com.example.filmappcompose.View

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.filmappcompose.Model.BottomNavigationBar


@Composable
fun HomePage(
    navController : NavController
){
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) {
            padding ->
        Column(
            modifier =  Modifier
                .fillMaxSize()
                .padding(padding)

        ) {
            Text(
                text = "HomePage"
            )
//            WalletSection()
//            CardSection()
            Spacer(modifier = Modifier.height(16.dp))
//            FinanceSection()
//            CurentsSection()
        }
    }
}