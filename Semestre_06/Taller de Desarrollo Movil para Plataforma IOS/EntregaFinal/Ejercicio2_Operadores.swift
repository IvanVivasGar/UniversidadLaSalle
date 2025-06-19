import Foundation

// EJERCICIO 2: Operadores y Expresiones
// Objetivo: Aplicar correctamente operadores aritméticos, de comparación y lógicos

print("=== EJERCICIO 2: Operadores y Expresiones ===\n")

// 1. Declara dos variables numéricas
let numeroA = 15
let numeroB = 7

// 2. Calcula e imprime operaciones aritméticas
print("Operaciones aritméticas:")
print("numeroA = \(numeroA), numeroB = \(numeroB)")

let suma = numeroA + numeroB
let resta = numeroA - numeroB
let multiplicacion = numeroA * numeroB
// Para la división, convertimos a Double para obtener resultado decimal
let division = Double(numeroA) / Double(numeroB)

print("Suma: \(numeroA) + \(numeroB) = \(suma)")
print("Resta: \(numeroA) - \(numeroB) = \(resta)")
print("Multiplicación: \(numeroA) * \(numeroB) = \(multiplicacion)")
print("División: \(numeroA) / \(numeroB) = \(division)")

// 3. Declara variables booleanas
let edad = 22 // Usando la edad del ejercicio anterior
let esMayorDeEdad = edad >= 18
let tieneLicencia = true // Asumiendo que tiene licencia

print("\nEvaluación de condiciones:")
print("Edad: \(edad)")
print("Es mayor de edad: \(esMayorDeEdad)")
print("Tiene licencia: \(tieneLicencia)")

// 4. Evalúa si puede conducir legalmente usando operadores lógicos
let puedeConducir = esMayorDeEdad && tieneLicencia

print("\n¿Puede conducir legalmente?")
print("Condición: (es mayor de edad) AND (tiene licencia)")
print("Resultado: \(esMayorDeEdad) && \(tieneLicencia) = \(puedeConducir)")

if puedeConducir {
    print("✅ Puede conducir legalmente")
} else {
    print("❌ No puede conducir legalmente")
}

// Ejemplos adicionales de operadores de comparación
print("\nOperadores de comparación:")
print("\(numeroA) > \(numeroB) = \(numeroA > numeroB)")
print("\(numeroA) < \(numeroB) = \(numeroA < numeroB)")
print("\(numeroA) == \(numeroB) = \(numeroA == numeroB)")
print("\(numeroA) != \(numeroB) = \(numeroA != numeroB)")
print("\(numeroA) >= \(numeroB) = \(numeroA >= numeroB)")
print("\(numeroA) <= \(numeroB) = \(numeroA <= numeroB)")

// Ejemplos adicionales de operadores lógicos
print("\nOperadores lógicos:")
let condicion1 = true
let condicion2 = false
print("true && false = \(condicion1 && condicion2)")
print("true || false = \(condicion1 || condicion2)")
print("!true = \(!condicion1)")
print("!false = \(!condicion2)")
