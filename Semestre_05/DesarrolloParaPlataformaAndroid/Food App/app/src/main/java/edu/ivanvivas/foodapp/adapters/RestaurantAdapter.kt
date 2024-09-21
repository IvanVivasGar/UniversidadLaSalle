package edu.ivanvivas.foodapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import edu.ivanvivas.foodapp.R
import edu.ivanvivas.foodapp.models.Restaurant

class RestaurantAdapter (val restaurantList : List<Restaurant>, val onClick:(Restaurant) -> Unit) : RecyclerView.Adapter<RestaurantViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_item, parent, false)
        return RestaurantViewHolder(view)
    }

    override fun getItemCount(): Int {
        return restaurantList.count()
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = restaurantList[position]
        holder.restaurantNameTV.text = restaurant.name
        Picasso.get().load(restaurant.image).into(holder.restaurantImage)
        holder.itemView.setOnClickListener{
            onClick(restaurant)
        }
    }
}

class RestaurantViewHolder(view : View) : ViewHolder(view){
    val restaurantNameTV : TextView = view.findViewById(R.id.restaurant_name)
    val restaurantImage : ImageView = view.findViewById(R.id.restaurant_image)
}