import Foundation

// EJERCICIO 5: Colecciones - Arrays y Diccionarios
// Objetivo: Demostrar el uso de arrays y diccionarios para gestionar colecciones de datos

print("=== EJERCICIO 5: Colecciones - Arrays y Diccionarios ===\n")

// PARTE 1: ARRAYS
print("📋 TRABAJANDO CON ARRAYS")
print("=" * 30)

// 1. Crea un array mutable llamado frutas
var frutas = ["Manzana", "Plátano", "Naranja", "Uva", "Fresa"]
print("1. Array inicial de frutas:")
print("Frutas: \(frutas)")
print("Cantidad de frutas: \(frutas.count)")

// 2. Agrega una nueva fruta al final del array
frutas.append("Mango")
print("\n2. Después de agregar 'Mango':")
print("Frutas: \(frutas)")
print("Nueva cantidad: \(frutas.count)")

// 3. Elimina la segunda fruta del array (índice 1)
print("\n3. Eliminando la segunda fruta ('\(frutas[1])'):")
let frutaEliminada = frutas.remove(at: 1)
print("Fruta eliminada: \(frutaEliminada)")
print("Frutas restantes: \(frutas)")

// 4. Itera sobre el array e imprime cada fruta
print("\n4. Iterando sobre el array:")
for (indice, fruta) in frutas.enumerated() {
    print("  \(indice + 1). \(fruta)")
}

// Operaciones adicionales con arrays
print("\n📊 Operaciones adicionales con arrays:")
print("Primera fruta: \(frutas.first ?? "No hay frutas")")
print("Última fruta: \(frutas.last ?? "No hay frutas")")
print("¿El array contiene 'Manzana'? \(frutas.contains("Manzana"))")
print("Índice de 'Naranja': \(frutas.firstIndex(of: "Naranja") ?? -1)")

// PARTE 2: DICCIONARIOS
print("\n\n🗺️ TRABAJANDO CON DICCIONARIOS")
print("=" * 35)

// 5. Crea un diccionario mutable llamado capitales
var capitales = [
    "México": "Ciudad de México",
    "España": "Madrid",
    "Francia": "París"
]

print("5. Diccionario inicial de capitales:")
for (pais, capital) in capitales {
    print("  \(pais): \(capital)")
}
print("Cantidad de países: \(capitales.count)")

// 6. Agrega un nuevo país y su capital
capitales["Italia"] = "Roma"
print("\n6. Después de agregar Italia:")
print("Nueva cantidad de países: \(capitales.count)")

// 7. Accede e imprime la capital de uno de los países
let paisBuscado = "España"
if let capitalEncontrada = capitales[paisBuscado] {
    print("\n7. La capital de \(paisBuscado) es: \(capitalEncontrada)")
} else {
    print("\n7. No se encontró información para \(paisBuscado)")
}

// 8. Itera sobre el diccionario e imprime cada país con su capital
print("\n8. Iterando sobre todo el diccionario:")
for (pais, capital) in capitales {
    print("🏛️ La capital de \(pais) es \(capital)")
}

// Operaciones adicionales con diccionarios
print("\n📈 Operaciones adicionales con diccionarios:")

// Obtener todas las llaves
let paises = Array(capitales.keys).sorted()
print("Países en el diccionario: \(paises)")

// Obtener todos los valores
let todasLasCapitales = Array(capitales.values).sorted()
print("Todas las capitales: \(todasLasCapitales)")

// Actualizar un valor
capitales["México"] = "CDMX"
print("Después de actualizar México: \(capitales["México"] ?? "No encontrado")")

// Verificar si existe una llave
let paisVerificar = "Brasil"
if capitales[paisVerificar] != nil {
    print("\(paisVerificar) está en el diccionario")
} else {
    print("\(paisVerificar) NO está en el diccionario")
}

// Eliminar un elemento
let paisEliminado = capitales.removeValue(forKey: "Francia")
print("País eliminado: Francia (capital era: \(paisEliminado ?? "desconocida"))")
print("Diccionario después de eliminar Francia:")
for (pais, capital) in capitales.sorted(by: { $0.key < $1.key }) {
    print("  \(pais): \(capital)")
}

// EJEMPLOS AVANZADOS
print("\n\n🚀 EJEMPLOS AVANZADOS")
print("=" * 25)

// Array de diccionarios
let estudiantes = [
    ["nombre": "Ana", "edad": "20", "carrera": "Ingeniería"],
    ["nombre": "Carlos", "edad": "22", "carrera": "Medicina"],
    ["nombre": "María", "edad": "19", "carrera": "Derecho"]
]

print("Lista de estudiantes:")
for (indice, estudiante) in estudiantes.enumerated() {
    let nombre = estudiante["nombre"] ?? "Desconocido"
    let edad = estudiante["edad"] ?? "Desconocida"
    let carrera = estudiante["carrera"] ?? "Desconocida"
    print("  \(indice + 1). \(nombre), \(edad) años, estudia \(carrera)")
}

// Diccionario con arrays como valores
let materiasPorCarrera: [String: [String]] = [
    "Ingeniería": ["Matemáticas", "Física", "Programación"],
    "Medicina": ["Anatomía", "Biología", "Química"],
    "Derecho": ["Constitucional", "Civil", "Penal"]
]

print("\nMaterias por carrera:")
for (carrera, materias) in materiasPorCarrera {
    print("  \(carrera):")
    for materia in materias {
        print("    - \(materia)")
    }
}

// Operaciones de filtrado y mapeo
print("\nFrutas que empiezan con 'M':")
let frutasConM = frutas.filter { $0.hasPrefix("M") }
print(frutasConM)

print("\nFrutas en mayúsculas:")
let frutasMayusculas = frutas.map { $0.uppercased() }
print(frutasMayusculas)
