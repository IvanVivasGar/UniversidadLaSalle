package com.example.foodapp.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.adapters.FoodAdapter
import com.example.foodapp.models.Food
import com.example.foodapp.models.Restaurant

class RestaurantActivity : AppCompatActivity() {
    lateinit var restaurantTitle : TextView
    lateinit var foodRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_restaurant)
        restaurantTitle = findViewById(R.id.restaurant_title)
        foodRecyclerView = findViewById(R.id.food_recyclerview)
        val restaurantId = intent.getIntExtra("restaurantId",0)
        Log.i("restaurantActivity","Id pasado: ${restaurantId}")
        //intenta buscar entre toda la lista para que se empareje con nuestra busqueda
        val restaurant = Restaurant.restaurants.firstOrNull{ restaurant ->
            restaurant.id == restaurantId
        }
        Log.i("RestaurantActivity",restaurant.toString())
        restaurantTitle.text = restaurant?.name
        val foods = Food.foods.filter { food ->
            food.restaurantId == restaurantId
        }
        Log.i("RestaurantActivity",foods.toString())
        foodRecyclerView.adapter = FoodAdapter(foods){ food ->
            val intent = Intent(this@RestaurantActivity,FoodDetailActivity::class.java)
            intent.putExtra("foodId",food.id)
            startActivity(intent)
        }
        foodRecyclerView.layoutManager = GridLayoutManager(this, 2)
    }
}