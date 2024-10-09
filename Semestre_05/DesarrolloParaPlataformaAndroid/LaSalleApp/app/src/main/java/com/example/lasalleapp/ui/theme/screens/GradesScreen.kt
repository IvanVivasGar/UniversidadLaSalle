package com.example.lasalleapp.ui.theme.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.lasalleapp.ui.theme.components.ScreenTemplate

@Composable
fun GradesScreen(innerPadding: PaddingValues) {
    ScreenTemplate(innerPadding = innerPadding, header = {
        Text("Hola")
    },body = {
            Text("Hola")
    })
}