package com.example.restaranteargueta.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.restaranteargueta.R
import com.example.restaranteargueta.ui.theme.RestaurantColor
import com.example.restaranteargueta.ui.theme.cardColor

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun Login(navController: NavController){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
             TopBar()
        }
    ){innerPadding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier=Modifier.padding(innerPadding)
                .fillMaxSize()

        ) {

           OutlinedCard(
               colors = CardDefaults.cardColors(
                   containerColor = cardColor
               ), modifier = Modifier
                   .fillMaxWidth()
                   .height(550.dp)
                   .fillMaxWidth()
                   .padding(10.dp)


           ) {
               Column(
                   verticalArrangement = Arrangement.Center,
                   horizontalAlignment = Alignment.CenterHorizontally,
                   modifier = Modifier.fillMaxSize()
               ) {
                   Text(text = "Bienvenido",
                       fontSize = 24.sp,
                       fontWeight = FontWeight.Bold
                       )

                   OutlinedTextField(
                       value = email,
                       onValueChange = { email = it },
                       label = { Text("Correo electrónico") },
                       textStyle = TextStyle(Color.Black, fontSize = 20.sp),
                       colors=TextFieldDefaults.outlinedTextFieldColors(
                           containerColor = Color.White,
                           focusedBorderColor = RestaurantColor,
                           unfocusedBorderColor =Color.Black    
                       ),
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(20.dp)
                   )

                   OutlinedTextField(
                       value = password,
                       onValueChange = { password = it },
                       visualTransformation = PasswordVisualTransformation(),
                       label = { Text("Contraseña"
                           ) },

                       textStyle = TextStyle(Color.Black, fontSize = 20.sp),
                       colors=TextFieldDefaults.outlinedTextFieldColors(
                           containerColor = Color.White,
                           focusedBorderColor = RestaurantColor,
                           unfocusedBorderColor = Color.Black
                       ),
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(20.dp)
                   )

                   Button(onClick = {},
                       modifier=Modifier.width(190.dp),
                       colors=ButtonDefaults.buttonColors(
                           containerColor = RestaurantColor,
                           contentColor = Color.White
                       )) {
                       Text(text = "Iniciar Sesión", fontSize = 20.sp, color=Color.Black)


                   }



                   Spacer(modifier = Modifier.height(10.dp))
                   Button(onClick = {
                       navController.navigate("registro")
                   },
                       modifier=Modifier.width(190.dp)
                           .padding(top = 10.dp),
                       colors=ButtonDefaults.buttonColors(
                           containerColor =Color.White,
                           contentColor = Color.Black
                       )
                   ) {
                       Text("Registrarse",

                           fontSize = 20.sp,
                           modifier=Modifier.padding(end = 20.dp),
                           color=Color.Black
                       )
                       Image(painter=painterResource(id = R.drawable.account_plus), contentDescription = null)
                   }

                   Spacer(modifier = Modifier.height(10.dp))
                   Text("O inicia con ", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp))


                   Button(onClick = {},
                       modifier=Modifier.width(190.dp)
                           .padding(top = 10.dp),
                       colors = ButtonDefaults.buttonColors(
                           containerColor = Color.White,
                           contentColor = Color.Black
                       )
                   ) {
                       Text("Google",
                           modifier=Modifier.padding(end = 20.dp),
                           fontSize = 20.sp,
                           color=Color.Black
                       )
                       Image(painter=painterResource(id = R.drawable.google), contentDescription = null)
                   }






               }
           }
            
        }

    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){
    CenterAlignedTopAppBar(
        title = {
            Text(text = "Restaurante Argueta")
        },
        colors= TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = RestaurantColor
        )


    )
}