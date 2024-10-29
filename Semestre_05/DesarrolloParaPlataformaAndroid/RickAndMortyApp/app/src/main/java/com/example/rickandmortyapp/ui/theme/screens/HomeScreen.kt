package com.example.rickandmortyapp.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.rickandmortyapp.models.Character
import com.example.rickandmortyapp.services.CharacterService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun HomeScreen(innerPadding: PaddingValues, navController: NavController) {
    val scope = rememberCoroutineScope()
    var characters by remember {
        mutableStateOf(listOf<Character>())
    }
    var isLoading by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = true) {
        scope.launch {
            try {
                // La llamada a la API
                isLoading = true
                val BASE_URL = "https://rickandmortyapi.com/api/"
                val characterService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(CharacterService::class.java)

                val response = characterService.getCharacters()
                characters = response.results
                Log.i("HomeScreenResponse", characters.toString())
                isLoading = false
            } catch (e: Exception) {
                characters = listOf()
                isLoading = false
            }
        }
    }

    if (isLoading) {
        Box(
            modifier = Modifier.padding(innerPadding).fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray)
                .padding(innerPadding)
        ){
            Column (
                modifier = Modifier
                    .fillMaxSize()
            ){
                Text(text = "Rick and Morty",
                    fontSize = 30.sp,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                        .align(Alignment.CenterHorizontally))

                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ){
                    items(characters){
                        Card (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                                .background(Color.DarkGray)
                                .padding(start = 15.dp, end = 15.dp, top = 15.dp).clickable {
                                    navController.navigate("detail/${it.id}")
                                }
                        ){
                            Row (
                                modifier = Modifier.fillMaxSize()
                            ){
                                Log.i("Image URL", it.image)
                                AsyncImage(
                                    model = it.image,
                                    contentDescription = it.name,
                                    modifier = Modifier
                                        .width(120.dp)
                                        .fillMaxHeight(),
                                    contentScale = ContentScale.Crop
                                )

                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(10.dp),
                                ) {
                                    Text(text = it.name,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(text = it.species,
                                        fontSize = 15.sp)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}