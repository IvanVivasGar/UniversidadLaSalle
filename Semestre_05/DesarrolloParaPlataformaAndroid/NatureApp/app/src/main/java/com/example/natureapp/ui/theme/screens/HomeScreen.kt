package com.example.natureapp.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lasalleapp.ui.theme.components.CardImage
import com.example.natureapp.ui.theme.NatureAppTheme

@Composable
fun HomeScreen(innerPadding: PaddingValues){
    val images = listOf(
        "https://a.travel-assets.com/findyours-php/viewfinder/images/res70/122000/122244-Bernese-Alps-Area.jpg",
        "https://res.cloudinary.com/enchanting/f_auto,q_70/et-web/2015/08/shutterstock_117983893_Bentota_Sri-Lanka.jpg",
        "https://www.littlegatepublishing.com/wp-content/uploads/2016/04/fatjoeocean1.jpg",
        "https://www.movingtoportugal.pt/wp-content/uploads/2020/11/Viver_Nazare_630_420-1.jpg",
        "https://media.es.wired.com/photos/664bafaf272f2f7e9130a872/16:9/w_2992,h_1683,c_limit/piramides%20de%20egipto%20rio%20oculto.jpg"
    )

    val titles = listOf(
        "Alpes Suizos, Suiza",
        "Playa Bentota, Sri Lanka",
        "Urho Kekkonen, Finlandia",
        "Nazaré, Portugal",
        "Pirámides de Egipto, Egipto"
    )

    val descriptions = listOf(
        "Imponentes montañas con paisajes nevados y senderos alpinos.",
        "Hermosa playa tropical con arenas doradas y aguas cristalinas.",
        "Parque nacional ártico con vastos paisajes de tundra y auroras boreales.",
        "Destino mundialmente famoso por sus gigantescas olas para el surf.",
        "Antiguas estructuras monumentales que datan de la época de los faraones."
    )

    Box (
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ){
        Column (
            modifier = Modifier.padding(10.dp)
        ){
            LazyColumn(){
                items(images.size){
                    CardImage(
                        image = images[it],
                        title = titles[it],
                        description = descriptions[it]
                    )
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
    NatureAppTheme {
        HomeScreen(innerPadding = PaddingValues(0.dp))
    }
}