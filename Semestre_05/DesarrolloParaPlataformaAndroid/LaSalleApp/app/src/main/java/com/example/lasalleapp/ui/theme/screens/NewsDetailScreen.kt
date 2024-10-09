package com.example.lasalleapp.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.lasalleapp.ui.theme.utils.newsList

@Composable
fun NewsDetailScreen(newsId: Int, innerPadding: PaddingValues) {
    val news = newsList.first {it.id == newsId}

    Column(
        modifier = Modifier
        .padding(innerPadding)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = news.image,
            contentDescription = news.title,
            modifier = Modifier.fillMaxWidth().height(300.dp)
        )
        Text(
            text = news.title,
            modifier = Modifier.padding(horizontal = 16.dp),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.W900
        )
        Text(
            text = news.description,
            modifier = Modifier.padding(horizontal = 16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}