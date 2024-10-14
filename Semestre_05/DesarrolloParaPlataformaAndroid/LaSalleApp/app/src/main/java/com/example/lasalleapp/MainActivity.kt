package com.example.lasalleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lasalleapp.ui.theme.LaSalleAppTheme
import com.example.lasalleapp.ui.theme.screens.CalendarScreen
import com.example.lasalleapp.ui.theme.screens.GradesScreen
import com.example.lasalleapp.ui.theme.screens.HomeScreen
import com.example.lasalleapp.ui.theme.screens.NewsDetailScreen
import com.example.lasalleapp.ui.theme.screens.PaymentsScreen
import com.example.lasalleapp.ui.theme.screens.SettingsScreen
import com.example.lasalleapp.ui.theme.utils.Screens
import com.example.lasalleapp.ui.theme.utils.bottomNavBarItems
import com.example.lasalleapp.ui.theme.utils.studentsList
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            var selectedItemIndex by rememberSaveable {
                mutableStateOf(0)
            }
            val bottomNavRoutes = listOf(
                Screens.Home.route,
                Screens.Calendar.route,
                Screens.Grades.route,
                Screens.Settings.route,
                Screens.Payments.route
            )
            LaSalleAppTheme {
                val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        if(currentRoute in bottomNavRoutes){
                            AnimatedNavigationBar(
                                selectedIndex = selectedItemIndex,
                                modifier = Modifier.height(90.dp),
                                barColor = MaterialTheme.colorScheme.primary,
                                ballColor = MaterialTheme.colorScheme.primary,
                                cornerRadius = shapeCornerRadius(topLeft = 34.dp, topRight = 34.dp, bottomLeft = 0.dp, bottomRight = 0.dp)
                            ){
                                bottomNavBarItems.forEachIndexed { index, bottomNavigationItem ->
                                    Column (
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center,
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .clickable {
                                                selectedItemIndex = index
                                                navController.navigate(bottomNavigationItem.route)
                                            }
                                    ){
                                        Icon(
                                            imageVector = bottomNavigationItem.icon,
                                            contentDescription = bottomNavigationItem.title,
                                            tint = if(selectedItemIndex == index) Color.White else Color.White.copy(alpha = 0.5f),
                                            modifier = Modifier.size(26.dp))
                                        Text(
                                            text = bottomNavigationItem.title,
                                            style = MaterialTheme.typography.bodySmall,
                                            color = if(selectedItemIndex == index) Color.White else Color.White.copy(alpha = 0.5f))
                                    }
                                }
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(navController = navController, startDestination = Screens.Home.route) {
                        composable(route = Screens.Home.route){
                            HomeScreen(innerPadding = innerPadding, navController = navController)
                        }
                        composable(route = Screens.Calendar.route){
                            CalendarScreen(innerPadding = innerPadding, navController = navController)
                        }
                        composable(route = Screens.Grades.route){
                            GradesScreen(innerPadding = innerPadding, navController = navController, students = studentsList[0])
                        }
                        composable(route = Screens.Settings.route){
                            SettingsScreen(innerPadding = innerPadding, navController = navController, students = studentsList[0])
                        }
                        composable(
                            route = Screens.NewsDetail.route + "/{id}",
                            arguments = listOf(
                                navArgument("id"){
                                    type = NavType.IntType
                                    nullable = false
                                }
                            )
                        ){
                            val id = it.arguments?.getInt("id", 0) ?:0
                            NewsDetailScreen(newsId = id, innerPadding = innerPadding)
                        }
                        composable(route = Screens.Payments.route){
                            PaymentsScreen(innerPadding = innerPadding, navController = navController)
                        }
                    }
                }
            }
        }
    }
}