package com.example.fakestoreapp.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
//    GlobalScope.launch {
//        println("Hola desde launch")
//        delay(2000)
//        println("Termino de traerse los datos")
//    }
//    cLaunch()
    cAsync()
}

fun cLaunch(){
    runBlocking {
        launch {
//            println("Trayendo informacion desde una API")
//            delay(2000)
//            println("Finalizar la consulta de la API")

            println("Mi super aplicacion")
            val data = consultaBaseDeDatos()
            println(data)
        }
    }
}

fun cAsync(){
    runBlocking {
        val result =async {
            20
        }
        println(result.await())
    }
}

suspend fun consultaBaseDeDatos() : String{
    println("Consultando base de datos")
    delay(2000)
    return "Datos traidos"
}