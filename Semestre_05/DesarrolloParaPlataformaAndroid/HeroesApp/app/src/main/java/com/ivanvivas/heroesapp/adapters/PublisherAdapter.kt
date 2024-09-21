package com.ivanvivas.heroesapp.adapters

import android.app.Activity
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ivanvivas.heroesapp.R
import com.ivanvivas.heroesapp.models.Publisher
import com.squareup.picasso.Picasso

// Define una clase PublisherAdapter que hereda de RecyclerView.Adapter y toma una lista de editores y una función lambda como parámetros
class PublisherAdapter(val publisherList : List<Publisher>, val onPublisherClick: (Publisher) -> Unit) : RecyclerView.Adapter<PublisherViewHolder>() {

    // Se llama cuando se necesita crear un nuevo ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PublisherViewHolder {
        // Inflar el diseño publisher_item para crear la vista del elemento
        val view = LayoutInflater.from(parent.context).inflate(R.layout.publisher_item,parent,false)
        // Obtener la referencia al FrameLayout del elemento
        val frameLayout = view.findViewById<FrameLayout>(R.id.publisher_frame_layout)

        // Obtener las dimensiones de la pantalla
        val displayMetrics = DisplayMetrics()
        (parent.context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        // Calcular la altura del FrameLayout como la mitad de la altura de la pantalla
        val height = displayMetrics.heightPixels / 2

        // Establecer la altura del FrameLayout
        val layoutParams = frameLayout.layoutParams
        layoutParams.height = height
        frameLayout.layoutParams = layoutParams

        // Devolver un nuevo PublisherViewHolder con la vista inflada
        return PublisherViewHolder(view)
    }

    // Devuelve el número total de elementos en la lista de editores
    override fun getItemCount(): Int {
        return publisherList.count()
    }

    // Se llama para vincular los datos del editor a un ViewHolder
    override fun onBindViewHolder(holder: PublisherViewHolder, position: Int) {
        // Obtener el editor en la posición actual de la lista
        val publisher = publisherList[position]
        // Establecer el texto del TextView del nombre del editor con el nombre del editor
        holder.publisherNameTV.text = publisher.name
        // Cargar la imagen del editor en el ImageView usando Picasso
        Picasso.get().load(publisher.image).into(holder.publisherImage)
        // Configurar un listener de clics en la vista del elemento
        holder.itemView.setOnClickListener{
            // Llamar a la función lambda onPublisherClick con el editor actual cuando se hace clic en el elemento
            onPublisherClick(publisher)
        }
    }
}

// Define una clase PublisherViewHolder que hereda de RecyclerView.ViewHolder
class PublisherViewHolder(view : View) : ViewHolder(view){
    // Obtener referencias al TextView del nombre del editor y al ImageView de la imagen del editor
    val publisherNameTV : TextView = view.findViewById(R.id.publisher_name)
    val publisherImage : ImageView = view.findViewById(R.id.publisher_image)
}