package com.ivanvivas.heroesapp.models

data class User(val email:String,val password: String){
    companion object{
        val users = listOf(
            User("ivanvivasgar@gmail.com", "Qwerty123"),
            User("ivg77850@lasallebajio.edu.mx", "Qwerty123"),
            User("ivg77850@udelasalle.edu.mx", "Qwerty123")
        )
    }
}