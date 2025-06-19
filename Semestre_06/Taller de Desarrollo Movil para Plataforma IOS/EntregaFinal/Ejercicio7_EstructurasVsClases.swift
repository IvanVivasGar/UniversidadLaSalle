import Foundation

// EJERCICIO 7: Estructuras vs. Clases - Definición y Uso
// Objetivo: Entender las diferencias fundamentales entre estructuras y clases

print("=== EJERCICIO 7: Estructuras vs. Clases ===\n")

// PARTE 1: ESTRUCTURAS
print("🏗️ TRABAJANDO CON ESTRUCTURAS")
print("=" * 35)

// 1. Define una estructura llamada Punto
struct Punto {
    var x: Double
    var y: Double
    
    // 2. Añade un inicializador a la estructura Punto
    init(x: Double, y: Double) {
        self.x = x
        self.y = y
        print("   📍 Creando punto en (\(x), \(y))")
    }
    
    // 3. Añade un método para calcular distancia al origen
    func distanciaAlOrigen() -> Double {
        // Fórmula: √(x² + y²)
        let distancia = sqrt(pow(x, 2) + pow(y, 2))
        return distancia
    }
    
    // Método adicional para mostrar información
    func descripcion() -> String {
        return "Punto(\(x), \(y))"
    }
    
    // Método para calcular distancia a otro punto
    func distanciaA(_ otroPunto: Punto) -> Double {
        let deltaX = self.x - otroPunto.x
        let deltaY = self.y - otroPunto.y
        return sqrt(pow(deltaX, 2) + pow(deltaY, 2))
    }
}

// 4. Crea una instancia de Punto
print("\n1-4. Creando y usando instancia de Punto:")
let punto1 = Punto(x: 3.0, y: 4.0)
print("Punto creado: \(punto1.descripcion())")
print("Distancia al origen: \(punto1.distanciaAlOrigen())")

// Demostrando que las estructuras son tipos por valor
print("\n📋 Demostración: Estructuras son tipos por VALOR")
var puntoOriginal = Punto(x: 1.0, y: 1.0)
var puntoCopia = puntoOriginal  // Se crea una COPIA

print("Punto original: \(puntoOriginal.descripcion())")
print("Punto copia: \(puntoCopia.descripcion())")

// Modificamos la copia
puntoCopia.x = 10.0
puntoCopia.y = 10.0

print("Después de modificar la copia:")
print("Punto original: \(puntoOriginal.descripcion()) ← NO cambió")
print("Punto copia: \(puntoCopia.descripcion()) ← SÍ cambió")

// PARTE 2: CLASES
print("\n\n🏛️ TRABAJANDO CON CLASES")
print("=" * 30)

// 5. Define una clase llamada FiguraGeometrica
class FiguraGeometrica {
    var nombre: String
    
    // 6. Añade un inicializador a la clase FiguraGeometrica
    init(nombre: String) {
        self.nombre = nombre
        print("   🔷 Creando figura geométrica: \(nombre)")
    }
    
    // Método describir()
    func describir() {
        print("Soy una figura geométrica llamada \(nombre)")
    }
    
    // Métodos adicionales
    func cambiarNombre(a nuevoNombre: String) {
        let nombreAnterior = self.nombre
        self.nombre = nuevoNombre
        print("   🔄 Nombre cambiado de '\(nombreAnterior)' a '\(nuevoNombre)'")
    }
}

// 7. Crea una instancia de FiguraGeometrica
print("\n5-7. Creando y usando instancia de FiguraGeometrica:")
let figura1 = FiguraGeometrica(nombre: "Triángulo")
figura1.describir()

// Demostrando que las clases son tipos por referencia
print("\n📋 Demostración: Clases son tipos por REFERENCIA")
let figuraOriginal = FiguraGeometrica(nombre: "Círculo")
let figuraReferencia = figuraOriginal  // Se crea una REFERENCIA

print("Figura original: \(figuraOriginal.nombre)")
print("Figura referencia: \(figuraReferencia.nombre)")

// Modificamos a través de la referencia
figuraReferencia.cambiarNombre(a: "Cuadrado")

print("Después de modificar a través de la referencia:")
print("Figura original: \(figuraOriginal.nombre) ← SÍ cambió")
print("Figura referencia: \(figuraReferencia.nombre) ← SÍ cambió")
print("¡Ambas variables apuntan al MISMO objeto en memoria!")

// 8. Explicación de diferencias clave
print("\n\n📚 DIFERENCIAS CLAVE: VALOR vs. REFERENCIA")
print("=" * 50)

print("""
🏗️ ESTRUCTURAS (Tipos por VALOR):
   • Se crea una COPIA completa cada vez que se asigna
   • Modificar una copia NO afecta el original
   • Más eficientes para datos simples e inmutables
   • Se almacenan en el stack (más rápido)
   • Útiles para: coordenadas, fechas, configuraciones

🏛️ CLASES (Tipos por REFERENCIA):
   • Se comparte la misma instancia en memoria
   • Modificar una referencia afecta TODAS las referencias
   • Permiten herencia y polimorfismo
   • Se almacenan en el heap (gestión de memoria más compleja)
   • Útiles para: objetos complejos, entidades que cambian
""")

// EJEMPLOS PRÁCTICOS ADICIONALES
print("\n\n🚀 EJEMPLOS PRÁCTICOS ADICIONALES")
print("=" * 40)

// Ejemplo con múltiples puntos
print("\nTrabajando con múltiples puntos:")
let puntos = [
    Punto(x: 0, y: 0),
    Punto(x: 3, y: 4),
    Punto(x: -2, y: 6),
    Punto(x: 1, y: -1)
]

for (index, punto) in puntos.enumerated() {
    let distancia = punto.distanciaAlOrigen()
    print("Punto \(index + 1): \(punto.descripcion()) - Distancia al origen: \(String(format: "%.2f", distancia))")
}

// Ejemplo con múltiples figuras
print("\nTrabajando con múltiples figuras:")
let figuras = [
    FiguraGeometrica(nombre: "Pentágono"),
    FiguraGeometrica(nombre: "Hexágono"),
    FiguraGeometrica(nombre: "Octágono")
]

for figura in figuras {
    figura.describir()
}

// Comparación de rendimiento conceptual
print("\n⚡ Consideraciones de rendimiento:")
print("• Estructuras: Mejor para datos pequeños que no cambian frecuentemente")
print("• Clases: Mejor para objetos complejos que necesitan ser compartidos")

// Ejemplo de cuándo usar cada uno
print("\n🎯 Cuándo usar cada tipo:")
print("""
Usa ESTRUCTURAS para:
   • Coordenadas (Point, CGPoint)
   • Rangos (Range)
   • Configuraciones
   • Datos que se pasan por valor

Usa CLASES para:
   • Controladores de vista
   • Modelos de datos complejos
   • Managers y singletons
   • Objetos que necesitan herencia
""")

// Demostración final con identidad de objetos
print("\n🔍 Identidad de objetos (solo para clases):")
let figura2 = FiguraGeometrica(nombre: "Rombo")
let figura3 = FiguraGeometrica(nombre: "Rombo")
let figura4 = figura2

// Verificar si son el mismo objeto en memoria
print("figura2 y figura3 son el mismo objeto: \(figura2 === figura3)")  // false
print("figura2 y figura4 son el mismo objeto: \(figura2 === figura4)")  // true

print("\n¡Estructuras no tienen identidad de objeto porque son tipos por valor!")
