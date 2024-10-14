package com.example.lasalleapp.ui.theme.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.lasalleapp.ui.theme.LaSalleAppTheme
import com.example.lasalleapp.ui.theme.components.ScreenTemplate

@Composable
fun ProvisionalScreen(innerPadding: PaddingValues) {
    ScreenTemplate(innerPadding = innerPadding, header = {

    }, body = {

    }, headerHeight = 200.dp)
}

@Preview
@Composable
fun ProvisionalScreenPreview(){
    val navController = rememberNavController()
    LaSalleAppTheme {
        ProvisionalScreen(innerPadding = PaddingValues(0.dp))
    }
}