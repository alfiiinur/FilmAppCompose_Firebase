package com.example.filmappcompose.Model

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.filmappcompose.View.*

@Composable
fun RoouteNav(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = ScreensRoute.Home.route){
        composable(
            route = ScreensRoute.Home.route
        ){
            HomePage(navController)
        }
        composable(
            route = ScreensRoute.PaymentPage.route
        ){
            PaymentPage(navController)
        }
        composable(
            route = ScreensRoute.DetailPage.route
        ){
            DetailPage(navController)
        }
        composable(
            route = ScreensRoute.ProfilePage.route
        ){
            ProfilePage(navController)
        }
    }
}

@Composable
fun GetStartedNav(
    navController: NavHostController
){
    NavHost(navController = navController, startDestination = ScreensRoute.GetStarted.route){
        composable(
            route = ScreensRoute.GetStarted.route
        ){
            GetStartedView(navController)
        }
        composable(
            route = ScreensRoute.SingUp.route
        ){
            Singup(navController)
        }
        composable(
            route = ScreensRoute.LoginPage.route
        ){
            LoginPage(navController)
        }
    }
}