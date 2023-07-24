package com.example.tienda_sena.componentes

import com.example.tienda_sena.R

sealed class items_bar(
    val icon: Int,
    val title: String,
    val ruta: String
){
    object Boton1: items_bar(R.drawable.outline_directions_bike_24, "Incio", "Boton1")
    object Boton2: items_bar(R.drawable.outline_two_wheeler_20, "Contenidos", "Boton2")
    object Boton3: items_bar(R.drawable.outline_recycling_20, "Informacion", "Boton3")
}
