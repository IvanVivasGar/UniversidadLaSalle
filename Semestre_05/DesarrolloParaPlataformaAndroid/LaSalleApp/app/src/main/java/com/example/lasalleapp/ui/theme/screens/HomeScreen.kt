package com.example.lasalleapp.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.lasalleapp.R
import com.example.lasalleapp.ui.theme.LaSalleAppTheme
import com.example.lasalleapp.ui.theme.components.CardImage
import com.example.lasalleapp.ui.theme.utils.Logout

@Composable
fun HomeScreen(innerPadding: PaddingValues){
    val news = listOf(
        "https://www.lasallebajio.edu.mx/noticias/images/4719_3.jpg",
        "https://www.lasallebajio.edu.mx/noticias/images/4718_1.jpg",
        "https://www.lasallebajio.edu.mx/noticias/images/4718_3.jpg"
    )
    
    Column (
        modifier = Modifier.fillMaxSize()
            .padding(innerPadding)
            .background(Color.White)
    ) {
        // Header
        Box(
            modifier = Modifier.fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 60.dp, bottomEnd = 60.dp))
                .height(270.dp)
                .background(MaterialTheme.colorScheme.primary)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://www.lasallebajio.edu.mx/comunidad/images/imagotipos/Elementos%20Gr%C3%A1ficos/Edificios%20en%20vectores-13.png")
                    .build()
                , contentDescription = "Background Image",
                modifier = Modifier.fillMaxSize().offset(y = 70.dp)
            )
            Row (
                modifier = Modifier.fillMaxWidth().padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier.size(70.dp)
                )

                Column(
                    modifier = Modifier.weight(1f)
                ){
                    Text(text = stringResource(id = R.string.welcome_text), color = Color.White, fontSize = 18.sp)
                    Text(
                        text = "Ivan Vivas",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 15.dp)
                    )
                }

                Icon(imageVector = Logout,
                    contentDescription = "Logout",
                    modifier = Modifier.size(45.dp).clickable {
                        Log.i("HomeScreen", "Cerrando Sesion")
                    },
                    tint = Color.White
                )
            }
        }

        // Body
        Box (
            modifier = Modifier.fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ){
            Column (
                modifier = Modifier.padding(20.dp)
            ){
                Text(text = stringResource(id = R.string.news),
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp
                )
                LazyRow(){
                    items(news.size){
                        CardImage(image = news[it])
                    }
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)

@Composable
fun HomeScreenPreview(){
    LaSalleAppTheme {
        HomeScreen(innerPadding = PaddingValues(0.dp))
    }
}