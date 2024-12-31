package com.example.restaranteargueta.navManager

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.restaranteargueta.view.Login
import com.example.restaranteargueta.view.Registro

@Composable
fun NavManager(){
    val navController=rememberNavController()
    NavHost(navController = navController, startDestination = "login"){
        composable("login"){
            Login(navController)
        }
        composable("registro"){
            Registro(navController)
        }
    }
}