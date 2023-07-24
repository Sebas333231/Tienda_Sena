package com.example.tienda_sena.componentes

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tienda_sena.R
import com.example.tienda_sena.login.LoginCreen
import com.example.tienda_sena.ofertas.navegador_ofertas
import com.example.tienda_sena.ofertas.pages_ofertas.Carnes_Screen_Ofertas
import com.example.tienda_sena.ofertas.pages_ofertas.Vegetales_Screen
import com.example.tienda_sena.ofertas.pages_ofertas.lacte
import com.example.tienda_sena.pages.HomeCreen
import com.example.tienda_sena.pages.SplashScreen

@Composable
fun NavigationControllerScreen(
    informacion: Uri,
    video: Uri
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = navigationScreen.SplashScreen.name
    ){
        composable(navigationScreen.SplashScreen.name){
            SplashScreen(navController = navController, informacion)
        }
        composable(navigationScreen.LoginScreen.name){
            LoginCreen(navController = navController, video)
        }
        composable(navigationScreen.HomeScreen.name){
            MainPage(navController = navController, navController)
        }
        composable(navigationScreen.carnes.name){
            Carnes_Screen_Ofertas(navController = navController)
        }
        composable(navigationScreen.lacteos.name){
            lacte(navController = navController)
        }
        composable(navigationScreen.vegetales.name){
            Vegetales_Screen(navController = navController)
        }
    }
}