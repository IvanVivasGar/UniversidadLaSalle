package com.example.foodapp.activity

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.foodapp.R
import com.example.foodapp.adapters.FoodAdapter
import com.example.foodapp.models.Food
import com.example.foodapp.models.Restaurant
import com.squareup.picasso.Picasso

class FoodDetailActivity : AppCompatActivity() {
    lateinit var foodTextView: TextView
    lateinit var foodPriceTextView: TextView
    lateinit var foodDescriptionTextView: TextView
    lateinit var foodImageView: ImageView
    lateinit var foodRatingTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_food_detail)
        foodTextView = findViewById(R.id.food_title)
        foodPriceTextView = findViewById(R.id.food_price)
        foodDescriptionTextView = findViewById(R.id.food_description)
        foodImageView = findViewById(R.id.food_image)
        foodRatingTextView = findViewById(R.id.food_rating)


        val foodId = intent.getIntExtra("foodId",0)

        //intenta buscar entre toda la lista para que se empareje con nuestra busqueda
        val food = Food.foods.firstOrNull{ food : Food ->
            food.id == foodId
        }
        foodTextView.text = food?.name
        foodPriceTextView.text = food?.computedPrice
        foodRatingTextView.text = food?.rating.toString()
        foodDescriptionTextView.text = food?.description
        Picasso.get().load(food?.image).into(foodImageView)
    }
}