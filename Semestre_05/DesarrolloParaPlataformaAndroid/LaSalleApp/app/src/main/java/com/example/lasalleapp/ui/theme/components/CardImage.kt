package com.example.lasalleapp.ui.theme.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.lasalleapp.R
import com.example.lasalleapp.models.News
import com.example.lasalleapp.ui.theme.utils.newsList

@Composable
fun CardImage(news : News, onClick : (News) -> Unit){
    Card (
        modifier = Modifier.fillMaxWidth().clickable {
            onClick(news)
        }
    ){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .placeholder(R.drawable.news_1)
                .data(news.image)
                .build(),
            contentDescription = "CardImage",
            modifier = Modifier.fillMaxWidth().height(200.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
fun CardImagePreview(){
    CardImage(news = newsList[0]){ news ->
        println(news.title)
        // Navegacion
    }
}