package com.ivanvivas.heroesapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ivanvivas.heroesapp.R
import com.ivanvivas.heroesapp.models.Hero
import com.squareup.picasso.Picasso

// Define una clase HeroAdapter que hereda de RecyclerView.Adapter y toma una lista de héroes y una función lambda como parámetros
class HeroAdapter(val heroList : List<Hero>, val onClick:(Hero)->Unit) : RecyclerView.Adapter<HeroViewHolder>() {

    // Se llama cuando se necesita crear un nuevo ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        // Inflar el diseño hero_item para crear la vista del elemento
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hero_item,parent,false)
        // Devolver un nuevo HeroViewHolder con la vista inflada
        return HeroViewHolder(view)
    }

    // Devuelve el número total de elementos en la lista de héroes
    override fun getItemCount(): Int {
        return heroList.count()
    }

    // Se llama para vincular los datos del héroe a un ViewHolder
    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        // Obtener el héroe en la posición actual de la lista
        val hero = heroList[position]
        // Establecer el texto del TextView del nombre del héroe con el nombre del héroe
        holder.heroNameTV.text = hero.name
        // Cargar la imagen del héroe en el ImageView usando Picasso
        Picasso.get().load(hero.image).into(holder.heroImage)
        // Configurar un listener de clics en la vista del elemento
        holder.itemView.setOnClickListener{
            // Llamar a la función lambda onClick con el héroe actual cuando se hace clic en el elemento
            onClick(hero)
        }
    }
}

// Define una clase HeroViewHolder que hereda de RecyclerView.ViewHolder
class HeroViewHolder(view : View) : ViewHolder(view){
    // Obtener referencias al TextView del nombre del héroe y al ImageView de la imagen del héroe
    val heroNameTV : TextView = view.findViewById(R.id.hero_name)
    val heroImage : ImageView = view.findViewById(R.id.hero_image)
}