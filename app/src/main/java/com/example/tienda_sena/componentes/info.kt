package com.example.tienda_sena.componentes

sealed class info(
    val nombre: String,
    val informacion: String
){
    object primera: info(nombre = "Contactos", informacion = "Telefono:  3227330590  " + "  Telefono:  3207220349")
    object segunda: info(nombre = "Correos", informacion = "tiendasena@gmail.com")
    object tercera: info(nombre = "Metodos de Pago", informacion = "Nequi - Daviplata")
}
