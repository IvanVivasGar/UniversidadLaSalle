package com.example.lasalleapp.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lasalleapp.ui.theme.LaSalleAppTheme
import com.example.lasalleapp.ui.theme.components.PaymentItem
import com.example.lasalleapp.ui.theme.components.ScreenTemplate

@Composable
fun PaymentsScreen(innerPadding: PaddingValues, navController: NavController) {
    Column (
        modifier = Modifier.fillMaxSize().padding(innerPadding)
    ){
        Text("Pagos Pendientes")
        LazyColumn (
            modifier = Modifier.fillMaxSize().padding(10.dp)
        ){
            items (4){
                PaymentItem()
            }
        }

        Text("Pagos Realizados")
        LazyColumn (
            modifier = Modifier.fillMaxSize().padding(10.dp)
        ){
            items (2){
                PaymentItem()
            }
        }
    }
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