package com.example.tienda_sena.login


import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.tienda_sena.R
import com.example.tienda_sena.componentes.CreateChannelNotification
import com.example.tienda_sena.componentes.LoginScreenViewModel
import com.example.tienda_sena.componentes.navigationScreen
import com.example.tienda_sena.componentes.notificationExtensa
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.StyledPlayerView

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
fun LoginCreen(
    navController: NavController,
    videoClip: Uri,
    viewModel: LoginScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val context = LocalContext.current
    val exoPlayer = remember {
        context.buildExoPlayer(videoClip)
    }

    DisposableEffect(
        AndroidView(
            factory = { it.buildPlayerView(exoPlayer)},
            modifier = Modifier.fillMaxSize()
        )
    ){
        onDispose {
            exoPlayer.release()
        }
    }

    ProvideWindowInsets {

        val showLoginForm = rememberSaveable{
            mutableStateOf(true)
        }
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 20.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xDADDDCDF),
                contentColor = Color(0xFF000000)
            ),
            modifier = Modifier
                .width(350.dp)
                .height(590.dp)
                .padding(start = 25.dp, end = 8.dp, top = 200.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                if(showLoginForm.value){
                    Text(
                        text = "Iniciar Sesion",
                        style = TextStyle(
                            fontSize = 45.sp,
                            color = Color.Black,
                            fontFamily = FontFamily.Cursive,
                            shadow = Shadow(
                                color = Color.Black,
                                offset = Offset(3f, 3f),
                                blurRadius = 5f
                            )
                        )
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    UserForm(
                        isCreateAccount = false,
                        valorBoolean = showLoginForm.value
                    ){
                            email, password ->
                        Log.d("Bien Hecho!!", "Logueado con $email y $password")
                        viewModel.SignInWithEmailAndPassword(email, password){
                            navController.navigate(navigationScreen.HomeScreen.name)
                        }
                    }
                }else{
                    Text(
                        text = "Crear Cuenta",
                        style = TextStyle(
                            fontSize = 45.sp,
                            color = Color.Black,
                            fontFamily = FontFamily.Cursive,
                            shadow = Shadow(
                                color = Color.Black,
                                offset = Offset(3f, 3f),
                                blurRadius = 5f
                            )
                        )
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    UserForm(
                        isCreateAccount = true,
                        valorBoolean = showLoginForm.value
                    ){
                            email, password ->
                        Log.d("Bien Hecho!!", "Tu cuenta ha sido creada $email")
                        viewModel.createUserWithEmailAndPassword(email, password){
                            navController.navigate(navigationScreen.HomeScreen.name)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val texto1 =
                        if(showLoginForm.value) "¿No tienes cuenta?"
                        else "¿Ya tienes cuenta?"
                    val texto2 =
                        if(showLoginForm.value) "Registrate"
                        else "Inicia Sesion"
                    Text(text = texto1, style = TextStyle(fontSize = 17.sp))
                    Text(
                        text = texto2,
                        modifier = Modifier
                            .clickable { showLoginForm.value = !showLoginForm.value }
                            .padding(start = 5.dp),
                        color = Color(0xFF4CAF50),
                        style = TextStyle(fontSize = 17.sp)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UserForm(
    valorBoolean: Boolean,
    isCreateAccount: Boolean = false,
    onDone: (String, String) -> Unit = {email, pwd ->}
) {
    val email = remember{
        mutableStateOf("")
    }

    val password = remember{
        mutableStateOf("")
    }

    val passwordVisible = remember{
        mutableStateOf(false)
    }

    val valido = remember(email.value, password.value) {
        email.value.trim().isNotEmpty() && password.value.trim().isNotEmpty()
    }
    val cuenta = if(isCreateAccount == true){
        "Bienvenido"
    }else{
        "Iniciaste Sesion"
    }

    val almacena = if (isCreateAccount == true){
        "Tu cuenta '${email.value}' fue creada correctamente."
    }else{
        "Has iniciado correctamente con tu correo '${email.value}'"
    }
    val idNotication: Int = 0
    val context: Context = LocalContext.current
    val idChannel: String = "Canal Tienda"
    val name: String = "Canal Tienda"
    val descriptionText: String = "Canal de Notificaciones Tienda CBA"
    val textLong: String = "Saludos! Esta es una prueba de notificaciones. Bebe aparecer " +
            "un icono a la derecha y el texto puede tener una longitud de 200 caracteres "+
            "Gracias y hasta pronto"
    val iconoBig = BitmapFactory.decodeResource(
        context.resources,
        R.drawable.logo
    )
    val imagenBig = BitmapFactory.decodeResource(
        context.resources,
        R.drawable.epa
    )

    //Funcion de creacion propia como corrutina
    LaunchedEffect(Unit){
        CreateChannelNotification(
            idChannel,
            context,
            name,
            descriptionText
        )
    }
    val KeyBoardController = LocalSoftwareKeyboardController.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmailInput(
            emailState = email
        )
        PasswordInput(
            passwordState = password,
            labelId = "Password",
            passwordVisible = passwordVisible
        )
        SubmitButton(
            textId = if(isCreateAccount){
                "Crear Cuenta"
            }else{
                "Login"
            },
            inputValido = valido
        ){
            onDone(email.value.trim(), password.value.trim())
            KeyBoardController?.hide()
            notificationExtensa(
                context,
                idChannel,
                idNotication + 1,
                "Hola",
                almacena,
                iconoBig
            )
        }
    }
}

@Composable
fun SubmitButton(
    textId: String,
    inputValido: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        enabled = inputValido,
        modifier = Modifier.width(200.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 15.dp
        ),
    ) {
        Text(text = textId, modifier = Modifier.padding(5.dp), style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInput(
    passwordState: MutableState<String>,
    labelId: String,
    passwordVisible: MutableState<Boolean>
) {
    val visualTransformation = if(passwordVisible.value)
        VisualTransformation.None
    else PasswordVisualTransformation()

    OutlinedTextField(
        value = passwordState.value,
        onValueChange = { passwordState.value = it },
        label = { Text(text = labelId) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        modifier = Modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        visualTransformation = visualTransformation,
        trailingIcon = {
            if ( passwordState.value.isNotBlank()){
                PasswordVisibleIcon(passwordVisible)
            }
            else null
        },
        textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFF48CA4D),
            unfocusedBorderColor = Color(0xFF4CAF50)
        )
    )
}

@Composable
fun PasswordVisibleIcon(
    passwordVisible: MutableState<Boolean>
) {
    val image =
        if(passwordVisible.value){
            Icons.Default.VisibilityOff
        }else{
            Icons.Default.Visibility
        }

    IconButton(
        onClick = {
            passwordVisible.value = !passwordVisible.value
        }
    ) {
        Icon(
            imageVector = image,
            contentDescription = null
        )
    }
}

@Composable
fun EmailInput(
    emailState: MutableState<String>,
    labelId: String = "Email"
) {
    InputField(
        valueState = emailState,
        labelId = labelId,
        keyboardType = KeyboardType.Email
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(
    valueState: MutableState<String>,
    labelId: String,
    isSingleLine: Boolean = true,
    keyboardType: KeyboardType
) {
    OutlinedTextField(
        value = valueState.value,
        onValueChange = { valueState.value = it},
        label = { Text(text = labelId)},
        singleLine = isSingleLine,
        modifier = Modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFF48CA4D),
            unfocusedBorderColor = Color(0xFF4CAF50)
        )
    )
}