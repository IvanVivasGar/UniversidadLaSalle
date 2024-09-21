package com.example.kotlingames

import kotlin.random.Random

fun main(){
    val numeroAleatorio = Random.nextInt(0, 100)
    var juegoGanado = false
    var cantidadIntentos = 0

    println("-------------------------------------------")
    println("   BIENVENIDO AL JUEGO ADIVINA EL NUMERO   ")
    println("-------------------------------------------")

    println()

    println("Intrucciones: La computadora eligira un numero random del 0 al 100, usted debera ingresar un numero, en caso de que" +
            "su intento sea incorrecto, se le dira si el numero que ingreso es mayor o menor que el numero correcto. Comencemos.")

    do {
        cantidadIntentos++
        println("Ingresa un numero: ")
        var stringIntento = readln()
        var numeroIntento = stringIntento?.toIntOrNull()

        if (numeroIntento != null){
            if (numeroIntento == numeroAleatorio){
                println("Felicidades, adivinaste el numero. Esto te tomo " + cantidadIntentos + " intentos.")
                juegoGanado = true
            }else if (numeroIntento < numeroAleatorio){
                println("El numero que ingresaste es menor.")
            }else {
                println("El numero que ingresaste es mayor.")
            }
        }else{
            println("No ingreso un numero, por favor vuelva a ingresar un numero.")
        }
    }while(juegoGanado == false)
}