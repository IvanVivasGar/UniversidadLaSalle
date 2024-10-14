package com.example.lasalleapp.ui.theme.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lasalleapp.ui.theme.LaSalleAppTheme

@Composable
fun SebjectDetailScreen(innerPadding: PaddingValues) {

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SubjectDetailScreenPreview(){
    LaSalleAppTheme {
        SebjectDetailScreen(innerPadding = PaddingValues(0.dp))
    }
}