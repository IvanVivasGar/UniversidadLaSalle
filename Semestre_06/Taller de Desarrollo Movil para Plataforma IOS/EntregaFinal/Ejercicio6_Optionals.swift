import Foundation

// EJERCICIO 6: Optionals
// Objetivo: Comprender y manejar de forma segura los valores opcionales en Swift

print("=== EJERCICIO 6: Optionals ===\n")

// 1. Declara una variable opcional posibleNumero de tipo String
var posibleNumero: String? = "123"
print("1. Variable opcional posibleNumero: \(posibleNumero ?? "nil")")

// 2. Utiliza if let para desempaquetar de forma segura posibleNumero
print("\n2. Desempaquetado seguro con if let:")
if let numeroString = posibleNumero {
    print("   El valor no es nil: '\(numeroString)'")
    
    // Intenta convertir a Int
    if let numeroEntero = Int(numeroString) {
        print("   ✅ Conversión exitosa: \(numeroEntero)")
        print("   El número convertido es: \(numeroEntero)")
    } else {
        print("   ❌ No se pudo convertir '\(numeroString)' a Int")
    }
} else {
    print("   ⚠️ El valor es nil o no es un número")
}

// Ejemplo con un valor que no se puede convertir
print("\n   Ejemplo con valor no convertible:")
posibleNumero = "abc"
if let numeroString = posibleNumero {
    if let numeroEntero = Int(numeroString) {
        print("   ✅ Conversión exitosa: \(numeroEntero)")
    } else {
        print("   ❌ No se pudo convertir '\(numeroString)' a Int")
    }
} else {
    print("   ⚠️ El valor es nil")
}

// 3. Declara otra variable opcional nombreOpcional sin valor inicial
var nombreOpcional: String?
print("\n3. Variable opcional sin valor inicial:")
print("   nombreOpcional = \(nombreOpcional?.description ?? "nil")")

// 4. Utiliza el operador de coalescencia nula (??)
print("\n4. Operador de coalescencia nula (??):")
let nombreMostrar = nombreOpcional ?? "Usuario Anónimo"
print("   Nombre a mostrar: \(nombreMostrar)")

// Ejemplo asignando un valor
nombreOpcional = "Iván"
let nombreMostrar2 = nombreOpcional ?? "Usuario Anónimo"
print("   Después de asignar valor: \(nombreMostrar2)")

// 5. Función que recibe String? y devuelve cantidad de caracteres usando guard let
func contarCaracteres(texto: String?) -> Int {
    // Usando guard let para manejo de optionals
    guard let textoSeguro = texto else {
        print("   🔍 guard let: El texto es nil, devolviendo 0")
        return 0
    }
    
    print("   🔍 guard let: Texto válido recibido: '\(textoSeguro)'")
    return textoSeguro.count
}

print("\n5. Función con guard let:")
let resultado1 = contarCaracteres(texto: "Hola mundo")
print("   Caracteres en 'Hola mundo': \(resultado1)")

let resultado2 = contarCaracteres(texto: nil)
print("   Caracteres en nil: \(resultado2)")

let resultado3 = contarCaracteres(texto: "Swift")
print("   Caracteres en 'Swift': \(resultado3)")

// EJEMPLOS ADICIONALES DE OPTIONALS
print("\n\n🚀 EJEMPLOS ADICIONALES DE OPTIONALS")
print("=" * 40)

// Optional binding múltiple
print("\nOptional binding múltiple:")
let nombre: String? = "Ana"
let edad: String? = "25"

if let nombreSeguro = nombre, let edadString = edad, let edadInt = Int(edadString) {
    print("   ✅ Datos válidos: \(nombreSeguro), \(edadInt) años")
} else {
    print("   ❌ Algunos datos son inválidos")
}

// Encadenamiento de optionals (optional chaining)
print("\nEncadenamiento de optionals:")
struct Persona {
    let nombre: String
    let direccion: Direccion?
}

struct Direccion {
    let calle: String
    let ciudad: String
}

let direccionEjemplo = Direccion(calle: "Av. Principal 123", ciudad: "Ciudad de México")
let personaConDireccion = Persona(nombre: "Carlos", direccion: direccionEjemplo)
let personaSinDireccion = Persona(nombre: "María", direccion: nil)

print("   Ciudad de Carlos: \(personaConDireccion.direccion?.ciudad ?? "No especificada")")
print("   Ciudad de María: \(personaSinDireccion.direccion?.ciudad ?? "No especificada")")

// Operador de fuerza de desempaquetado (usar con cuidado)
print("\nOperador de fuerza de desempaquetado (!):")
let numeroSeguro: String? = "42"
if numeroSeguro != nil {
    let valor = Int(numeroSeguro!)! // Solo usar cuando estés 100% seguro
    print("   Valor forzado: \(valor)")
    print("   ⚠️ CUIDADO: El operador ! puede causar crashes si el valor es nil")
}

// Nil coalescing con valores por defecto más complejos
print("\nNil coalescing con expresiones:")
func obtenerNombrePorDefecto() -> String {
    print("   🔄 Generando nombre por defecto...")
    return "Usuario_\(Int.random(in: 1000...9999))"
}

let usuario1: String? = nil
let usuario2: String? = "Pedro"

let nombreFinal1 = usuario1 ?? obtenerNombrePorDefecto()
print("   Usuario 1: \(nombreFinal1)")

let nombreFinal2 = usuario2 ?? obtenerNombrePorDefecto()
print("   Usuario 2: \(nombreFinal2)")

// Optional con arrays y diccionarios
print("\nOptionals con colecciones:")
var diccionarioOptional: [String: String]? = ["clave": "valor"]
let valor = diccionarioOptional?["clave"]
print("   Valor del diccionario opcional: \(valor ?? "No encontrado")")

diccionarioOptional = nil
let valorNil = diccionarioOptional?["clave"]
print("   Valor cuando diccionario es nil: \(valorNil ?? "No encontrado")")

// Función que demuestra diferentes formas de manejar optionals
func procesarTexto(_ texto: String?) {
    print("\n   Procesando texto: \(texto?.description ?? "nil")")
    
    // Método 1: if let
    if let textoSeguro = texto {
        print("   Método 1 (if let): Longitud = \(textoSeguro.count)")
    }
    
    // Método 2: guard let
    guard let textoValidado = texto else {
        print("   Método 2 (guard let): Texto es nil, terminando función")
        return
    }
    print("   Método 2 (guard let): Texto en mayúsculas = \(textoValidado.uppercased())")
    
    // Método 3: nil coalescing
    let textoConDefecto = texto ?? "texto por defecto"
    print("   Método 3 (nil coalescing): \(textoConDefecto)")
}

print("\nEjemplos de procesamiento:")
procesarTexto("Hola Swift")
procesarTexto(nil)
