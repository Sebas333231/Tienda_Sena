package com.example.tienda_sena.pages


import android.content.Context
import android.net.Uri
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.tienda_sena.R
import com.example.tienda_sena.componentes.navigationScreen
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

private fun Context.buildExoPlayer(uri: Uri)=
    ExoPlayer.Builder(this).build().apply {
        setMediaItem(MediaItem.fromUri(uri))
        repeatMode = Player.REPEAT_MODE_ALL
        playWhenReady = true
        prepare()
    }

private fun Context.buildPlayerView(exoPlayer: ExoPlayer) =
    StyledPlayerView(this).apply {
        player = exoPlayer
        layoutParams = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        useController = false
        resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
    }


@Composable
fun SplashScreen(
    navController: NavController,
    videoUri: Uri
)  {
    val context = LocalContext.current
    val exoPlayer = remember {
        context.buildExoPlayer(videoUri)
    }
    DisposableEffect(
        AndroidView(
            factory = { it.buildPlayerView(exoPlayer) },
            modifier = Modifier
                .fillMaxSize()
        )
    ){
        onDispose {
            exoPlayer.release()
        }
    }
    ProvideWindowInsets{
        Column(
            modifier = Modifier.padding(24.dp).fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.Bottom),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(navigationScreen.LoginScreen.name)
                },
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 25.dp
                ),
            ) {
                Text(
                    text = "Comenzar",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 23.sp
                    )
                )
            }
        }
    }
}




//LaunchedEffect(key1 = true){
//delay(3000L)
//navController.popBackStack()
//navController.navigate(navigationScreen.LoginScreen.name)
//if (FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty()){
//navController.navigate(navigationScreen.LoginScreen.name)
//}else{
//navController.navigate(navigationScreen.HomeScreen.name){
//popUpTo(navigationScreen.SplashScreen.name){
//inclusive = true
//}
//}
//}
//}