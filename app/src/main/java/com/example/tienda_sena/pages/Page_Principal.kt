package com.example.tienda_sena.pages

import com.example.tienda_sena.ui.theme.Tienda_SenaTheme

import android.content.Context
import android.graphics.BitmapFactory
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
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
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tienda_sena.R
import com.example.tienda_sena.componentes.CreateChannelNotification
import com.example.tienda_sena.componentes.Mapa
import com.example.tienda_sena.componentes.elementos
import com.example.tienda_sena.componentes.notificacionImagen
import com.example.tienda_sena.componentes.todos

@Composable
fun Page_Principal(){
    Tienda_SenaTheme() {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .height(750.dp),
        ) {
            HomeSection()
            Spacer(modifier = Modifier.padding(bottom = 2.dp))
            HomeSection2()
        }
    }
}


@Composable
fun Pro_Cate(
    @DrawableRes drawable: Int,
    text: String,
    precio: String,
    descripcion: String,
    one: Double,
    two: Double
){
    val context: Context = LocalContext.current
    Row(){
        Image(
            painter = painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(270.dp)
                .width(200.dp)
                .size(64.dp)
                .clip(RoundedCornerShape(percent = 10)),
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier.padding(start = 10.dp, top = 60.dp, end = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = text, style = TextStyle(fontSize = 35.sp, fontWeight = FontWeight.Bold))
            Text(
                text = "$ " + precio,
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center),
            )
            Spacer(modifier = Modifier.height(30.dp))
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
                                        IconButton(onClick = { /*TODO*/ }) {
                                            Icon(imageVector = Icons.Filled.Delete, contentDescription = null)
                                        }
                                    }else{
                                        IconButton(onClick = {count-- }) {
                                            Icon(imageVector = Icons.Filled.Delete, contentDescription = null)
                                        }
                                    }
                                    Text(
                                        text = "$count",
                                        style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold),
                                        //modifier = Modifier.padding(start = 5.dp, top = 5.dp, end = 5.dp)
                                    )
                                    IconButton(onClick = {count++}) {
                                        Icon(imageVector = Icons.Default.Add, contentDescription = null)
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
            val idNotication: Int = 0
            val idChannel: String = text
            val name: String = "Canal Tienda"
            val descriptionText: String = "Canal de Notificaciones Tienda CBA"

            val textShort: String = "Informacion acerca de su producto"
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
            var openModal2 by remember {
                mutableStateOf(false)
            }
            if(openModal2){
                androidx.compose.material3.AlertDialog(
                    onDismissRequest = { openModal2 = false },
                    title = {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Ubicacion",
                                style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
                            )
                            Text(
                                text = text,
                                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
                            )
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
            Button(
                onClick = {
                    openModal2 = true
                }
            ) {
                Text(text = "Ubicacion")
            }
            Button(
                onClick = {
                    openModal = true
                    notificacionImagen(
                        context,
                        idChannel,
                        idNotication + 2,
                        text,
                        textLong,
                        iconoBig,
                        imagenBig
                    )
                }
            ) {
                Text(text = "Ver Mas")
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Popu(
    modifier: Modifier = Modifier
){
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        modifier = modifier
            .height(280.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        contentPadding = PaddingValues(16.dp)
    ){
        items(listapopulares){item->
            Card(
                onClick = { /*TODO*/ },
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFBBD1BC),
                    contentColor = Color(0xFF000000)
                ),
            ) {
                Pro_Cate(drawable = item.imagen, text = item.nombre, precio = item.precio, descripcion = item.descripcion, one = item.primero, two = item.Segundo)
            }
        }
    }
}

val listapopulares = listOf(
    elementos.elemento1,
    //elementos.elemento2,
    elementos.elemento3,
    elementos.elemento4,
    elementos.elemento5,
    elementos.elemento6,
    elementos.elemento7,
    elementos.elemento8,
)

@Composable
fun Section(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
){
    Column(modifier) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = stringResource(id = title),
                style = TextStyle(fontSize = 35.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Default),
                modifier = Modifier
                    .paddingFromBaseline(
                        top = 20.dp,
                        bottom = 8.dp
                    )
                    .padding(start = 25.dp, bottom = 2.dp, top = 5.dp)
            )
            Text(
                text = "Desliza >>>",
                style = TextStyle(fontSize = 12.sp),
                modifier = Modifier.padding(start = 10.dp, top = 18.dp)
            )
        }
        content()
    }
}


@Composable
fun HomeSection(){
    Tienda_SenaTheme() {
        Section(title = R.string.Incio) {
            Popu()
        }
    }
}



//Siguiente seccion
@Composable
fun PopularesCollections(
    @DrawableRes drawable: Int,
    text: String,
    precio: String,
    descripcion: String,
    one:Double,
    two: Double
){

    val context: Context = LocalContext.current
    Row(){
        Image(
            painter = painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(270.dp)
                .width(200.dp)
                .size(64.dp)
                .clip(RoundedCornerShape(percent = 10)),
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier.padding(start = 10.dp, top = 60.dp, end = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = text, style = TextStyle(fontSize = 35.sp, fontWeight = FontWeight.Bold))
            Text(
                text = "$ " + precio,
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center),
            )
            Spacer(modifier = Modifier.height(30.dp))
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
                                        IconButton(onClick = { /*TODO*/ }) {
                                            Icon(imageVector = Icons.Filled.Delete, contentDescription = null)
                                        }
                                    }else{
                                        IconButton(onClick = {count-- }) {
                                            Icon(imageVector = Icons.Filled.Delete, contentDescription = null)
                                        }
                                    }
                                    Text(
                                        text = "$count",
                                        style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold),
                                        //modifier = Modifier.padding(start = 5.dp, top = 5.dp, end = 5.dp)
                                    )
                                    IconButton(onClick = {count++}) {
                                        Icon(imageVector = Icons.Default.Add, contentDescription = null)
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
            val idNotication: Int = 0
            val idChannel: String = text
            val name: String = "Canal Tienda"
            val descriptionText: String = "Canal de Notificaciones Tienda CBA"

            val textShort: String = "Informacion acerca de su producto"
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
            var openModal2 by remember {
                mutableStateOf(false)
            }
            if(openModal2){
                androidx.compose.material3.AlertDialog(
                    onDismissRequest = { openModal2 = false },
                    title = {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Ubicacion",
                                style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
                            )
                            Text(
                                text = text,
                                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
                            )
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
            Button(
                onClick = {
                    openModal2 = true
                }
            ) {
                Text(text = "Ubicacion")
            }
            Button(
                onClick = {
                    openModal = true
                    notificacionImagen(
                        context,
                        idChannel,
                        idNotication + 2,
                        text,
                        textLong,
                        iconoBig,
                        imagenBig
                    )
                }
            ) {
                Text(text = "Ver Mas")
            }
        }
    }
}

@Composable
fun boton(){
    colorResource(id = R.color.green)
    val texto1 = "Comprar"
    val text2 = "En el Carrito"

    var texto by remember {
        mutableStateOf(texto1)
    }
    Button(
        onClick = {
            texto = when(texto){
                texto1 -> text2
                text2 -> texto1
                else -> texto1
            }
        },

        ) {
        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize),
            tint = Color(0xFFFFFFFF)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(texto, color = Color(0xFFFFFFFF), style = TextStyle(fontWeight = FontWeight.Bold))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopularesCard(
    modifier: Modifier = Modifier
){
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        modifier = modifier
            .height(300.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        contentPadding = PaddingValues(16.dp)
    ){
        items(listatodos){ item ->
            Card(
                onClick = { /*TODO*/ },
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 15.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFBBD1BC),
                    contentColor = Color(0xFF000000)
                ),
            ) {
                PopularesCollections(drawable = item.imagen, text = item.nombre, precio = item.precio, item.descripcion, one = item.primero, two = item.Segundo)
            }
        }
    }
}

val listatodos = listOf(
    todos.todo1,
    todos.todo2,
    //todos.todo3,
    todos.todo4,
    todos.todo5,
    todos.todo6,
    todos.todo7,
    todos.todo8,
    todos.todo9,
    todos.todo10,
    todos.todo11,
    todos.todo12,
    todos.todo13,
    todos.todo14
)

@Composable
fun HomeSection2(){
    Tienda_SenaTheme() {
        Section(
            title = R.string.Todos
        ) {
            PopularesCard()
        }
    }
}

