package com.example.tienda_sena.componentes

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun BottomMenu(
    navController: NavHostController,
    menu_items_bar: List<items_bar>
){
    BottomAppBar(
        cutoutShape = MaterialTheme.shapes.small.copy(
            CornerSize(percent = 60)
        ),
        contentColor = Color.White,
        backgroundColor = Color(0xFF4CAF50)
    ) {
        BottomNavigation(
            modifier = Modifier.padding(
                0.dp,
                0.dp,
                60.dp,
                0.dp
            ),
            contentColor = Color(0xFFFFFFFF),
            backgroundColor = Color(0xFF4CAF50)
        ) {
            val currentRouteBar = Current_Route(navController = navController)
            menu_items_bar.forEach{item ->
                BottomNavigationItem(
                    //selectedContentColor = Color(0xFF4CAF50),
                    selected = currentRouteBar == item.ruta,
                    onClick = {navController.navigate(item.ruta)},
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.title
                        )
                    },
                    label = {Text(item.title)}
                )
            }
        }
    }
}

@Composable
fun Fab(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState
){
    FloatingActionButton(
        backgroundColor = Color(0xFF4CAF50),
        onClick = {
            scope.launch { scaffoldState.snackbarHostState
                .showSnackbar(
                    "Proximamente disponible",
                    actionLabel = "Aceptar",
                    duration = SnackbarDuration.Indefinite
                )
            }
        },
    ) {
        Icon(
            imageVector = Icons.Filled.ShoppingCart,
            contentDescription = "Recompesas",
            tint = Color(0xFFFFFFFF)
        )
    }
}