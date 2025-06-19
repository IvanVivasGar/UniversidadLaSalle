import Foundation

// EJERCICIO 10: Protocolos y Extensiones
// Objetivo: Definir y adoptar protocolos, y utilizar extensiones para añadir funcionalidad

print("=== EJERCICIO 10: Protocolos y Extensiones ===\n")

// 1. Define un protocolo llamado Identificable
protocol Identificable {
    var id: String { get } // Solo lectura
    func mostrarId()
}

// PARTE 1: ESTRUCTURA QUE ADOPTA EL PROTOCOLO
print("🏗️ ESTRUCTURA CON PROTOCOLO")
print("=" * 30)

// 2. Crea una estructura Usuario que adopte el protocolo Identificable
struct Usuario: Identificable {
    // Implementa la propiedad id
    let id: String
    
    // Añade una propiedad nombre
    var nombre: String
    
    // Añade un inicializador
    init(id: String, nombre: String) {
        self.id = id
        self.nombre = nombre
        print("👤 Usuario creado: \(nombre) (ID: \(id))")
    }
    
    // Implementa el método mostrarId()
    func mostrarId() {
        print("🆔 ID del usuario '\(nombre)': \(id)")
    }
    
    // Métodos adicionales específicos del usuario
    func saludar() {
        print("👋 Hola, soy \(nombre)")
    }
    
    func actualizarNombre(nuevoNombre: String) -> Usuario {
        print("✏️ Actualizando nombre de '\(nombre)' a '\(nuevoNombre)'")
        return Usuario(id: self.id, nombre: nuevoNombre)
    }
}

// PARTE 2: CLASE QUE ADOPTA EL PROTOCOLO
print("\n🏛️ CLASE CON PROTOCOLO")
print("=" * 25)

// 3. Crea una clase Producto que también adopte el protocolo Identificable
class Producto: Identificable {
    // Implementa la propiedad id
    let id: String
    
    // Añade propiedades nombreProducto y precio
    var nombreProducto: String
    var precio: Double
    
    // Añade un inicializador
    init(id: String, nombreProducto: String, precio: Double) {
        self.id = id
        self.nombreProducto = nombreProducto
        self.precio = precio
        print("🛍️ Producto creado: \(nombreProducto) (ID: \(id), Precio: $\(precio))")
    }
    
    // Implementa el método mostrarId()
    func mostrarId() {
        print("🏷️ ID del producto '\(nombreProducto)': \(id)")
    }
    
    // Métodos adicionales específicos del producto
    func aplicarDescuento(porcentaje: Double) {
        let descuento = precio * (porcentaje / 100)
        precio -= descuento
        print("💰 Descuento del \(porcentaje)% aplicado. Nuevo precio: $\(precio)")
    }
    
    func mostrarInformacion() {
        print("📦 Producto: \(nombreProducto)")
        print("   ID: \(id)")
        print("   Precio: $\(precio)")
    }
}

// 4. Crea una instancia de Usuario y una de Producto. Llama a mostrarId()
print("\n🎯 CREANDO INSTANCIAS Y PROBANDO PROTOCOLO")
print("=" * 45)

let usuario1 = Usuario(id: "USR001", nombre: "Iván Vivas")
let producto1 = Producto(id: "PRD001", nombreProducto: "iPhone 15", precio: 999.99)

print("\nLlamando a mostrarId() en ambas instancias:")
usuario1.mostrarId()
producto1.mostrarId()

// PARTE 3: EXTENSIONES
print("\n\n🔧 EXTENSIONES")
print("=" * 15)

// 5. Crea una extensión para el tipo Double que añada formatoMoneda()
extension Double {
    func formatoMoneda() -> String {
        return String(format: "$%.2f", self)
    }
    
    // Métodos adicionales útiles para Double
    func redondear(decimales: Int) -> Double {
        let multiplicador = pow(10.0, Double(decimales))
        return (self * multiplicador).rounded() / multiplicador
    }
    
    func porcentajeDe(_ total: Double) -> Double {
        return (self / total) * 100
    }
    
    func aplicarImpuesto(porcentaje: Double) -> Double {
        return self * (1 + porcentaje / 100)
    }
}

// 6. Prueba tu extensión con el precio del Producto
print("\n💰 PROBANDO EXTENSIÓN DE FORMATO DE MONEDA:")
print("Precio original: \(producto1.precio)")
print("Precio formateado: \(producto1.precio.formatoMoneda())")

// Probando otros métodos de la extensión
let precioConImpuesto = producto1.precio.aplicarImpuesto(porcentaje: 16)
print("Precio con IVA (16%): \(precioConImpuesto.formatoMoneda())")

// DEMOSTRACIONES ADICIONALES
print("\n\n🚀 DEMOSTRACIONES ADICIONALES")
print("=" * 40)

// Función que acepta cualquier objeto Identificable (polimorfismo con protocolos)
func procesarElementoIdentificable(_ elemento: Identificable) {
    print("🔍 Procesando elemento con ID: \(elemento.id)")
    elemento.mostrarId()
}

print("\n🔄 POLIMORFISMO CON PROTOCOLOS:")
let elementosIdentificables: [Identificable] = [usuario1, producto1]

for elemento in elementosIdentificables {
    procesarElementoIdentificable(elemento)
}

// Más ejemplos de extensiones
print("\n\n📚 MÁS EJEMPLOS DE EXTENSIONES")
print("=" * 35)

// Extensión para String
extension String {
    func capitalizarPalabras() -> String {
        return self.split(separator: " ")
            .map { $0.capitalized }
            .joined(separator: " ")
    }
    
    func contarVocales() -> Int {
        let vocales = "aeiouAEIOU"
        return self.filter { vocales.contains($0) }.count
    }
    
    func invertir() -> String {
        return String(self.reversed())
    }
    
    var esPalindromo: Bool {
        let textoLimpio = self.lowercased().filter { $0.isLetter }
        return textoLimpio == String(textoLimpio.reversed())
    }
}

// Probando extensiones de String
let texto = "hola mundo swift"
print("Texto original: '\(texto)'")
print("Capitalizado: '\(texto.capitalizarPalabras())'")
print("Vocales: \(texto.contarVocales())")
print("Invertido: '\(texto.invertir())'")

let palindromo = "anilina"
print("'\(palindromo)' es palíndromo: \(palindromo.esPalindromo)")

// Extensión para Array
extension Array where Element: Identificable {
    func buscarPorId(_ id: String) -> Element? {
        return self.first { $0.id == id }
    }
    
    func mostrarTodosLosIds() {
        print("📋 IDs en el array:")
        for elemento in self {
            print("   - \(elemento.id)")
        }
    }
}

// Probando extensión de Array
print("\n🗂️ EXTENSIÓN PARA ARRAY DE IDENTIFICABLES:")
elementosIdentificables.mostrarTodosLosIds()

if let encontrado = elementosIdentificables.buscarPorId("USR001") {
    print("✅ Elemento encontrado con ID 'USR001'")
    encontrado.mostrarId()
}

// Protocolo adicional con requisitos más complejos
print("\n\n📋 PROTOCOLO AVANZADO")
print("=" * 25)

protocol Vendible {
    var precio: Double { get set }
    var disponible: Bool { get }
    
    func calcularPrecioConImpuesto(impuesto: Double) -> Double
    mutating func aplicarOferta(descuento: Double)
}

// Extensión de protocolo (proporciona implementación por defecto)
extension Vendible {
    func calcularPrecioConImpuesto(impuesto: Double) -> Double {
        return precio * (1 + impuesto / 100)
    }
    
    var descripcionPrecio: String {
        return "Precio: \(precio.formatoMoneda())"
    }
}

// Hacer que Producto adopte también Vendible
extension Producto: Vendible {
    var disponible: Bool {
        return precio > 0
    }
    
    func aplicarOferta(descuento: Double) {
        let descuentoAplicado = precio * (descuento / 100)
        precio -= descuentoAplicado
        print("🎉 Oferta aplicada: \(descuento)% de descuento (-\(descuentoAplicado.formatoMoneda()))")
    }
}

// Probando el protocolo Vendible
print("\n💼 PROBANDO PROTOCOLO VENDIBLE:")
producto1.mostrarInformacion()
print("Disponible: \(producto1.disponible)")
print("Precio con IVA: \(producto1.calcularPrecioConImpuesto(impuesto: 16).formatoMoneda())")

producto1.aplicarOferta(descuento: 10)
print("Precio después de la oferta: \(producto1.precio.formatoMoneda())")

// Crear más productos para demostrar
let productos = [
    Producto(id: "PRD002", nombreProducto: "MacBook Pro", precio: 2499.99),
    Producto(id: "PRD003", nombreProducto: "AirPods Pro", precio: 249.99),
    Producto(id: "PRD004", nombreProducto: "Apple Watch", precio: 399.99)
]

print("\n🛍️ CATÁLOGO DE PRODUCTOS:")
for producto in productos {
    print("• \(producto.nombreProducto): \(producto.precio.formatoMoneda())")
}

// Estadísticas finales
print("\n\n📊 ESTADÍSTICAS DE LA DEMOSTRACIÓN")
print("=" * 40)

let todosLosProductos = [producto1] + productos
let precioTotal = todosLosProductos.reduce(0) { $0 + $1.precio }
let precioPromedio = precioTotal / Double(todosLosProductos.count)

print("📈 Resumen de protocolos y extensiones:")
print("• Protocolos definidos: Identificable, Vendible")
print("• Extensiones creadas: Double, String, Array")
print("• Total de productos: \(todosLosProductos.count)")
print("• Precio total del catálogo: \(precioTotal.formatoMoneda())")
print("• Precio promedio: \(precioPromedio.formatoMoneda())")
print("• Polimorfismo con protocolos: ✅")
print("• Extensiones funcionales: ✅")
print("• Implementaciones por defecto: ✅")

print("\n✅ Demostración de protocolos y extensiones completada!")
