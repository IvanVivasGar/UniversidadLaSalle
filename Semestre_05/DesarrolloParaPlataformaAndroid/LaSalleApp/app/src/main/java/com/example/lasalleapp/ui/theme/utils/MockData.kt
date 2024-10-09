package com.example.lasalleapp.ui.theme.utils
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import com.example.lasalleapp.models.BottomNavigationItem
import com.example.lasalleapp.models.Community
import com.example.lasalleapp.models.News

val newsList = listOf(
    News(
        id = 1,
        title = "Evento de Construcción de la Paz",
        description = "La Salle Bajío realiza un foro para fomentar la construcción de la paz en la comunidad estudiantil.",
        image =  "https://www.lasallebajio.edu.mx/noticias/images/4701_1.jpg"
    ),
    News(
        id = 2,
        title = "Conferencia de Liderazgo",
        description = "Una conferencia que destaca la importancia del liderazgo en la comunidad universitaria.",
        image = "https://www.lasallebajio.edu.mx/noticias/images/4701_2.jpg"
    ),
    News(
        id = 3,
        title = "Semana Cultural 2024",
        description = "Celebración anual de la Semana Cultural con diversas actividades artísticas y deportivas.",
        image = "https://www.lasallebajio.edu.mx/noticias/images/4701_3.jpg"
    )
)

val bottomNavBarItems = listOf(
    BottomNavigationItem(
        title = "Inicio",
        icon = Icons.Default.Home,
        route = Screens.Home.route

    ),
    BottomNavigationItem(
        title = "Calificaciones",
        icon = Icons.Default.Menu,
        route = Screens.Grades.route

    ),
    BottomNavigationItem(
        title = "Calendario",
        icon = Icons.Default.DateRange,
        route = Screens.Calendar.route

    ),
    BottomNavigationItem(
        title = "Configuracion",
        icon = Icons.Default.Settings,
        route = Screens.Settings.route

    )
)

val communities = listOf(
    Community(1,"https://www.lasallebajio.edu.mx/comunidad/images/tile_documentos_inspiradores.jpg"),
    Community(2,"https://www.lasallebajio.edu.mx/comunidad/images/tile_boletin.jpg"),
    Community(3,"https://www.lasallebajio.edu.mx/comunidad/images/tile_cat_souv_22.jpg"),
    Community(4,"https://www.lasallebajio.edu.mx/comunidad/images/tile_tramites.jpg"),
    Community(5,"https://www.lasallebajio.edu.mx/comunidad/images/tile_blog.jpg")
)