package com.example.tienda_sena.ofertas

import com.example.tienda_sena.R
import com.example.tienda_sena.componentes.navigationScreen

sealed class ofertas_screen(
    val imagen: Int,
    val texto: String,
    val precio: String,
    val descripcion: String,
    val primero: Double,
    val Segundo: Double,
    val ruta: String,
){
    object tienda1: ofertas_screen(imagen = R.drawable.oferta1, texto = "Vegetales", precio = "5.000",
        descripcion = "Mañana gran oferta en todos los vegetales, no te quedes sin esta gran oferta",
        primero = 4.694168, Segundo = -74.218453, ruta = navigationScreen.vegetales.name
    )
    object tienda2: ofertas_screen(imagen = R.drawable.lacte, texto = "Lacteos", precio = "6.000",
        descripcion = "Mañana gran oferta en todos los lacteos, no te quedes sin esta gran oferta",
        primero = 4.695038, Segundo = -74.215446, ruta = navigationScreen.lacteos.name
    )
    object tienda3: ofertas_screen(imagen = R.drawable.ofer, texto = "Carnes", precio = "4.000",
        descripcion = "Mañana gran oferta en todos los carnes, no te quedes sin esta gran oferta",
        primero = 4.696385, Segundo = -74.214835, navigationScreen.carnes.name
    )
}

enum class navegador_ofertas{
    vegetales,
    lacteos,
    flores,
    carnes
}

