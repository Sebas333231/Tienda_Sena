package com.example.tienda_sena.pages

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tienda_sena.R
import com.example.tienda_sena.componentes.Current_Route
import com.example.tienda_sena.componentes.Ofertas_dos
import com.example.tienda_sena.componentes.navigationScreen
import com.example.tienda_sena.ofertas.NavegadorOfertas
import com.example.tienda_sena.ofertas.navegador_ofertas
import com.example.tienda_sena.ofertas.ofertas_screen

@Composable
fun Page_Contenidos(
    navController: NavController
){
    CardsOfertas(navController = navController)
}

@Composable
fun Ofertas_Screen(
    @DrawableRes drawable: Int,
    text: String,
    precio: String,
    descripcion: String,
    one: Double,
    two: Double,
    ruta: String
) {
    val context: Context = LocalContext.current
    val icono1 = Icons.Default.FavoriteBorder
    val icono2 = Icons.Default.Favorite
    var icono by remember {
        mutableStateOf(icono1)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(270.dp)
                .width(400.dp)
                .size(54.dp)
                .clip(RoundedCornerShape(percent = 10))
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardsOfertas(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var openModal2 by remember {
        mutableStateOf(false)
    }
    if(openModal2){
        AlertDialog(
            onDismissRequest = {openModal2 = false},
            title = {
                Text(text = "Hola")
            },
            confirmButton = {}
        )
    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        modifier = modifier.height(700.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(listaofertas){item ->
            Card(
                onClick = {
                          navController.navigate(item.ruta)
                          //openModal2 = true
                },
                modifier = Modifier.padding(4.dp)
            ) {
                Ofertas_Screen(
                    drawable = item.imagen,
                    text = item.texto,
                    precio = item.precio,
                    descripcion = item.descripcion,
                    one = item.primero,
                    two = item.Segundo,
                    ruta = item.ruta
                )
            }

        }
    }
}



val listarutas = listOf(
    Ofertas_dos.Oferta1,
    Ofertas_dos.Oferta2,
    Ofertas_dos.Oferta3
)

val listaofertas = listOf(
    ofertas_screen.tienda1,
    ofertas_screen.tienda2,
    ofertas_screen.tienda3,
)

