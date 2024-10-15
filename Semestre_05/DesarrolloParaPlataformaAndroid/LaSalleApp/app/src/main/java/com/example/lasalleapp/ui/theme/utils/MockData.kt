package com.example.lasalleapp.ui.theme.utils
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import com.example.lasalleapp.models.Student
import com.example.lasalleapp.models.BottomNavigationItem
import com.example.lasalleapp.models.Career
import com.example.lasalleapp.models.Community
import com.example.lasalleapp.models.News
import com.example.lasalleapp.models.Payment
import com.example.lasalleapp.models.Subject

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

val subjectsList = listOf(
    Subject(
        id = 1,
        name = "Administracion de Bases de Datos",
        coursed = true,
        firstCut = 9.5,
        secondCut = 9.0,
        thirdCut = 9.0
    ),
    Subject(
        id = 2,
        name = "Programacion Web",
        coursed = true,
        firstCut = 9.0,
        secondCut = 8.0,
        thirdCut = 8.2
    ),
    Subject(
        id = 3,
        name = "Programacion Movil",
        coursed = true,
        firstCut = 8.1,
        secondCut = 8.6,
        thirdCut = 8.5
    ),
    Subject(
        id = 4,
        name = "Inteligencia Artificial",
        coursed = true,
        firstCut = 8.5,
        secondCut = 7.9,
        thirdCut = 9.1
    ),
    Subject(
        id = 5,
        name = "Diseño de Sistemas",
        coursed = false,
        firstCut = 10.0,
        secondCut = 9.0,
        thirdCut = 9.1
    ),
    Subject(
        id = 6,
        name = "Sistemas Operativos",
        coursed = false,
        firstCut = 6.3,
        secondCut = 6.1,
        thirdCut = 6.7
    )
)

val careerList = listOf(
    Career(
        id = 1,
        name = "Ingenieria en Software y Sistemas Computacionales",
        subjects = subjectsList
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

val payments = listOf(
    Payment(
        1,
        "157 - AGO-DIC 2024",
        "agosto 10 de 2024",
        true
    ),
    Payment(
        2,
        "158 - NOV-DIC 2024",
        "septiembre 10 de 2024",
        true
    ),
    Payment(
        3,
        "159 - AGO-DIC 2024",
        "octubre 10 de 2024",
        true
    ),
    Payment(
        4,
        "160 - AGO-DIC 2024",
        "noviembre 10 de 2024",
        false
    ),
    Payment(
        5,
        "161 - AGO-DIC 2024",
        "diciembre 10 de 2024",
        false
    )
)

val studentsList = listOf(
    Student(
        name = "Caitlin Clark",
        birthdate = "22/01/2002",
        email = "cec77850@lasallebajio.edu.mx",
        photo = "https://a.espncdn.com/combiner/i?img=/i/headshots/wnba/players/full/4433403.png",
        career = careerList[0],
        currentSemester = 6,
        payments = payments
    ),
    Student(
        name = "Ivan Vivas",
        birthdate = "16/07/2003",
        email = "ivg77850@lasallebajio.edu.mx",
        photo = "https://a.espncdn.com/combiner/i?img=/i/headshots/wnba/players/full/4433403.png",
        career = careerList[0],
        currentSemester = 6,
        payments = payments
    ),
    Student(
        name = "Lamine Yamal",
        birthdate = "13/07/2003",
        email = "ly77850@lasallebajio.edu.mx",
        photo = "https://fcb-abj-pre.s3.amazonaws.com/img/jugadors/LAMINE%20YAMAL.png",
        career = careerList[0],
        currentSemester = 6,
        payments = payments
    ),
    Student(
        name = "Xavi Simmons",
        birthdate = "16/07/2003",
        email = "ivg77850@lasallebajio.edu.mx",
        photo = "https://a.espncdn.com/combiner/i?img=/i/headshots/wnba/players/full/4433403.png",
        career = careerList[0],
        currentSemester = 6,
        payments = payments
    ),
)