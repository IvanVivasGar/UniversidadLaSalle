package com.example.lasalleapp.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lasalleapp.models.Alumn
import com.example.lasalleapp.ui.theme.LaSalleAppTheme
import com.example.lasalleapp.ui.theme.components.ClassItem
import com.example.lasalleapp.ui.theme.components.ScreenTemplate
import com.example.lasalleapp.ui.theme.utils.alumnsList

@Composable
fun GradesScreen(innerPadding: PaddingValues, navController: NavController, alumns: Alumn) {
    ScreenTemplate(innerPadding = innerPadding, header = {
        Column (
            modifier = Modifier.fillMaxSize()
                .padding(35.dp)
        ){
            Text(
                text = alumns.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                color = Color.White,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            Text(
                text = alumns.career,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
                color = Color.White,
                modifier = Modifier.padding(bottom = 3.dp)
            )
            Text(
                text = "Semestre: " + alumns.currentSemester.toString(),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
                color = Color.White,
                modifier = Modifier.padding(bottom = 3.dp)
            )
            Text(
                text = "Promedio general: " + alumns.grade.toString(),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
                color = Color.White,
                modifier = Modifier.padding(bottom = 3.dp)
            )
        }
    },body = {
        LazyColumn (
            modifier = Modifier.height(550.dp).padding(16.dp)
        ){
            items (20){
                ClassItem()
            }
        }
    })
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GradesScreenPreview(){
    LaSalleAppTheme {
        GradesScreen(innerPadding = PaddingValues(0.dp), navController = NavController(LocalContext.current), alumns = alumnsList[0])
    }
}