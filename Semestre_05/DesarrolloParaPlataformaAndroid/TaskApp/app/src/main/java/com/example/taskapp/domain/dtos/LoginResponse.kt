package com.example.taskapp.domain.dtos

data class LoginResponse (
    val userId : Int,
    val isLogged : Boolean,
    val message : String
)