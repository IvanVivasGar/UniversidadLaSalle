import Foundation

// EJERCICIO 4: Control de Flujo - Bucles
// Objetivo: Utilizar bucles for-in y while para ejecutar código repetidamente

print("=== EJERCICIO 4: Control de Flujo - Bucles ===\n")

// 1. Utiliza un bucle for-in para imprimir números del 1 al 10
print("1. Números del 1 al 10:")
for numero in 1...10 {
    print("Número: \(numero)")
}

// Versión más visual
print("\nNúmeros del 1 al 10 (en una línea):")
var linea = ""
for numero in 1...10 {
    linea += "\(numero) "
}
print(linea)

// 2. Array de películas favoritas y bucle for-in
print("\n2. Mis películas favoritas:")
let peliculasFavoritas = ["Inception", "The Matrix", "Interstellar"]

for pelicula in peliculasFavoritas {
    print("Me gusta la película: \(pelicula)")
}

// Versión con índices
print("\nPelículas con ranking:")
for (indice, pelicula) in peliculasFavoritas.enumerated() {
    print("\(indice + 1). Me gusta la película: \(pelicula)")
}

// 3. Cuenta regresiva con bucle while
print("\n3. Cuenta regresiva para despegue:")
var contador = 5

while contador >= 1 {
    print("⏰ \(contador)")
    contador -= 1
    // Pequeña pausa para efecto dramático (comentado para no bloquear en consola)
    // Thread.sleep(forTimeInterval: 1)
}
print("🚀 ¡Despegue!")

// Ejemplos adicionales de bucles
print("\n=== EJEMPLOS ADICIONALES DE BUCLES ===\n")

// Bucle for-in con rangos cerrados
print("Bucle con rango cerrado (1...5):")
for i in 1...5 {
    print("🔢 \(i)")
}

// Bucle for-in con rangos semi-abiertos
print("\nBucle con rango semi-abierto (1..<5):")
for i in 1..<5 {
    print("📊 \(i)")
}

// Bucle for-in con stride (pasos)
print("\nNúmeros pares del 2 al 10:")
for numero in stride(from: 2, through: 10, by: 2) {
    print("Par: \(numero)")
}

// Bucle for-in descendente
print("\nCuenta regresiva del 10 al 1:")
for numero in stride(from: 10, through: 1, by: -1) {
    print("⬇️ \(numero)")
}

// Bucle while con condición más compleja
print("\nSimulación de lanzamiento de dado hasta obtener 6:")
var lanzamiento = 0
var intentos = 0
var maxIntentos = 10 // Límite para evitar bucle infinito en demostración

while lanzamiento != 6 && intentos < maxIntentos {
    lanzamiento = Int.random(in: 1...6)
    intentos += 1
    print("🎲 Intento \(intentos): Salió \(lanzamiento)")
}

if lanzamiento == 6 {
    print("🎉 ¡Conseguiste un 6 en \(intentos) intentos!")
} else {
    print("⏱️ Se alcanzó el límite de intentos")
}

// Bucle repeat-while (se ejecuta al menos una vez)
print("\nEjemplo de repeat-while:")
var numero = 0
repeat {
    print("🔄 Número: \(numero)")
    numero += 1
} while numero < 3

// Uso de break y continue
print("\nEjemplo con break y continue:")
for i in 1...10 {
    if i % 2 == 0 {
        continue // Salta los números pares
    }
    if i > 7 {
        break // Sale del bucle cuando i es mayor que 7
    }
    print("🔢 Número impar: \(i)")
}

// Bucles anidados
print("\nTabla de multiplicar (3x3):")
for fila in 1...3 {
    var lineaTabla = ""
    for columna in 1...3 {
        let producto = fila * columna
        lineaTabla += "\(fila)x\(columna)=\(producto) "
    }
    print(lineaTabla)
}
