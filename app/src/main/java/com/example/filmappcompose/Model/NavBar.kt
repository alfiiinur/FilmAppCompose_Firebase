package com.example.filmappcompose.Model

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.filmappcompose.Model.ScreensRoute.Home.route
import com.google.android.gms.wallet.Wallet

data class BottomNav(
    val title : String,
    val icon : ImageVector,
    val route  : String
)

sealed class ScreensRoute(val route: String){

    object Home :ScreensRoute(route = "Home_Screens")
    object GetStarted :ScreensRoute(route = "GetStarted")
    object LoginPage :ScreensRoute(route = "LoginPage")
    object SingUp :ScreensRoute(route = "SingUp")
    object ProfilePage :ScreensRoute(route = "ProfilePage")
    object DetailPage :ScreensRoute(route = "DetailPage")
    object PaymentPage :ScreensRoute(route = "PaymentPage")
}

val items = listOf(
    BottomNav(
        title = "Home",
        icon = Icons.Rounded.Home,
        route = ScreensRoute.Home.route
    ),
    BottomNav(
        title = "PaymentPage",
        icon = Icons.Rounded.Wallet,
        route = ScreensRoute.PaymentPage.route
    ),
    BottomNav(
        title = "DetailPage",
        icon = Icons.Rounded.ShoppingCart,
        route = ScreensRoute.DetailPage.route
    ),
    BottomNav(
        title = "ProfilePage",
        icon = Icons.Rounded.AccountCircle,
        route = ScreensRoute.ProfilePage.route
    )

)


@Composable
fun BottomNavigationBar(navController: NavController){
    NavigationBar {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surfaceVariant)
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->
                NavigationBarItem(
                    selected = currentRoute == item.route ,
                    onClick = {
                        navController.navigate(item.route){
                            navController.graph.startDestinationRoute?.let {
                                    currentRoute -> popUpTo(route){
                                saveState = true
                            }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                )
            }
        }
    }
}



@Preview
@Composable
fun PreviewBottomNavigationBar(){
    val navController = rememberNavController()
    BottomNavigationBar(navController = navController)
}
