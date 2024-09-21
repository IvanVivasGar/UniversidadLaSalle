package com.ivanvivas.heroesapp.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.ivanvivas.heroesapp.R
import com.ivanvivas.heroesapp.models.Hero
import com.squareup.picasso.Picasso

class HeroDetailActivity : AppCompatActivity() {
    // Declarar variables lateinit para el TextView, TextView de descripción e ImageView
    lateinit var heroTextView: TextView
    lateinit var heroDescriptionTextView: TextView
    lateinit var heroImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Habilitar la visualización de borde a borde para una experiencia más inmersiva
        enableEdgeToEdge()
        // Establecer la vista de contenido en el diseño activity_hero_detail
        setContentView(R.layout.activity_hero_detail)

        // Inicializar las vistas encontrándolas usando sus respectivos ID
        heroTextView = findViewById(R.id.hero_name)
        heroDescriptionTextView = findViewById(R.id.hero_description)
        heroImageView = findViewById(R.id.hero_image)

        // Recuperar el ID del editor y el nombre del héroe pasados desde el Intent
        val publisherId = intent.getIntExtra("publisherId", 0)
        val heroName = intent.getStringExtra("heroName")

        // Encontrar el héroe en la lista Hero.heroes que coincida con el ID del editor y el nombre del héroe
        val hero = Hero.heroes.firstOrNull { it.publisher.id == publisherId && it.name == heroName }

        // Establecer el texto de los TextViews en el nombre y la descripción del héroe (si el héroe no es nulo)
        heroTextView.text = hero?.name
        heroDescriptionTextView.text = hero?.description
        // Cargar la image2 del héroe en el ImageView usando Picasso (si el héroe no es nulo)
        Picasso.get().load(hero?.image2).into(heroImageView)
    }
}