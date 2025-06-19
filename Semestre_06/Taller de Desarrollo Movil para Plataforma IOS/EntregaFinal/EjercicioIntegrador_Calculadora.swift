import Foundation

// EJERCICIO INTEGRADOR: Calculadora Básica
// Objetivo: Integrar conocimientos de Swift y POO para desarrollar una calculadora

print("=== EJERCICIO INTEGRADOR: Calculadora Básica ===\n")

// MARK: - Enumeraciones para manejo de errores
enum OperacionCalculadora: String, CaseIterable {
    case suma = "+"
    case resta = "-"
    case multiplicacion = "*"
    case division = "/"
    
    var descripcion: String {
        switch self {
        case .suma: return "Suma"
        case .resta: return "Resta"
        case .multiplicacion: return "Multiplicación"
        case .division: return "División"
        }
    }
}

enum ErrorCalculadora: Error {
    case divisionPorCero
    case operacionInvalida
    case numeroInvalido
    
    var descripcion: String {
        switch self {
        case .divisionPorCero:
            return "❌ Error: No se puede dividir entre cero"
        case .operacionInvalida:
            return "❌ Error: Operación no válida. Use +, -, * o /"
        case .numeroInvalido:
            return "❌ Error: Número no válido"
        }
    }
}

// MARK: - Protocolo para operaciones matemáticas
protocol OperacionMatematica {
    func ejecutar(a: Double, b: Double) throws -> Double
}

// MARK: - Implementaciones de operaciones específicas
struct Suma: OperacionMatematica {
    func ejecutar(a: Double, b: Double) throws -> Double {
        return a + b
    }
}

struct Resta: OperacionMatematica {
    func ejecutar(a: Double, b: Double) throws -> Double {
        return a - b
    }
}

struct Multiplicacion: OperacionMatematica {
    func ejecutar(a: Double, b: Double) throws -> Double {
        return a * b
    }
}

struct Division: OperacionMatematica {
    func ejecutar(a: Double, b: Double) throws -> Double {
        guard b != 0 else {
            throw ErrorCalculadora.divisionPorCero
        }
        return a / b
    }
}

// MARK: - Clase principal Calculadora
class Calculadora {
    
    // Propiedades
    private var historial: [(operacion: String, resultado: Double)] = []
    private let operaciones: [OperacionCalculadora: OperacionMatematica] = [
        .suma: Suma(),
        .resta: Resta(),
        .multiplicacion: Multiplicacion(),
        .division: Division()
    ]
    
    // Inicializador
    init() {
        print("🧮 Calculadora inicializada")
    }
    
    // MARK: - Métodos individuales para cada operación
    func sumar(a: Double, b: Double) -> Double {
        let resultado = a + b
        guardarEnHistorial(operacion: "\(a) + \(b) = \(resultado)", resultado: resultado)
        return resultado
    }
    
    func restar(a: Double, b: Double) -> Double {
        let resultado = a - b
        guardarEnHistorial(operacion: "\(a) - \(b) = \(resultado)", resultado: resultado)
        return resultado
    }
    
    func multiplicar(a: Double, b: Double) -> Double {
        let resultado = a * b
        guardarEnHistorial(operacion: "\(a) * \(b) = \(resultado)", resultado: resultado)
        return resultado
    }
    
    func dividir(a: Double, b: Double) -> Double? {
        guard b != 0 else {
            print(ErrorCalculadora.divisionPorCero.descripcion)
            return nil
        }
        let resultado = a / b
        guardarEnHistorial(operacion: "\(a) / \(b) = \(resultado)", resultado: resultado)
        return resultado
    }
    
    // MARK: - Método principal calcular
    func calcular(numero1: Double, numero2: Double, operacion: String) -> Double? {
        guard let op = OperacionCalculadora(rawValue: operacion) else {
            print(ErrorCalculadora.operacionInvalida.descripcion)
            return nil
        }
        
        do {
            guard let operacionMatematica = operaciones[op] else {
                throw ErrorCalculadora.operacionInvalida
            }
            
            let resultado = try operacionMatematica.ejecutar(a: numero1, b: numero2)
            let operacionString = "\(numero1) \(operacion) \(numero2) = \(resultado)"
            guardarEnHistorial(operacion: operacionString, resultado: resultado)
            
            return resultado
            
        } catch ErrorCalculadora.divisionPorCero {
            print(ErrorCalculadora.divisionPorCero.descripcion)
            return nil
        } catch {
            print("❌ Error inesperado: \(error)")
            return nil
        }
    }
    
    // MARK: - Métodos de utilidad
    private func guardarEnHistorial(operacion: String, resultado: Double) {
        historial.append((operacion: operacion, resultado: resultado))
    }
    
    func mostrarHistorial() {
        guard !historial.isEmpty else {
            print("📝 El historial está vacío")
            return
        }
        
        print("\n📚 HISTORIAL DE OPERACIONES:")
        print("=" * 40)
        for (index, registro) in historial.enumerated() {
            print("\(index + 1). \(registro.operacion)")
        }
        print("=" * 40)
    }
    
    func limpiarHistorial() {
        historial.removeAll()
        print("🗑️ Historial limpiado")
    }
    
    func estadisticas() {
        guard !historial.isEmpty else {
            print("📊 No hay operaciones para mostrar estadísticas")
            return
        }
        
        let totalOperaciones = historial.count
        let sumaResultados = historial.reduce(0) { $0 + $1.resultado }
        let promedio = sumaResultados / Double(totalOperaciones)
        let maximo = historial.max { $0.resultado < $1.resultado }?.resultado ?? 0
        let minimo = historial.min { $0.resultado < $1.resultado }?.resultado ?? 0
        
        print("\n📊 ESTADÍSTICAS:")
        print("Total de operaciones: \(totalOperaciones)")
        print("Suma de resultados: \(String(format: "%.2f", sumaResultados))")
        print("Promedio: \(String(format: "%.2f", promedio))")
        print("Resultado máximo: \(String(format: "%.2f", maximo))")
        print("Resultado mínimo: \(String(format: "%.2f", minimo))")
    }
}

// MARK: - Extensión para formateo de números
extension Double {
    func formatear(decimales: Int = 2) -> String {
        return String(format: "%.\(decimales)f", self)
    }
}

// MARK: - Función para obtener entrada del usuario de forma segura
func obtenerNumero(mensaje: String) -> Double? {
    print(mensaje, terminator: "")
    guard let input = readLine(), let numero = Double(input) else {
        print(ErrorCalculadora.numeroInvalido.descripcion)
        return nil
    }
    return numero
}

func obtenerOperacion() -> String? {
    print("Ingrese la operación (+, -, *, /): ", terminator: "")
    guard let operacion = readLine(), !operacion.isEmpty else {
        print(ErrorCalculadora.operacionInvalida.descripcion)
        return nil
    }
    return operacion.trimmingCharacters(in: .whitespacesAndNewlines)
}

// MARK: - Función principal del programa
func ejecutarCalculadora() {
    let calculadora = Calculadora()
    
    print("""
    🧮 CALCULADORA BÁSICA
    ==================
    Operaciones disponibles:
    + : Suma
    - : Resta
    * : Multiplicación
    / : División
    
    """)
    
    var continuar = true
    
    while continuar {
        print("\n--- NUEVA OPERACIÓN ---")
        
        // Obtener primer número
        guard let numero1 = obtenerNumero(mensaje: "Ingrese el primer número: ") else {
            continue
        }
        
        // Obtener segundo número
        guard let numero2 = obtenerNumero(mensaje: "Ingrese el segundo número: ") else {
            continue
        }
        
        // Obtener operación
        guard let operacion = obtenerOperacion() else {
            continue
        }
        
        // Realizar cálculo
        if let resultado = calculadora.calcular(numero1: numero1, numero2: numero2, operacion: operacion) {
            print("✅ Resultado: \(numero1) \(operacion) \(numero2) = \(resultado.formatear())")
        }
        
        // Preguntar si desea continuar
        print("\n¿Desea realizar otra operación? (s/n): ", terminator: "")
        if let respuesta = readLine()?.lowercased(), 
           respuesta == "n" || respuesta == "no" {
            continuar = false
        }
    }
    
    // Mostrar resumen final
    print("\n🎯 RESUMEN FINAL")
    calculadora.mostrarHistorial()
    calculadora.estadisticas()
    print("\n¡Gracias por usar la calculadora! 👋")
}

// MARK: - Función de pruebas automáticas
func ejecutarPruebas() {
    print("🧪 EJECUTANDO PRUEBAS AUTOMÁTICAS")
    print("=" * 40)
    
    let calculadora = Calculadora()
    
    // Pruebas de operaciones básicas
    print("\n1. Probando operaciones básicas:")
    
    let resultadoSuma = calculadora.calcular(numero1: 10, numero2: 5, operacion: "+")
    print("   Suma: 10 + 5 = \(resultadoSuma?.formatear() ?? "Error")")
    
    let resultadoResta = calculadora.calcular(numero1: 10, numero2: 3, operacion: "-")
    print("   Resta: 10 - 3 = \(resultadoResta?.formatear() ?? "Error")")
    
    let resultadoMultiplicacion = calculadora.calcular(numero1: 7, numero2: 8, operacion: "*")
    print("   Multiplicación: 7 * 8 = \(resultadoMultiplicacion?.formatear() ?? "Error")")
    
    let resultadoDivision = calculadora.calcular(numero1: 15, numero2: 3, operacion: "/")
    print("   División: 15 / 3 = \(resultadoDivision?.formatear() ?? "Error")")
    
    // Prueba de división por cero
    print("\n2. Probando división por cero:")
    let divisionPorCero = calculadora.calcular(numero1: 10, numero2: 0, operacion: "/")
    print("   División por cero: \(divisionPorCero?.formatear() ?? "Error manejado correctamente")")
    
    // Prueba de operación inválida
    print("\n3. Probando operación inválida:")
    let operacionInvalida = calculadora.calcular(numero1: 5, numero2: 3, operacion: "%")
    print("   Operación inválida: \(operacionInvalida?.formatear() ?? "Error manejado correctamente")")
    
    // Pruebas con decimales
    print("\n4. Probando con números decimales:")
    let decimalTest = calculadora.calcular(numero1: 3.14, numero2: 2.5, operacion: "*")
    print("   Decimales: 3.14 * 2.5 = \(decimalTest?.formatear() ?? "Error")")
    
    // Mostrar estadísticas de las pruebas
    print("\n5. Estadísticas de las pruebas:")
    calculadora.estadisticas()
    
    print("\n✅ Todas las pruebas completadas")
}

// MARK: - Programa principal
print("🚀 PROGRAMA PRINCIPAL - CALCULADORA")
print("=" * 40)

print("""
Seleccione el modo de ejecución:
1. Modo interactivo (input del usuario)
2. Modo de pruebas automáticas
3. Demostración completa

Ingrese su opción (1, 2, o 3): 
""", terminator: "")

// Para propósitos de demostración, ejecutaremos las pruebas automáticas
// En un entorno real, se leería la entrada del usuario

print("Ejecutando modo de demostración completa...\n")

// Ejecutar pruebas automáticas
ejecutarPruebas()

// Demostración adicional con casos específicos
print("\n\n🎯 DEMOSTRACIÓN ADICIONAL")
print("=" * 30)

let demo = Calculadora()

// Casos de uso específicos
let operacionesDemo = [
    (25.0, 5.0, "+"),
    (100.0, 25.0, "-"),
    (12.0, 4.0, "*"),
    (81.0, 9.0, "/"),
    (10.0, 3.0, "/"),  // División con decimales
    (5.0, 0.0, "/"),   // División por cero
    (15.0, 4.0, "%")   // Operación inválida
]

print("Ejecutando serie de operaciones de demostración:")
for (a, b, op) in operacionesDemo {
    if let resultado = demo.calcular(numero1: a, numero2: b, operacion: op) {
        print("✅ \(a) \(op) \(b) = \(resultado.formatear())")
    }
}

print("\n📋 Resumen final de la demostración:")
demo.mostrarHistorial()
demo.estadisticas()

print("""

🎉 DEMOSTRACIÓN COMPLETADA
=========================

✅ Funcionalidades implementadas:
• Operaciones básicas (suma, resta, multiplicación, división)
• Manejo de errores (división por cero, operaciones inválidas)
• Historial de operaciones
• Estadísticas de uso
• Validación de entrada
• Formateo de números
• Arquitectura orientada a objetos
• Uso de protocolos y enumeraciones
• Manejo de errores con do-catch

¡La calculadora está lista para usar! 🧮
""")

// Comentario para ejecución en Replit:
/*
Para ejecutar en Replit:
1. Copie este código en un nuevo proyecto Swift
2. El programa ejecutará automáticamente las pruebas
3. Para modo interactivo, descomente la llamada a ejecutarCalculadora()
4. Para probar entrada manual, use la función ejecutarCalculadora()
*/
