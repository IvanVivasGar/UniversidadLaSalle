package com.example.taskapp.presentation.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskapp.R
import com.example.taskapp.datasources.services.AuthService
import com.example.taskapp.domain.dtos.LoginDto
import com.example.taskapp.presentation.ui.theme.TaskAppTheme
import com.example.taskapp.presentation.ui.utils.Lock
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun LoginScreen(innerPadding: PaddingValues = PaddingValues(0.dp)){
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()

    Column (
        modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Taskly")
        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = "login",
            modifier = Modifier.size(250.dp)
        )
        OutlinedTextField(value = email,
            onValueChange = { email = it },
            Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            placeholder = {Text(text = "Correo Electronico")},
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "email")}
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = password,
            onValueChange = { password = it },
            Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            placeholder = {Text(text = "Contraseña")},
            leadingIcon = { Icon(imageVector = Lock, contentDescription = "contraseña")},
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(15.dp))
        Button(onClick = {
            scope.launch {
                if(email.isNotEmpty() && password.isNotEmpty()){
                    val authService = Retrofit.Builder()
                        .baseUrl("https://taskapi.juanfrausto.com/api")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(AuthService::class.java)
                    val loginDto = LoginDto(email = email, password = password)
                    val response = authService.login(loginDto)
                    Log.i("LoginScreenAPI", response.toString())
                }
            }
        },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)) {
            Text(text = "Iniciar Sesión")
        }
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "¿No tienes una cuenta? Crea una",
            color = Color.Gray,
            modifier = Modifier.clickable {

        })
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun LoginScreenPreview() {
    TaskAppTheme {
        LoginScreen()
    }
}