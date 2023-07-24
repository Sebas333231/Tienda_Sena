package com.example.tienda_sena.pages


import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tienda_sena.R
import com.example.tienda_sena.componentes.info

@Composable
fun Page_Informacion(){
    CardGreetings()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardGreetings(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        modifier = modifier.height(700.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(listainfo){item ->
            Card(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 15.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF88D388),
                    contentColor = Color(0xFF000000)
                )
            ) {
                CardContentInfo(nombre = item.nombre, informacion = item.informacion)
            }

        }
    }
}

@Composable
fun CardContentInfo(
    nombre: String,
    informacion: String
) {
   var expanded by remember{
       mutableStateOf(false)
   }
    Row(
       modifier = Modifier
           .padding(12.dp)
           .animateContentSize(
               animationSpec = spring(
                   dampingRatio = Spring.DampingRatioHighBouncy,
                   stiffness = Spring.StiffnessLow
               )
           ),
   ) {
       Column(
           modifier = Modifier
               .weight(1f)
               .padding(12.dp)
       ) {
            Text(
                text = nombre,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
           if(expanded){
               Text(
                   text = informacion,
                   style = TextStyle(
                       fontSize = 18.sp,
                       fontWeight = FontWeight.Bold
                   )
               )
           }
       }
   }
    IconButton(onClick = {expanded = !expanded}) {
        Icon(imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = if (expanded){
                stringResource(id = R.string.show_less)
            }else{
                stringResource(id = R.string.show_more)
            }
        )
    }
}


val listainfo = listOf(
    info.primera,
    info.segunda,
    info.tercera
)