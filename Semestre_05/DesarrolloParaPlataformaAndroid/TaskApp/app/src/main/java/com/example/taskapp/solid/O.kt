package com.example.taskapp.solid

// 2. O
// Principio de Abierto/Cerrado Open/Cloes

abstract class Calculadora{

}

open class CalculadoraOpen{
    fun sumar(a: Int, b: Int) : Int = a + b
    fun restar(a: Int, b: Int) : Int = a - b
}

class CalculadoraCientifica : CalculadoraOpen(){
    fun raizCuadrada(){

    }
}

fun main(){
    val cientifica = CalculadoraCientifica()
    cientifica.sumar(1, 2)
    cientifica.raizCuadrada()
}