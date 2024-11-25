package com.example.taskapp.datasources.services

import com.example.taskapp.domain.dtos.LoginDto
import com.example.taskapp.domain.dtos.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST
    suspend fun login(@Body login : LoginDto) : Response<LoginResponse>
}