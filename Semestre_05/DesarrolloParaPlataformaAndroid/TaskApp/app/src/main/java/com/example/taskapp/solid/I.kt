package com.example.taskapp.solid

// 4. L
// Principio de Segregacion de Interfaz

interface IAve{
    fun comer()
    fun duermen()
}

interface IAveVoladora{
    fun vuelan()
}

class Aguila : IAve, IAveVoladora{
    override fun comer() {
        println("Comiendo")
    }

    override fun duermen() {
        println("Durmiendo")
    }

    override fun vuelan() {
        println("Volando")
    }
}

class Pinguino : IAve{
    override fun comer() {
        println("Comiendo")
    }
    override fun duermen() {
        println("Durmiendo")
    }
}