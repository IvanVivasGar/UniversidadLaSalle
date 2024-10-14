package com.example.lasalleapp.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
fun ClassItem(className: String,
              classGrade: Double,
              onClick: () -> Unit){
    Column (
        modifier = Modifier.padding(5.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(Color.LightGray)
                .clickable {
                    onClick()
                },
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = className,
                modifier = Modifier.align(Alignment.CenterVertically).padding(top = 10.dp, bottom = 10.dp, start = 15.dp),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = MaterialTheme.typography.bodyMedium.fontWeight
            )

            Text(
                text = classGrade.toString(),
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
    ClassItem("Administracion de bases de datos", 9.0, onClick = {})
}