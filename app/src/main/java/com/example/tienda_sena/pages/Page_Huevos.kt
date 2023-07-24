package com.example.tienda_sena.pages

import android.content.Context
import android.graphics.BitmapFactory
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tienda_sena.R
import com.example.tienda_sena.componentes.CreateChannelNotification
import com.example.tienda_sena.componentes.Mapa
import com.example.tienda_sena.componentes.carnicos
import com.example.tienda_sena.componentes.notificationSencille

@Composable
fun Page_Huevos(){
    CardCarnicos()
}

@Composable
fun Carnicos(
    @DrawableRes drawable: Int,
    text: String,
    precio: String,
    descripcion: String,
    one: Double,
    two: Double
){
    val context: Context = LocalContext.current
    val icono1 = Icons.Default.FavoriteBorder
    val icono2 = Icons.Default.Favorite
    var icono by remember {
        mutableStateOf(icono1)
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(72.dp)
                .padding(start = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(id = drawable),
                    contentDescription = text,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                Modifier.width(170.dp)
            ) {
                Text(
                    text = text,
                    modifier = Modifier.padding(2.dp),
                    style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif)
                )
                Row {
                    Text(
                        text =  "Precio: ",
                        style = TextStyle(fontSize = 18.sp),
                        modifier = Modifier.padding(2.dp)
                    )
                    Text(
                        text =  precio,
                        style = TextStyle(fontSize = 18.sp),
                        modifier = Modifier.padding(2.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.width(12.dp))
            Row(){
                var openModal2 by remember {
                    mutableStateOf(false)
                }
                if(openModal2){
                    AlertDialog(
                        onDismissRequest = { openModal2 = false},
                        title = {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(text = "Ubicacion", style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold))
                                Text(text = text, style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))
                            }
                        },
                        icon = {
                            Card(
                                modifier = Modifier
                                    .width(300.dp)
                                    .height(450.dp)
                            ) {
                                Mapa(primer = one, Segundo = two, imagen = drawable, nombre = text)
                            }
                        },
                        confirmButton = {
                            Row() {
                                Button(onClick = {
                                    openModal2 = false
                                    Toast.makeText(context, "Confrimado", Toast.LENGTH_SHORT).show()
                                }) {
                                    Text(text = "Confirmar")
                                }
                            }
                        },
                    )
                }
                IconButton(onClick = { openModal2 = true}) {
                    Icon(imageVector = Icons.Default.LocationOn, contentDescription = null, modifier = Modifier.size(30.dp))
                }
            }
        }
        Image(
            painter = painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(236.dp)
                .fillMaxWidth()
                .padding(5.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Box(
            Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
        ){
            Spacer(modifier = Modifier.width(50.dp))
            Row(
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                boton()
                val context = LocalContext.current
                var openModal by remember {
                    mutableStateOf(false)
                }
                var count by rememberSaveable {
                    mutableStateOf(1)
                }
                if (openModal){
                    androidx.compose.material3.AlertDialog(
                        onDismissRequest = { openModal = false},
                        title = {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = text,
                                    style = TextStyle(fontSize = 35.sp, fontWeight = FontWeight.Bold)
                                )
                                Card(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(50.dp),
                                    elevation = CardDefaults.cardElevation(
                                        defaultElevation = 10.dp
                                    ),
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.Center
                                    ) {
                                        if(count == 0){
                                            androidx.compose.material3.IconButton(onClick = { /*TODO*/ }) {
                                                Icon(
                                                    imageVector = Icons.Filled.Delete,
                                                    contentDescription = null
                                                )
                                            }
                                        }else{
                                            androidx.compose.material3.IconButton(onClick = { count-- }) {
                                                Icon(
                                                    imageVector = Icons.Filled.Delete,
                                                    contentDescription = null
                                                )
                                            }
                                        }
                                        Text(
                                            text = "$count",
                                            style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold),
                                            //modifier = Modifier.padding(start = 5.dp, top = 5.dp, end = 5.dp)
                                        )
                                        androidx.compose.material3.IconButton(onClick = { count++ }) {
                                            Icon(
                                                imageVector = Icons.Default.Add,
                                                contentDescription = null
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(1.dp))
                                    }
                                }
                            }
                        },
                        icon = {
                            Image(
                                painter = painterResource(id = drawable),
                                contentDescription = text,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .height(250.dp)
                                    .fillMaxWidth()
                                    .size(64.dp)
                                    .clip(RoundedCornerShape(percent = 10)),
                            )
                        },
                        confirmButton = {
                            Row() {
                                Button(onClick = {
                                    openModal = false
                                    Toast.makeText(context, "$count ${text} en el carrito", Toast.LENGTH_SHORT).show()
                                }) {
                                    Text(text = "Comprar")
                                }
                                Spacer(modifier = Modifier.width(5.dp))
                                Button(onClick = {
                                    openModal = false
                                    Toast.makeText(context, "Confrimado", Toast.LENGTH_SHORT).show()
                                }) {
                                    Text(text = "Confirmar")
                                }
                            }
                        },
                        text = {
                            Text(
                                text = descripcion,
                                style = TextStyle(
                                    fontSize = 17.sp,
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(
                    onClick = { openModal = true}
                ) {
                    Text(text = "Ver Mas")
                }
            }

            val idNotication: Int = 0
            val idChannel: String = text
            val name: String = "Canal Tienda"
            val descriptionText: String = "Canal de Notificaciones Tienda CBA"

            val textShort: String = text + " en favoritos"
            val textLong: String = descripcion
            val iconoBig = BitmapFactory.decodeResource(
                context.resources,
                R.drawable.logooo
            )
            val imagenBig = BitmapFactory.decodeResource(
                context.resources,
                drawable
            )
            LaunchedEffect(Unit){
                CreateChannelNotification(
                    idChannel,
                    context,
                    name,
                    descriptionText
                )
            }
            Row(modifier = Modifier.align(Alignment.CenterEnd)) {
                IconButton(
                    onClick = {
                        icono = when(icono){
                            icono1 -> icono2
                            icono2 -> icono1
                            else -> icono1
                        }
                        notificationSencille(
                            context,
                            idChannel,
                            idNotication,
                            "Favoritos",
                            textShort
                        )
                    }
                ) {
                    Icon(imageVector = icono, contentDescription = null, modifier = Modifier.size(30.dp))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardCarnicos(
    modifier: Modifier = Modifier
){
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        modifier = modifier.height(700.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(listaCarnicos){ item ->
            Card(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(8.dp),
            ) {
                Carnicos(drawable = item.imagen, text = item.texto, precio = item.precio, descripcion = item.descripcion, one = item.primero, two = item.Segundo)
            }
        }
    }
}

val listaCarnicos = listOf(
    carnicos.carnicos1,
    carnicos.carnicos2,
    carnicos.carnicos3,
)