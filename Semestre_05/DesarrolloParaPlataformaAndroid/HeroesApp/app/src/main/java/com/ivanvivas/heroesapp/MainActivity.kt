package com.ivanvivas.heroesapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.ivanvivas.heroesapp.models.User
import com.ivanvivas.heroesapp.activity.PublisherActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    // Declarar variables lateinit para los EditText de correo electrónico y contraseña, y el botón de inicio de sesión
    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var loginBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Habilitar la visualización de borde a borde
        enableEdgeToEdge()
        // Establecer la vista de contenido en el diseño activity_main
        setContentView(R.layout.activity_main)

        // Obtener la instancia de SharedPreferences
        val sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE)
        // Obtener el estado de inicio de sesión de SharedPreferences
        val isLogged = sharedPreferences.getBoolean("isLogged", false)
        // Si el usuario ya ha iniciado sesión, iniciar PublisherActivity y finalizar la actividad actual
        if(isLogged){
            val intent = Intent(this@MainActivity,PublisherActivity::class.java)
            startActivity(intent)
            finish()
        }
        // Imprimir el estado de inicio de sesión en el Logcat
        Log.i("IS_LOGGED",isLogged.toString())

        // Obtener referencias a los EditText y el botón de inicio de sesión
        emailEditText = findViewById(R.id.emailET)
        passwordEditText = findViewById(R.id.passwordET)
        loginBtn = findViewById(R.id.btnLogin)
        // Configurar un listener de clics para el botón de inicio de sesión
        loginBtn.setOnClickListener { v->
            // Imprimir un mensaje en el Logcat
            Log.i("AndroidLogGato", "Iniciando Sesion")
            // Obtener el correo electrónico y la contraseña de los EditText
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            // Imprimir el correo electrónico y la contraseña en el Logcat
            Log.i("Email", email)
            Log.i("Password", password)
            // Si el correo electrónico o la contraseña están vacíos, mostrar un Snackbar y salir del listener
            if (email.isEmpty() || password.isEmpty()) {
                Log.i("LOGIN_ERROR","Email o password estan vacios")
                Snackbar.make(v,"El correo electronico o la contrasena estan vacios", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Verificar si el usuario es válido comparando el correo electrónico y la contraseña con la lista de usuarios
            val isValidUser = User.users.any{
                    user-> user.email == email && user.password == password
            }
            // Si el usuario no es válido, mostrar un Snackbar y salir del listener
            if (!isValidUser){
                Log.i("LOGIN_ERROR","Email o password estan vacios")
                Snackbar.make(v,"El correo electronico o la contrasena son invalidos", Snackbar.LENGTH_SHORT).show()

                return@setOnClickListener
            }

            // Si el usuario es válido, imprimir un mensaje en el Logcat
            Log.i("LOGIN_SUCCESSFUL", "Inicio de sesion correcto")
            // Obtener el editor de SharedPreferences
            val editor = sharedPreferences.edit()
            // Guardar el estado de inicio de sesión en SharedPreferences
            editor.putBoolean("isLogged", true)
            // Aplicar los cambios en SharedPreferences
            editor.apply()
            // Crear un Intent para iniciar PublisherActivity
            val intent = Intent(this@MainActivity, PublisherActivity::class.java)
            // Iniciar PublisherActivity
            startActivity(intent)
            // Finalizar la actividad actual
            finish()
        }
    }
}