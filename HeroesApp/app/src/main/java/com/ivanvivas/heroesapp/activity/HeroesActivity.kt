package com.ivanvivas.heroesapp.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ivanvivas.heroesapp.R
import com.ivanvivas.heroesapp.adapters.HeroAdapter
import com.ivanvivas.heroesapp.models.Hero

class HeroesActivity : AppCompatActivity() {
    // Declarar una variable lateinit para el RecyclerView
    lateinit var heroRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Habilitar la visualización de borde a borde
        enableEdgeToEdge()
        // Establecer la vista de contenido en el diseño activity_heroes
        setContentView(R.layout.activity_heroes)

        // Obtener el nombre del editor del Intent
        val publisherName = intent.getStringExtra("publisherName")
        // Obtener la referencia al TextView de bienvenida
        val bienvenidaTextView: TextView = findViewById(R.id.bienvenida_publisher)
        // Establecer el texto del TextView de bienvenida con el nombre del editor
        bienvenidaTextView.text = publisherName
        // Filtrar la lista de héroes para mostrar solo los del editor actual
        val filteredHeroes = Hero.heroes.filter { it.publisher.name == publisherName }

        // Obtener la referencia al RecyclerView
        heroRecyclerView = findViewById(R.id.heroes_recyclerview)
        // Configurar el adaptador del RecyclerView con la lista de héroes filtrada y un listener para clics en elementos
        heroRecyclerView.adapter = HeroAdapter(filteredHeroes) { hero ->
            // Imprimir el nombre del héroe en el Logcat cuando se hace clic en él
            Log.i("Hero desde Publisher", hero.name)
            // Crear un Intent para iniciar HeroDetailActivity
            val intent = Intent(this@HeroesActivity, HeroDetailActivity::class.java)
            // Pasar el ID del editor y el nombre del héroe al Intent
            intent.putExtra("publisherId", hero.publisher.id)
            intent.putExtra("heroName", hero.name)
            // Iniciar HeroDetailActivity
            startActivity(intent)
        }
        // Configurar el layout manager del RecyclerView como LinearLayoutManager vertical
        heroRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}