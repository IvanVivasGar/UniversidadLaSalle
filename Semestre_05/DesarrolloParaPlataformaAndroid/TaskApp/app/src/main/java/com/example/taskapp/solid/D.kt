package com.example.taskapp.solid

//  5. D
// Principio de Inversion de Dependencias
// Depender de abstracciones y no de construcciones

interface IStorage{
    fun leer()
    fun escribir()
}

class HDD : IStorage{
    override fun leer() {
        TODO("Not yet implemented")
    }

    override fun escribir() {
        TODO("Not yet implemented")
    }
}

class SSD : IStorage{
    override fun leer() {
        TODO("Not yet implemented")
    }

    override fun escribir() {
        TODO("Not yet implemented")
    }
}

class Computadora(val storage: IStorage){

}

interface IDB{
    fun getAll()
    fun create()
}

class ConexionDBLocal{
    fun getAll(){
        // Cosas
    }
}

class ConexionDBRemota : IDB{
    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun create() {
        TODO("Not yet implemented")
    }

}

fun main(){
    val compu = Computadora(SSD())
}