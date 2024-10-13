package com.example.lasalleapp.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ClassItem(){
    Column (
        modifier = Modifier.padding(5.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(Color.LightGray),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "Clase",
                modifier = Modifier.align(Alignment.CenterVertically).padding(top = 10.dp, bottom = 10.dp, start = 15.dp),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = MaterialTheme.typography.bodyMedium.fontWeight
            )

            Text(
                text = "9.4",
                modifier = Modifier.align(Alignment.CenterVertically).padding(top = 10.dp, bottom = 10.dp, end = 15.dp),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = MaterialTheme.typography.bodyMedium.fontWeight
            )
        }
    }
}

@Preview
@Composable
fun ClassItemPreview(){
    ClassItem()
}