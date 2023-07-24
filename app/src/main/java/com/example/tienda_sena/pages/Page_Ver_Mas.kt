package com.example.tienda_sena.pages


import android.content.Context
import android.graphics.BitmapFactory
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
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
import com.example.tienda_sena.componentes.noticias
import com.example.tienda_sena.componentes.notificationExtensa

@Composable
fun Page_Ver_Mas(){
    CardNoticias()
}

@Composable
fun Noticias(
    @DrawableRes drawable: Int,
    text: String,
    descripcion: String,
    one: Double,
    two: Double
){
    val context: Context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .background(color = Color.LightGray)
                .fillMaxWidth()
                .height(194.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Column() {
                Text(
                    text = text,
                    modifier = Modifier.padding(2.dp),
                    style = TextStyle(fontSize = 23.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif)
                )
            }
            Spacer(modifier = Modifier.width(30.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                boton2()
                val context = LocalContext.current
                var openModal by remember {
                    mutableStateOf(false)
                }
                if (openModal){
                    androidx.compose.material3.AlertDialog(
                        onDismissRequest = { openModal = false},
                        title = {
                            Text(
                                text = text,
                                style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
                            )
                        },
                        icon = {
                            Image(
                                painter = painterResource(id = drawable),
                                contentDescription = text,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .height(250.dp)
                                    .fillMaxWidth()
                            )
                        },
                        confirmButton = {
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
                            TextButton(
                                onClick = {
                                    openModal = false
                                    openModal2 = true
                                    Toast.makeText(context, "Ubicacion", Toast.LENGTH_SHORT).show()
                                }
                            ) {
                                Text(text = "Ubicacion")
                            }
                            TextButton(onClick = {
                                openModal = false
                                Toast.makeText(context, "Confrimado", Toast.LENGTH_SHORT).show()
                            }) {
                                Text(text = "Confirmar")
                            }
                        },
                        text = {
                            Text(
                                text =descripcion,
                                style = TextStyle(
                                    fontSize = 17.sp,
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                    )
                }

                val idNotication: Int = 0
                val idChannel: String = text
                val name: String = "Canal Tienda"
                val descriptionText: String = "Canal de Notificaciones Tienda CBA"

                val textShort: String = "Informacion acerca de su producto"
                val textLong: String = descripcion
                val iconoBig = BitmapFactory.decodeResource(
                    context.resources,
                    drawable
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
                Button(
                    onClick = {
                        openModal = true
                        notificationExtensa(
                            context,
                            idChannel,
                            idNotication + 1,
                            "Noticias",
                            textLong,
                            iconoBig
                        )
                    }
                ) {
                    Text(text = "Ver Mas")
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardNoticias(
    modifier: Modifier = Modifier
){
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        modifier = modifier.height(700.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(noticiasEPa){ item ->
            Card(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(8.dp),
            ) {
                Noticias(drawable = item.imagen, text = item.texto, descripcion = item.descripcion, one = item.primero, two = item.Segundo)
            }
        }
    }
}

@Composable
fun boton2(){
    colorResource(id = R.color.green)
    val texto1 = "Favorito"
    val text2 = "Añadido"

    val icono1 = Icons.Default.FavoriteBorder
    val icono2 = Icons.Default.Favorite

    var texto by remember {
        mutableStateOf(texto1)
    }
    var icono by remember {
        mutableStateOf(icono1)
    }
    Button(
        onClick = {
            texto = when(texto){
                texto1 -> text2
                text2 -> texto1
                else -> texto1
            }
            icono = when(icono){
                icono1 -> icono2
                icono2 -> icono1
                else -> icono1
            }
        },

        ) {
        Icon(
            imageVector = icono,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize),
            tint = Color(0xFFFFFFFF)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(texto, color = Color(0xFFFFFFFF))
    }
}

val noticiasEPa = listOf(
    noticias.noticia1,
    noticias.noticia2,
    noticias.noticia3
)