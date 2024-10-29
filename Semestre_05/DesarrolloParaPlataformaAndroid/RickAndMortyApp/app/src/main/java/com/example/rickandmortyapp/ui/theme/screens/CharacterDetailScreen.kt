package com.example.rickandmortyapp.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.rickandmortyapp.ui.theme.RickAndMortyAppTheme
import com.example.rickandmortyapp.models.Character
import com.example.rickandmortyapp.models.Location
import com.example.rickandmortyapp.models.Origin
import com.example.rickandmortyapp.services.CharacterService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun CharacterDetailScreen(innerPadding: PaddingValues, characterId: Int) {
    val scope = rememberCoroutineScope()
    var isLoading by remember {
        mutableStateOf(false)
    }
    var character by remember {
        mutableStateOf(Character(
            id = 0,
            name = "",
            image = "",
            status = "",
            created = "",
            episode = emptyList(),
            gender = "",
            location = Location(name = "", url = ""),
            origin = Origin(name = "", url = ""),
            species = "",
            type = "",
            url = ""
        ))
    }

    LaunchedEffect(key1 = true) {
        scope.launch {
            val BASE_URL = "https://rickandmortyapi.com/api/"
            val characterService = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CharacterService::class.java)
            isLoading = true
            character = characterService.getCharactersById(characterId)
            isLoading = false
        }
    }

    if(isLoading){
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    }else{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.3f)
                    .background(Color.White),
                Arrangement.Center
            ){
                AsyncImage(
                    model = character.image,
                    contentDescription = character.name,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally)
                )
                Text(
                    text = character.name,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontSize = 30.sp,
                    color = Color.Black)
            }

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.7f)
                    .background(Color.DarkGray)
                    .verticalScroll(rememberScrollState()).padding(15.dp)
            ){
                Text(
                    text = "Status: " + character.status,
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 10.dp),
                    fontSize = 18.sp,
                    color = Color.White)
                Text(
                    text = "Creado el: " + character.created,
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 10.dp),
                    fontSize = 18.sp,
                    color = Color.White)
                Text(
                    text = "Genero: " + character.gender,
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 10.dp),
                    fontSize = 18.sp,
                    color = Color.White)
                Text(
                    text = "Ubicacion: " + character.location.name,
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 10.dp),
                    fontSize = 18.sp,
                    color = Color.White)
                Text(
                    text = "Origen: " + character.origin.name,
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 10.dp),
                    fontSize = 18.sp,
                    color = Color.White)
                Text(
                    text = "Especie: " + character.species,
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 10.dp),
                    fontSize = 18.sp,
                    color = Color.White)
            }
        }
    }
}

@Preview
@Composable
fun CharacterDetailScreenPreview() {
    RickAndMortyAppTheme {
        CharacterDetailScreen(innerPadding = PaddingValues(), characterId = 1)
    }
}