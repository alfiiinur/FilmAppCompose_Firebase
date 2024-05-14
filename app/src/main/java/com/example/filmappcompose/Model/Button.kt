package com.example.filmappcompose.Model

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.filmappcompose.ui.theme.*

@Composable
fun ButtonSingUp(
    iconImage : ImageVector, textSingup : String
){
    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .shadow(elevation = 2.dp, shape = RoundedCornerShape(10.dp), clip = true)
    ){
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){
            Icon(
                imageVector = iconImage,
                contentDescription = "icon singup",
                modifier = Modifier
                    .padding(end = 10.dp)
            )
            Text(
                text = textSingup,
                fontFamily = FontGopher,
                fontWeight = FontWeight.Medium,
                fontSize = 10.sp,
                color = fontColor
            )
        }
    }
}


@Composable
fun ButtonForm(emailSing: String, passSing : String){
    var text by remember { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    val gradientSingup = remember {
        Brush.horizontalGradient(
            colors = listOf(Aqua, Orange, Ungu)
        )
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Column {
            OutlinedTextField(
                value = text,
                onValueChange = {text = it},
                label = { Text((emailSing)) },
                textStyle = TextStyle(gradientSingup, fontFamily = FontGopher, fontWeight = FontWeight.Medium),
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = password,
                onValueChange = {password = it},
                label = { Text((passSing)) },
                textStyle = TextStyle(gradientSingup, fontFamily = FontGopher, fontWeight = FontWeight.Medium),
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(
                            imageVector = if (passwordVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            contentDescription = if (passwordVisibility) "Hide password" else "Show password"
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
