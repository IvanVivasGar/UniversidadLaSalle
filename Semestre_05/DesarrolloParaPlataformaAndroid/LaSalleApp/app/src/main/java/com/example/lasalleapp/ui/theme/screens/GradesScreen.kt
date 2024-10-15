package com.example.lasalleapp.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lasalleapp.models.Student
import com.example.lasalleapp.ui.theme.LaSalleAppTheme
import com.example.lasalleapp.ui.theme.components.ClassItem
import com.example.lasalleapp.ui.theme.components.ScreenTemplate
import com.example.lasalleapp.ui.theme.utils.studentsList

@Composable
fun GradesScreen(innerPadding: PaddingValues, navController: NavController, students: Student) {
    ScreenTemplate(innerPadding = innerPadding, header = {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(35.dp)
        ){
            Text(
                text = students.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                color = Color.White,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            Text(
                text = students.career.name,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
                color = Color.White,
                modifier = Modifier.padding(bottom = 3.dp)
            )
            Text(
                text = "Semestre: " + students.currentSemester.toString(),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
                color = Color.White,
                modifier = Modifier.padding(bottom = 3.dp)
            )
            Text(
                text = "Promedio general: " + students.grade.toString(),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
                color = Color.White,
                modifier = Modifier.padding(bottom = 5.dp)
            )
        }
    },body = {
        LazyColumn (
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
        ){
            itemsIndexed (students.career.subjects.filter { it.coursed }){index, subject ->
                ClassItem(students.career.subjects[index].name,
                    students.career.subjects[index].finalGrade,
                    onClick = {
                        navController.navigate("subject_detail_screen/${subject.id}")
                    })
            }
        }
    }, headerHeight = 205.dp)
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GradesScreenPreview(){
    LaSalleAppTheme {
        GradesScreen(innerPadding = PaddingValues(0.dp), navController = NavController(LocalContext.current), students = studentsList[0])
    }
}