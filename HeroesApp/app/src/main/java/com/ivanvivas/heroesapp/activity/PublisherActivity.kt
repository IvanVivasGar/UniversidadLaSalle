package com.ivanvivas.heroesapp.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ivanvivas.heroesapp.MainActivity
import com.ivanvivas.heroesapp.R
import com.ivanvivas.heroesapp.adapters.PublisherAdapter
import com.ivanvivas.heroesapp.models.Publisher
import com.ivanvivas.heroesapp.models.User

class PublisherActivity : AppCompatActivity() {
    // Declarar variables lateinit para el ImageView de cierre de sesión y el RecyclerView
    lateinit var logoutBtn : ImageView
    lateinit var publisherRecyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Habilitar la visualización de borde a borde
        enableEdgeToEdge()
        // Establecer la vista de contenido en el diseño activity_publisher
        setContentView(R.layout.activity_publisher)
        // Obtener la instancia de SharedPreferences
        val sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE)
        // Obtener la referencia al ImageView de cierre de sesión
        logoutBtn = findViewById(R.id.logoutBtn)

        // Obtener la referencia al RecyclerView
        publisherRecyclerView = findViewById(R.id.publisher_recyclerview)
        // Configurar el adaptador del RecyclerView con la lista de editores y un listener para clics en elementos
        publisherRecyclerView.adapter = PublisherAdapter(Publisher.publishers) { publisher ->
            // Crear un Intent para iniciar HeroesActivity
            val intent = Intent(this@PublisherActivity, HeroesActivity::class.java)
            // Pasar el nombre del editor al Intent
            intent.putExtra("publisherName", publisher.name)
            // Iniciar HeroesActivity
            startActivity(intent)
        }
        // Configurar el layout manager del RecyclerView como LinearLayoutManager vertical
        publisherRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Obtener un usuario de ejemplo (esto debería reemplazarse con la lógica de autenticación real)
        val user = User.users[1]
        // Configurar un listener para el clic en el botón de cierre de sesión
        logoutBtn.setOnClickListener {
            // Imprimir un mensaje en el Logcat
            Log.i("LOGOUT","CERRANDO SESION")
            // Obtener el editor de SharedPreferences
            val editor = sharedPreferences.edit()
            // Eliminar la clave "isLogged" de SharedPreferences para cerrar sesión
            editor.remove("isLogged")
            // Aplicar los cambios en SharedPreferences
            editor.apply()

            // Crear un Intent para iniciar MainActivity
            val intent = Intent(this@PublisherActivity, MainActivity::class.java)
            // Iniciar MainActivity
            startActivity(intent)
            // Finalizar la actividad actual
            finish()
        }
    }
}