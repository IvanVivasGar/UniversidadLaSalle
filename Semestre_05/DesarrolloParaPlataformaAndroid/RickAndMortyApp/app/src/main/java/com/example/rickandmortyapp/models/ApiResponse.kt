package com.example.rickandmortyapp.models

data class ApiResponse(
    val info: Info,
    val results: List<Character>
)