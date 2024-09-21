package edu.ivanvivas.foodapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import edu.ivanvivas.foodapp.activity.HomeActivity
import edu.ivanvivas.foodapp.models.User

class MainActivity : AppCompatActivity() {
    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var loginButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE)
        val isLogged = sharedPreferences.getBoolean("isLogged", false)
        if(isLogged){
            val intent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        emailEditText = findViewById(R.id.emailET)
        passwordEditText = findViewById(R.id.passwordET)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener { v->
            Log.i("AndroidLogGato", "Iniciando Sesion")
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            Log.i("Email", email)
            Log.i("Password", password)

            if(email.isEmpty() || password.isEmpty()){
                Log.i("LOGIN_ERROR", "Email o password estan vacios")
                Snackbar.make(v, "El correo electronico o la contraseña estan vacios", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val isValidUser = User.users.any { user -> user.email == email && user.password == password}

            if(!isValidUser){
                Log.i("LOGIN_ERROR", "Email o password son invalidos")
                Snackbar.make(v, "El correo electronico o la contraseña estan vacios", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // Intents, objetos que permiten la navegacion entre actividades
            // Intent Implicitos:
            // Intent Explicitos:
            Log.i("LOGIN_SUCCESFUL", "Inicio de sesion correcto")
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLogged", true)
            editor.apply()
            val intent = Intent(this@MainActivity,HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}