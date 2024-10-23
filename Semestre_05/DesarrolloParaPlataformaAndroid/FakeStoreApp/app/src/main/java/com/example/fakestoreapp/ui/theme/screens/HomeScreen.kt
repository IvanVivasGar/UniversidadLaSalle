package com.example.fakestoreapp.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.fakestoreapp.models.Product
import com.example.fakestoreapp.services.ProductService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun HomeScreen(innerPadding : PaddingValues) {
    val scope = rememberCoroutineScope()
    var products by remember {
        mutableStateOf(listOf<Product>())
    }
    var isLoading by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = true) {
        try{
            scope.launch{
                // La llamada a la API
                isLoading = true
                val BASE_URL = "https://fakestoreapi.com/"
                val productService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ProductService::class.java)
                products = productService.getProducts()
                Log.i("HomeScreenResponse", products.toString())
                isLoading = false
            }
        }catch (e:Exception){
            products = listOf()
            isLoading = false
        }
    }

    LazyColumn (
        modifier = Modifier.padding(innerPadding)
    ){
        items(products){ product ->
            Text(text = product.title)
        }

    }
}