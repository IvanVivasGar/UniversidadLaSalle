package edu.ivanvivas.foodapp.activity

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.ivanvivas.foodapp.R
import edu.ivanvivas.foodapp.adapters.FoodAdapter
import edu.ivanvivas.foodapp.models.Food
import edu.ivanvivas.foodapp.models.Restaurant

class RestaurantActivity : AppCompatActivity() {
    lateinit var restaurantTitle : TextView
    lateinit var foodRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_restaurant)
        restaurantTitle = findViewById(R.id.restaurant_title)
        foodRecyclerView = findViewById(R.id.food_recyclerView)
        val restaurantId = intent.getIntExtra("restaurantId", 0)

        val restaurant = Restaurant.restaurants.firstOrNull { restaurant ->
            restaurant.id == restaurantId
        }
        restaurantTitle.text = restaurant?.name

        val foods = Food.foods.filter { food ->
            food.restaurantId == restaurantId
        }
        foodRecyclerView.adapter = FoodAdapter(foods)
        foodRecyclerView.layoutManager = GridLayoutManager(this, 2)
    }
}