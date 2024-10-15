package com.example.lasalleapp.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lasalleapp.ui.theme.LaSalleAppTheme
import com.example.lasalleapp.ui.theme.components.DayItem
import com.example.lasalleapp.ui.theme.components.ScreenTemplate

@Composable
fun CalendarScreen(innerPadding: PaddingValues, navController: NavController) {
    ScreenTemplate(innerPadding = innerPadding, header = {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ){
            Text(
                text = "Calendario",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = "Enero",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
            ){
                items(31){
                    DayItem(day = it)
                }
            }
        }
    },body = {

    }, headerHeight = 270.dp)
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun CalendarScreenPreview(){
    val navController = rememberNavController()
    LaSalleAppTheme {
        CalendarScreen(innerPadding = PaddingValues(0.dp), navController = navController)
    }
}