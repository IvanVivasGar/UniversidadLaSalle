package com.example.foodapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.foodapp.R
import com.example.foodapp.models.Food
import com.squareup.picasso.Picasso

class FoodAdapter(val foodList : List<Food>,
                  val onClick : (Food) -> Unit)
    : RecyclerView.Adapter<FoodViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        //MANDAMOS A LLAMARLO DE PARENT (HomeActivity), INFLAMOS/MOSTRAR EL RESTAURANT ITEM
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_item,parent,false)
        return FoodViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foodList.count()
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.foodNameTV.text = food.name
        holder.foodPrice.text = food.computedPrice
        holder.foodRating.text = food.rating.toString()
        Picasso.get().load(food.image).into(holder.foodImage)
        holder.itemView.setOnClickListener{
            onClick(food)
        }
    }
}

class FoodViewHolder(view : View) : ViewHolder(view){
    val foodNameTV : TextView = view.findViewById(R.id.food_name)
    val foodImage : ImageView = view.findViewById(R.id.food_image)
    val foodPrice : TextView = view.findViewById(R.id.food_price)
    val foodRating : TextView = view.findViewById(R.id.food_rating)
}