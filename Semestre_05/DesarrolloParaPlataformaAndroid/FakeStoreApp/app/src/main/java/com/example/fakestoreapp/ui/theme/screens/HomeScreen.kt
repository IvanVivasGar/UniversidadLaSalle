package com.example.fakestoreapp.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.fakestoreapp.models.Product
import com.example.fakestoreapp.services.ProductService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun HomeScreen(innerPadding : PaddingValues, navController: NavController) {
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

    if(isLoading){
        Box(
            modifier = Modifier.padding(innerPadding).fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    }else{
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ){
            items(products){
                Card (
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.White)
                        .height(200.dp)
                        .padding(5.dp)
                        .clickable {
                            navController.navigate("detail/${it.id}")
                        }
                ){
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        AsyncImage(model = it.image,
                            contentDescription = it.title,
                            modifier = Modifier.fillMaxWidth().weight(3f),
                            contentScale = ContentScale.Crop)
                        Text(text = it.computedTitle,
                            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        )
                    }
                }
            }
        }
    }
}