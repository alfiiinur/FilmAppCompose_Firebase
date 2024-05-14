package com.example.filmappcompose.View

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Facebook
import androidx.compose.material.icons.rounded.Fax
import androidx.compose.material.icons.rounded.OpenInBrowser
import androidx.compose.material.icons.rounded.Whatsapp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.filmappcompose.Model.ButtonForm
import com.example.filmappcompose.Model.ButtonSingUp
import com.example.filmappcompose.Model.ScreensRoute
import com.example.filmappcompose.ui.theme.*

@Composable
fun Singup(
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
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Create Free Account",
                fontSize = 20.sp,
                fontFamily = FontGopher,
                fontWeight = FontWeight.Medium,
                color = fontColor

            )
            Spacer(Modifier.height(10.dp))
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                ButtonSingUp(iconImage = Icons.Rounded.Fax, textSingup = "Sing Up with Fax")
                ButtonSingUp(iconImage = Icons.Rounded.Facebook, textSingup = "Sing Up with Facebook")
                ButtonSingUp(iconImage = Icons.Rounded.Whatsapp, textSingup = "Sing Up with WhatsApp")
            }
            Spacer(Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(
                    thickness = 1.dp,
                    color = fontColor.copy(0.5f),
                    modifier = Modifier
                        .weight(1f)
                )
                Text(
                    text = "or Sing Up with email",
                    fontSize = 10.sp,
                    fontFamily = FontGopher,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Italic,
                    color = fontColor,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Divider(
                    thickness = 1.dp,
                    color = fontColor.copy(0.5f),
                    modifier = Modifier.weight(1f)
                )
            }
            //FORM LOGIN EMAIL
            ButtonForm("Email", "Password")

            Spacer(Modifier.height(10.dp))
            //button im ready
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
            ) {
                Button(
                    onClick = {
                        navController.navigate(ScreensRoute.Home.route) {
                            navController.graph.startDestinationRoute?.let { currentRoute ->
                                popUpTo(ScreensRoute.Home.route) {
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
                        text = "I'm Ready",
                        fontFamily = FontGopher,
                        fontWeight = FontWeight.Normal,
                        color = fontColor
                    )
                }
            }

            val text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = 10.sp, fontFamily = FontGopher, fontWeight = FontWeight.Normal, color = fontColor)) {
                    append("Thank you accept our standard ")
                }
                withStyle(style = SpanStyle(fontSize = 10.sp, fontFamily = FontGopher, fontWeight = FontWeight.Normal, textDecoration = TextDecoration.Underline, color = fontColor, fontStyle = FontStyle.Italic)) {
                    append("terms and condition and our privacy policy.")
                }
            }

            Text(text = text, textAlign = TextAlign.Center, modifier = Modifier.padding(20.dp))


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


@Composable
@Preview
fun PreviewSingUp(){
    Singup(navController = rememberNavController())
}