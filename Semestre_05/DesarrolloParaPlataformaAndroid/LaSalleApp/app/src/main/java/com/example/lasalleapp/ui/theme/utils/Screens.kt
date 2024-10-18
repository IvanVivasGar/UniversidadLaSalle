package com.example.lasalleapp.ui.theme.utils

sealed class Screens (val route: String){
    data object Home: Screens("home")
    data object Grades: Screens("grades")
    data object Calendar: Screens("calendar")
    data object Settings: Screens("settings")
    data object NewsDetail: Screens("news-detail")
    data object Payments: Screens("payments")
    data object Provisional: Screens("provisional")
    data object SubjectDetail: Screens("subject-detail")
}