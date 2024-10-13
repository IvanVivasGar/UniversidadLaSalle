package com.example.lasalleapp.ui.theme.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lasalleapp.ui.theme.LaSalleAppTheme
import com.example.lasalleapp.ui.theme.components.ScreenTemplate

@Composable
fun PaymentsScreen(innerPadding: PaddingValues, navController: NavController) {
    ScreenTemplate(innerPadding = innerPadding, header = {

    },body = {
        Text("Hola")
    },headerHeight = 270.dp)
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PaymentsScreenPreview(){
    val navController = rememberNavController()
    LaSalleAppTheme {
        PaymentsScreen(innerPadding = PaddingValues(0.dp), navController = navController)
    }
}