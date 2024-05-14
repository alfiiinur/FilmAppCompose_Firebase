package com.example.filmappcompose.View

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.filmappcompose.Model.ScreensRoute.Home.route
import com.example.filmappcompose.ui.theme.*
import com.example.filmappcompose.R

@Composable
fun GetStartedView(
    navController : NavController
){
    val GradientBg = Brush.verticalGradient(
        0.0f to WhiteLayer,
        1.0f to bgLayer,
        startY = 0.0f,
        endY = 2000.0f
    )
    Box(
        modifier = Modifier
            .background(GradientBg)
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Animasi Film",
                fontSize = 20.sp,
                fontFamily = FontGopher,
                fontWeight = FontWeight.Medium,
                fontStyle = FontStyle.Italic,
                color = fontColor
            )
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Box {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "Watch the best Movies in Earth",
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic,
                            fontSize = 35.sp,
                            fontFamily = FontGopher,
                            color = fontColor,
                            textAlign = TextAlign.Start
                        )
                        Text(
                            text = "Cheper and more convenient",
                            fontSize = 20.sp,
                            fontFamily = FontGopher,
                            fontWeight = FontWeight.Normal,
                            color = fontColor
                        )
                    }
                    Image(
                        painter = painterResource(R.drawable.cek),
                        contentDescription = "ceklis",
                        modifier = Modifier
                            .size(100.dp)

                    )
                }
                Column(
                    modifier = Modifier
                        .padding(bottom = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.imgae13d),
                        contentDescription = "image3d",
                        modifier = Modifier
                            .size(300.dp)
                    )
                    Text(
                        text = "Aplikasi film adalah platform digital yang memungkinkan pengguna untuk menonton, mencari, dan menemukan film dari berbagai genre dan sutradara.",
                        fontFamily = FontGopher,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        color = fontColor,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(Modifier.height(10.dp))
                Column(
                    modifier = Modifier
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(30.dp))
                            .width(300.dp)
                            .height(50.dp)
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        Aqua, Orange, Ungu
                                    )
                                )
                            )
                    ){
                        Button(
                            onClick = {
                                navController.navigate(route){
                                    navController.graph.startDestinationRoute?.let {
                                        currentRoute -> popUpTo(route){
                                            saveState = true
                                    }
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }

                            },
                            modifier = Modifier
                                .width(300.dp)
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                            border = BorderStroke(1.dp, color = fontColor)
                        ) {
                            Text(
                                text = "Get Started",
                                fontFamily = FontGopher,
                                fontWeight = FontWeight.Normal,
                                color = fontColor
                            )
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Row {
                        Text(
                            text = "Already have Account ? ",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontGopher,
                            color = fontColor
                        )
                        Text(
                            text = "Login",
                            fontSize = 15.sp,
                            fontFamily = FontGopher,
                            fontWeight = FontWeight.Medium,
                            color = fontLogin
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewGetStarted(){
    GetStartedView(navController = rememberNavController())
}