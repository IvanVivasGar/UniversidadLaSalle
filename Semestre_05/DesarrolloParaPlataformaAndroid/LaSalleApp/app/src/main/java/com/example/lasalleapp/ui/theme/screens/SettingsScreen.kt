package com.example.lasalleapp.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.lasalleapp.R
import com.example.lasalleapp.models.Student
import com.example.lasalleapp.ui.theme.LaSalleAppTheme
import com.example.lasalleapp.ui.theme.components.ScreenTemplate
import com.example.lasalleapp.ui.theme.utils.Password
import com.example.lasalleapp.ui.theme.utils.Screens
import com.example.lasalleapp.ui.theme.utils.SunMoon
import com.example.lasalleapp.ui.theme.utils.studentsList

@Composable
fun SettingsScreen(
    innerPadding: PaddingValues,
    navController: NavController,
    students: Student) {
    ScreenTemplate(innerPadding = innerPadding, header = {
        Row (
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ){
            Box(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .clip(RoundedCornerShape(60.dp))
                    .background(Color.White)
            ){
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .placeholder(R.drawable.portrait_1)
                        .data(students.photo)
                        .build(),
                    contentDescription = "CardImage",
                    modifier = Modifier.fillMaxWidth().height(200.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Column (
                modifier = Modifier.padding(start = 16.dp)
            ){
                Text(
                    text = students.name,
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = MaterialTheme.typography.bodyMedium.fontWeight)
                Text(
                    text = students.email,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = MaterialTheme.typography.bodySmall.fontWeight,
                    modifier = Modifier.padding(top = 5.dp))
                Text(
                    text = students.birthdate,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = MaterialTheme.typography.bodySmall.fontWeight,
                    modifier = Modifier.padding(top = 3.dp))
            }
        }
    },body = {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White)
        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.LightGray)
                        .clickable {
                            navController.navigate(Screens.Provisional.route)
                        }
                ){
                    Icon(imageVector = Password,
                        contentDescription = "Icon",
                        modifier = Modifier.padding(10.dp),
                        tint = MaterialTheme.colorScheme.primary)

                    Text(text = "Cambiar Contraseña",
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = MaterialTheme.typography.bodySmall.fontWeight)
                }

                Row(modifier = Modifier.padding(5.dp)){}

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.LightGray)
                        .clickable {
                            navController.navigate(Screens.Provisional.route)
                        }
                ){
                    Icon(imageVector = SunMoon,
                        contentDescription = "Icon",
                        modifier = Modifier.padding(10.dp),
                        tint = MaterialTheme.colorScheme.primary)

                    Text(text = "Cambiar Tema",
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = MaterialTheme.typography.bodySmall.fontWeight)
                }
            }
        }
    })
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SettingsScreenPreview(){
    val navController = rememberNavController()
    LaSalleAppTheme {
        SettingsScreen(innerPadding = PaddingValues(0.dp), navController = navController, students = studentsList[0])
    }
}