package com.example.tienda_sena.componentes

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.tasks.RuntimeExecutionException
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LoginScreenViewModel: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)

    fun SignInWithEmailAndPassword(email:String, password:String, home: () -> Unit)
    = viewModelScope.launch {
        try {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Log.d("Epa", "Logueado")
                        home()
                    }else{
                        val credencial = EmailAuthProvider.getCredential(email, password)
                        Firebase.auth.currentUser!!.linkWithCredential(credencial)
                            .addOnCompleteListener { it.exception }
                    }
                }
        }catch (ex: Exception){
            Log.d("Epaaaaa", "Epaaaaaaaaaaa ${ex.message}")
        }
    }


    fun createUserWithEmailAndPassword(email: String, password: String, home: () -> Unit){
        if (_loading.value == false){
            _loading.value = true
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    task->
                    if(task.isSuccessful){
                        val displayName =
                            task.result.user?.email?.split("@")?.get(0)
                        createUser(displayName)
                        home()
                    }else{
                        Log.d("Error", "epaaaa error ${task.result.toString()}")
                    }
                    _loading.value = false
                }
        }
    }

    private fun createUser(displayName: String?) {
        val userId = auth.currentUser?.uid
        //val user = mutableMapOf<String, Any>()

        //user["user_id"] = userId.toString()
        //user["display_name"] = displayName.toString()

        val user = users(
            userId = userId.toString(),
            displayName = displayName.toString(),
            avatarUrl = "",
            profession = "Aprendiz",
            quote = "",
            id = null
        )
        FirebaseFirestore.getInstance().collection("users")
            .add(user)
            .addOnSuccessListener {
                Log.d("Epaaaaa", "Creado ${it.id}")
            }.addOnFailureListener {
                Log.d("error", "Error ")
            }
    }

}