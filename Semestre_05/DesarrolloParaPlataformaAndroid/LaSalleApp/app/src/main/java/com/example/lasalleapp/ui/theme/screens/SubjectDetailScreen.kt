package com.example.lasalleapp.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lasalleapp.models.Subject
import com.example.lasalleapp.ui.theme.LaSalleAppTheme
import com.example.lasalleapp.ui.theme.components.ClassItem
import com.example.lasalleapp.ui.theme.components.ScreenTemplate

@Composable
fun SubjectDetailScreen(innerPadding: PaddingValues, subject: Subject) {
    ScreenTemplate(innerPadding = innerPadding, header = {
        Column(
            modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 40.dp)
        ){
            Text(
                text = subject.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = MaterialTheme.typography.titleMedium.fontWeight,
                color = Color.White,
                modifier = Modifier.padding(bottom = 5.dp))
            Text(
                text = "Calificacion Final: " + subject.finalGrade.toString(),
                style = MaterialTheme.typography.bodySmall,
                fontWeight = MaterialTheme.typography.bodySmall.fontWeight,
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp, bottom = 3.dp))
            Text(
                text = "Id: " + subject.id.toString(),
                style = MaterialTheme.typography.bodySmall,
                fontWeight = MaterialTheme.typography.bodySmall.fontWeight,
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp, bottom = 3.dp))
        }
    },body = {
        LazyColumn (
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
        ){
            items (1){
                ClassItem("Parcial 1", subject.firstCut, onClick = {})
                ClassItem("Parcial 2", subject.secondCut, onClick = {})
                ClassItem("Parcial 3", subject.thirdCut, onClick = {})
            }
        }
    })
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SubjectDetailScreenPreview(){
    LaSalleAppTheme {
        SubjectDetailScreen(innerPadding = PaddingValues(0.dp),
            subject = Subject(1, "Administracion de bases de datos", 9.0, 9.0, 9.0))
    }
}