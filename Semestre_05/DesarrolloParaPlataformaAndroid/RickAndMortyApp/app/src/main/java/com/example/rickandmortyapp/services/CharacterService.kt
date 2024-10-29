package com.example.rickandmortyapp.services

import com.example.rickandmortyapp.models.ApiResponse
import com.example.rickandmortyapp.models.Character
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {
    @GET("character")
    suspend fun getCharacters(): ApiResponse

    @GET("character/{id}")
    suspend fun getCharactersById(@Path("id")id: Int): Character
}