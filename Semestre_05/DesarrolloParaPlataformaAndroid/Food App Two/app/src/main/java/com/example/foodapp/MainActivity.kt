package com.example.foodapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.foodapp.activity.HomeActivity
import com.example.foodapp.models.User
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    //Inicializarse al tener un valor, se inicializa en nulo
    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var loginBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Estancia donde se guardaran los datos de inicio de sesion
        val sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE)
        val isLogged = sharedPreferences.getBoolean("isLogged", false)
        if(isLogged){
            val intent = Intent(this@MainActivity,HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        Log.i("IS_LOGGED",isLogged.toString())
        //BUSCAME EL EMAIL ET CON SU ID EN LA LIBRERIA R
        emailEditText = findViewById(R.id.emailET)
        passwordEditText = findViewById(R.id.passwordET)
        loginBtn = findViewById(R.id.btnLogin)
        loginBtn.setOnClickListener { v->
            Log.i("AndroidLogGato", "Iniciando Sesion")
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            Log.i("Email", email)
            Log.i("Password", password)
            if (email.isEmpty() || password.isEmpty()) {
                Log.i("LOGIN_ERROR","Email o password estan vacios")
                Snackbar.make(v,"El correo electronico o la contrasena estan vacios", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            Log.i("LOGIN_SUCCESSFUL", "INICIO DE SESION CORRECTO")
            val isValidUser = User.users.any{
                user-> user.email == email && user.password == password
            }
            if (!isValidUser){
                Log.i("LOGIN_ERROR","Email o password estan vacios")
                Snackbar.make(v,"El correo electronico o la contrasena son invalidos", Snackbar.LENGTH_SHORT).show()

                return@setOnClickListener
            }
            //Intens. Objetos que permiten la navegacion entre actividades
            //Intems explicitos: Se sabe el destino de la accion.
            //Intems implicitos: Se deduce el destino de la accion.
            Log.i("LOGIN_SUCCESSFUL", "Inicio de sesion correcto")
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLogged", true)
            editor.apply()
            val intent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
            //terminar la activity Main (no podra reresarse a la ventana anterior)
            finish()
        }
    }
}