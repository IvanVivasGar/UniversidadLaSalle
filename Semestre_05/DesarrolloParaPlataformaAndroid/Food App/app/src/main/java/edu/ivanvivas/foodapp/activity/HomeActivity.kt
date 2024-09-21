package edu.ivanvivas.foodapp.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.ivanvivas.foodapp.MainActivity
import edu.ivanvivas.foodapp.R
import edu.ivanvivas.foodapp.adapters.CategoryAdapter
import edu.ivanvivas.foodapp.adapters.FoodAdapter
import edu.ivanvivas.foodapp.adapters.RestaurantAdapter
import edu.ivanvivas.foodapp.models.Category
import edu.ivanvivas.foodapp.models.Restaurant
import edu.ivanvivas.foodapp.models.Food
import edu.ivanvivas.foodapp.models.User

class HomeActivity : AppCompatActivity() {
    lateinit var usernameTV : TextView
    lateinit var logoutBtn : ImageView
    lateinit var categoryRecyclerView : RecyclerView
    lateinit var restaurantRecyclerView : RecyclerView
    lateinit var foodRecyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE)
        usernameTV = findViewById(R.id.usernameTV)
        logoutBtn = findViewById(R.id.logoutBtn)
        categoryRecyclerView = findViewById(R.id.category_recycleView)
        categoryRecyclerView.adapter = CategoryAdapter(Category.categories)
        categoryRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)



        restaurantRecyclerView = findViewById(R.id.restaurant_recyclerView)
        restaurantRecyclerView.adapter = RestaurantAdapter(Restaurant.restaurants){ restaurant ->
            val intent = Intent(this@HomeActivity, RestaurantActivity::class.java)
            intent.putExtra("restaurantId", restaurant.id)
            startActivity(intent)
        }
        restaurantRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        foodRecyclerView = findViewById(R.id.best_food_recyclerView)
        foodRecyclerView.adapter = FoodAdapter(Food.foods){ food : Food ->
            val intent = Intent(this@HomeActivity, FoodItemActivity::class.java)
            intent.putExtra("foodId", food.id)
            startActivity(intent)
        }
        foodRecyclerView.layoutManager = GridLayoutManager(this, 2)

        val user = User.users[1]
        usernameTV.text = user.computedName

        logoutBtn.setOnClickListener{
            Log.i("LOGOUT", "Cerrando sesion")
            val editor = sharedPreferences.edit()
            editor.remove("isLogged")
            editor.apply()
            val intent = Intent(this@HomeActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}