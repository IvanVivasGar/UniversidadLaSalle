package poo

class Person(val name:String, val age:Int){
    fun walk(){
        println("Caminando")
    }

    fun speak(){
        println("La persona que se llama $name esta hablando")
    }
}

abstract class Figura{
    abstract fun calcularArea() : Double
}

class Triangulo(val base: Double, val altura: Double) : Figura(){
    override fun calcularArea(): Double {
        return base * altura / 2
    }
}

class Circulo(val radio: Double) : Figura(){
    override fun calcularArea(): Double {
        return Math.PI * radio * radio
    }
}

// ENUM CLASS
enum class Direction {
    NORTE, SUR, ESTE, OESTE
}

//SEALED CLASS
sealed class ApiResult{
    class Ok(val message: String, val body: String) : ApiResult()
    class Error(val message: String) : ApiResult()
}

fun processResult(result : ApiResult){
    when(result){
        is ApiResult.Error -> println(result.message)
        is ApiResult.Ok -> println("${result.message} y el body es: ${result.body}")
    }
}

// OPEN CLASS
open class Animal{

}

class Dog: Animal(){

}

fun main(){
    val person = Person(name = "Ivan", age = 21)
    person.speak()
    val circulo = Circulo(radio = 3.0)
    val triangulo = Triangulo(base = 12.0, altura = 24.0)
    val areaCirculo = circulo.calcularArea()
    val areaTriangulo = triangulo.calcularArea()
    println(areaTriangulo)
    println(areaCirculo)

    println("Consultando la API ...")
    val result = ApiResult.Ok("Fue exitoso", "{name: Juan}" )
    println("Finalizo")
}