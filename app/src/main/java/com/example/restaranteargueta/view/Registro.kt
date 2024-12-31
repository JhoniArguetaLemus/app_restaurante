package com.example.restaranteargueta.view


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.restaranteargueta.ui.theme.RestaurantColor
import com.example.restaranteargueta.ui.theme.cardColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Registro(navController: NavController){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showAlert by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopBar()
        }
    ){innerPadding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier= Modifier.padding(innerPadding)
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
                    Text(text = "Registro",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    OutlinedTextField(
                        value = email,
                        singleLine = true,
                        onValueChange = { email = it },
                        label = { Text("Correo electrónico") },
                        textStyle = TextStyle(Color.Black, fontSize = 20.sp),
                        colors= TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White,
                            focusedBorderColor = RestaurantColor,
                            unfocusedBorderColor = Color.Black
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    )

                    OutlinedTextField(
                        value = password,
                        visualTransformation = PasswordVisualTransformation(),
                        singleLine = true,
                        onValueChange = { password = it },
                        label = { Text("Contraseña"
                        ) },
                        textStyle = TextStyle(Color.Black, fontSize = 20.sp),
                        colors= TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White,
                            focusedBorderColor = RestaurantColor,
                            unfocusedBorderColor = Color.Black
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    )

                    Button(onClick = {
                        showAlert=true
                    },
                        modifier= Modifier.width(190.dp),
                        colors= ButtonDefaults.buttonColors(
                            containerColor = RestaurantColor,
                            contentColor = Color.White
                        )) {
                        Text(text = "Crear cuenta", fontSize = 20.sp, color= Color.Black)


                    }











                }
            }

        }

    }


    if(showAlert){
        Alerta(title = "Cuenta creada", onDismiss={showAlert=false}, onConfirm={showAlert=false; navController.popBackStack()})
    }





}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Alerta(title:String, onDismiss:() -> Unit, onConfirm:() -> Unit){
    AlertDialog(
        title={Text("Alerta")},
        text={Text("Cuenta creada exitosamente", fontSize = 20.sp)},
        confirmButton = {
           Button(onClick = {onConfirm()}) {
               Text("Aceptar", color = Color.Black)
           }
        },
        onDismissRequest = { onDismiss() }
    )

}