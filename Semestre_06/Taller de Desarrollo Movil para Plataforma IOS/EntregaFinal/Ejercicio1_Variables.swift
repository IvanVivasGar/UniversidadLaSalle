import Foundation

// EJERCICIO 1: Variables, Constantes y Tipos de Datos
// Objetivo: Comprender la declaración y uso de variables y constantes

print("=== EJERCICIO 1: Variables, Constantes y Tipos de Datos ===\n")

// 1. Declara una constante llamada nombreCompleto de tipo String
let nombreCompleto: String = "Iván Vivas"

// 2. Declara una variable llamada edad de tipo Int
var edad: Int = 22

// 3. Declara una variable promedioGeneral e inicialízala con un valor decimal
// Permite que Swift infiera el tipo (será Double)
var promedioGeneral = 8.5

// 4. Intenta reasignar un nuevo valor a la constante nombreCompleto
// nombreCompleto = "Otro Nombre" 
/* 
ERROR: El compilador genera el siguiente error:
"Cannot assign to value: 'nombreCompleto' is a 'let' constant"
Esto ocurre porque las constantes (let) no pueden ser modificadas una vez asignadas.
Las constantes proporcionan inmutabilidad y seguridad en el código.
*/

// 5. Imprime en consola los valores utilizando interpolación de cadenas
print("Información del estudiante:")
print("Nombre completo: \(nombreCompleto)")
print("Edad: \(edad) años")
print("Promedio general: \(promedioGeneral)")

// Información adicional sobre los tipos
print("\nInformación de tipos:")
print("Tipo de nombreCompleto: \(type(of: nombreCompleto))")
print("Tipo de edad: \(type(of: edad))")
print("Tipo de promedioGeneral: \(type(of: promedioGeneral))")
