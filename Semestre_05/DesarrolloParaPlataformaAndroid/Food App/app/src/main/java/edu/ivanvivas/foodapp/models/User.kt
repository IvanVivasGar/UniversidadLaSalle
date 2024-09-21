package edu.ivanvivas.foodapp.models

class User(val name:String, val email:String, val password:String) {
    val computedName: String get() = "Hola, $name"
    companion object{
        val users = listOf(
            User("Ivan","ivanvivasgar@gmail.com", "Qwerty123"),
            User("Jared", "ivanvivas@gmail.com", "Qwerty123"),
            User("Diego","ivg@gmail.com", "Qwerty123")
        )
    }
}