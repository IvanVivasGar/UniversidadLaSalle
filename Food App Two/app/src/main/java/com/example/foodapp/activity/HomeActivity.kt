package com.example.foodapp.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.MainActivity
import com.example.foodapp.R
import com.example.foodapp.adapters.CategoryAdapter
import com.example.foodapp.adapters.FoodAdapter
import com.example.foodapp.adapters.RestaurantAdapter
import com.example.foodapp.models.Category
import com.example.foodapp.models.Food
import com.example.foodapp.models.Restaurant
import com.example.foodapp.models.User

class HomeActivity : AppCompatActivity() {
    lateinit var usernameTV : TextView
    lateinit var logoutBtn : ImageView
    lateinit var categoryRecyclerView: RecyclerView
    lateinit var restaurantRecyclerView: RecyclerView
    lateinit var foodRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        val sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE)
        usernameTV = findViewById(R.id.usernameTV)
        logoutBtn = findViewById(R.id.logoutBtn)

        //CATEGORY
        categoryRecyclerView = findViewById(R.id.category_recycleview)
        //MANDAMOS A LLAMAR LOS RECYCLEVIEW
        categoryRecyclerView.adapter = CategoryAdapter(Category.categories)
        //Organiza los elementos
        categoryRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        //RESTAURANT
        restaurantRecyclerView = findViewById(R.id.restaurant_recyclerview)
        restaurantRecyclerView.adapter = RestaurantAdapter(Restaurant.restaurants){ restaurant ->
            Log.i("Restaurant desde Home", restaurant.name)
            val intent = Intent(this@HomeActivity,RestaurantActivity::class.java)
            intent.putExtra("restaurantId",restaurant.id)
            startActivity(intent)
        }

        restaurantRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        //FOOD
        foodRecyclerView = findViewById(R.id.best_food_recycleview)
        foodRecyclerView.adapter = FoodAdapter(Food.foods){food: Food ->
            val intent = Intent(this@HomeActivity,FoodDetailActivity::class.java)
            intent.putExtra("foodId",food.id)
            startActivity(intent)
        }
        foodRecyclerView.layoutManager = GridLayoutManager(this, 2)

        val user = User.users[1]
        usernameTV.text = user.computerName
        logoutBtn.setOnClickListener {
            Log.i("LOGOUT","CERRANDO SESION")
            val editor = sharedPreferences.edit()
            editor.remove("isLogged")
            editor.apply()

            val intent = Intent(this@HomeActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
            
        }
    }
}