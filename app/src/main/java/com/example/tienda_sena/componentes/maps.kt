package com.example.tienda_sena.componentes

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MarkerInfoWindow
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import com.google.maps.android.compose.widgets.DisappearingScaleBar
import com.google.maps.android.compose.widgets.ScaleBar



@Composable
fun Mapa(
    primer: Double,
    Segundo: Double,
    imagen: Int,
    nombre: String
){
    val Cba = primer
    val cb2 = Segundo

    val name = nombre
    val img = imagen
    val epa = LatLng(Cba, cb2)
    val defaultCameraPosition = CameraPosition.fromLatLngZoom(epa, 15f)

    //objeto para pasar al mapa
    val cameraPositionState = rememberCameraPositionState{
        position = defaultCameraPosition
    }

    //Variable para determinar si el mapa se cargo
    var isMapLoaded by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 80.dp)
    ){
        GoogleMap(
            modifier = Modifier.matchParentSize(),
            cameraPositionState = cameraPositionState,
            onMapLoaded = {
                isMapLoaded = true
            },
            valor = primer,
            valor2 = Segundo,
            valor3 = img,
            valor4 = name
        )
        if(!isMapLoaded){
            AnimatedVisibility(
                visible = !isMapLoaded,
                modifier = Modifier.matchParentSize(),
                enter = EnterTransition.None,
                exit = fadeOut()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .wrapContentSize()
                )
            }
        }
    }
}

@Composable
fun GoogleMap(
    modifier: Modifier,
    cameraPositionState: CameraPositionState = rememberCameraPositionState(),
    onMapLoaded: () -> Unit = {},
    valor: Double,
    valor2:Double,
    valor3: Int,
    valor4: String,
    content: @Composable () -> Unit = {}
){
    val EstaEs = LatLng(valor, valor2)
    val senaCbaState2 = rememberMarkerState(position = EstaEs)

    Box(
        modifier = Modifier.fillMaxSize()
    ){
        GoogleMap(
            modifier = modifier,
            cameraPositionState = cameraPositionState,
            onMapLoaded = onMapLoaded
        ){
            MarkerInfoWindow(
                state = senaCbaState2,
                icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
            ){
                Box(
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colors.onPrimary,
                            shape = RoundedCornerShape(35.dp, 35.dp, 35.dp, 35.dp)
                        )
                ){
                    Column(
                        modifier = Modifier
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = valor3),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(150.dp)
                                .fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        Text(
                            text = valor4,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            style = TextStyle(fontSize = 30.sp),
                            color = MaterialTheme.colors.primary
                        )
                    }
                }
            }
            content()
        }
        ScaleBar(
            cameraPositionState = cameraPositionState,
            modifier = Modifier
                .padding(top = 5.dp, end = 15.dp)
                .align(Alignment.TopEnd),
        )
        DisappearingScaleBar(
            cameraPositionState = cameraPositionState,
            modifier = Modifier
                .padding(top = 5.dp, end = 15.dp)
                .align(Alignment.TopStart)
        )
    }
}