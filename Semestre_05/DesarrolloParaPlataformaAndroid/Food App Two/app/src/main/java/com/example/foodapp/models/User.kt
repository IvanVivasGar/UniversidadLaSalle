package com.example.foodapp.models

data class User(val name:String, val email:String,val password: String){
    val computerName : String get() = "Hola, $name"
    companion object{
        val users = listOf(
            User("Yahir", "yahir16@gmail.com", "12345"),
            User("Yered","yered17@gmail.com", "12345"),
            User("Yir","yir18@gmail.com", "12345")
        )
    }
}
