import Foundation

// EJERCICIO 9: Herencia y Polimorfismo
// Objetivo: Aplicar herencia para crear jerarquías de clases y polimorfismo

print("=== EJERCICIO 9: Herencia y Polimorfismo ===\n")

// 1. Define una clase base llamada Vehiculo
class Vehiculo {
    // Propiedades
    var marca: String
    var modelo: String
    
    // Inicializador que acepte marca y modelo
    init(marca: String, modelo: String) {
        self.marca = marca
        self.modelo = modelo
        print("🚗 Creando vehículo: \(marca) \(modelo)")
    }
    
    // Método describirVehiculo()
    func describirVehiculo() {
        print("Vehículo: \(marca) \(modelo)")
    }
    
    // Método arrancarMotor() (será sobrescrito)
    func arrancarMotor() {
        print("El motor del vehículo ha arrancado.")
    }
    
    // Métodos adicionales de la clase base
    func detenerMotor() {
        print("El motor del \(marca) \(modelo) se ha detenido.")
    }
    
    func acelerar() {
        print("El \(marca) \(modelo) está acelerando.")
    }
    
    func frenar() {
        print("El \(marca) \(modelo) está frenando.")
    }
}

// 2. Crea una clase Coche que herede de Vehiculo
class Coche: Vehiculo {
    // Añade una propiedad numeroPuertas
    var numeroPuertas: Int
    
    // Sobrescribe el inicializador para incluir numeroPuertas
    init(marca: String, modelo: String, numeroPuertas: Int) {
        self.numeroPuertas = numeroPuertas
        // Llama al inicializador de la superclase
        super.init(marca: marca, modelo: modelo)
        print("🚙 Coche creado con \(numeroPuertas) puertas")
    }
    
    // Sobrescribe el método arrancarMotor()
    override func arrancarMotor() {
        print("El motor del coche \(marca) \(modelo) ha arrancado suavemente.")
    }
    
    // Métodos específicos del coche
    func abrirPuertas() {
        print("Abriendo las \(numeroPuertas) puertas del \(marca) \(modelo)")
    }
    
    func activarAireAcondicionado() {
        print("💨 Aire acondicionado activado en el \(marca) \(modelo)")
    }
    
    override func acelerar() {
        super.acelerar() // Llama al método de la clase padre
        print("El coche está cambiando suavemente de velocidad.")
    }
}

// 3. Crea una clase Motocicleta que herede de Vehiculo
class Motocicleta: Vehiculo {
    // Añade una propiedad tipoManillar
    var tipoManillar: String
    
    // Sobrescribe el inicializador para incluir tipoManillar
    init(marca: String, modelo: String, tipoManillar: String) {
        self.tipoManillar = tipoManillar
        // Llama al inicializador de la superclase
        super.init(marca: marca, modelo: modelo)
        print("🏍️ Motocicleta creada con manillar \(tipoManillar)")
    }
    
    // Sobrescribe el método arrancarMotor()
    override func arrancarMotor() {
        print("El motor de la motocicleta \(marca) \(modelo) ruge al arrancar.")
    }
    
    // Métodos específicos de la motocicleta
    func hacerCaballito() {
        print("🏁 ¡La \(marca) \(modelo) está haciendo un caballito!")
    }
    
    func inclinarEnCurva() {
        print("🏍️ La motocicleta se inclina elegantemente en la curva")
    }
    
    override func acelerar() {
        super.acelerar()
        print("La motocicleta acelera rápidamente con un rugido del motor.")
    }
}

// 4. Crea una instancia de Coche y una de Motocicleta
print("\n🏭 CREANDO INSTANCIAS DE VEHÍCULOS")
print("=" * 40)

let miCoche = Coche(marca: "Toyota", modelo: "Corolla", numeroPuertas: 4)
let miMotocicleta = Motocicleta(marca: "Yamaha", modelo: "R1", tipoManillar: "Deportivo")

// 5. Crea un array llamado misVehiculos que contenga ambas instancias
print("\n🚗 CREANDO ARRAY DE VEHÍCULOS")
print("=" * 35)

let misVehiculos: [Vehiculo] = [miCoche, miMotocicleta]
print("Array creado con \(misVehiculos.count) vehículos")

// 6. Itera sobre el array y llama al método arrancarMotor() (POLIMORFISMO)
print("\n🔥 DEMOSTRACIÓN DE POLIMORFISMO")
print("=" * 38)

print("Arrancando todos los vehículos:")
for (index, vehiculo) in misVehiculos.enumerated() {
    print("\n--- Vehículo \(index + 1) ---")
    vehiculo.describirVehiculo()
    vehiculo.arrancarMotor() // ¡Polimorfismo en acción!
}

// DEMOSTRACIONES ADICIONALES
print("\n\n🚀 DEMOSTRACIONES ADICIONALES")
print("=" * 40)

// Uso de métodos específicos de cada clase
print("\n🔧 MÉTODOS ESPECÍFICOS DE CADA CLASE:")
print("--- Coche ---")
miCoche.abrirPuertas()
miCoche.activarAireAcondicionado()

print("\n--- Motocicleta ---")
miMotocicleta.hacerCaballito()
miMotocicleta.inclinarEnCurva()

// Demostración de herencia de métodos
print("\n🔄 MÉTODOS HEREDADOS DE LA CLASE BASE:")
for vehiculo in misVehiculos {
    print("\n--- \(vehiculo.marca) \(vehiculo.modelo) ---")
    vehiculo.acelerar()
    vehiculo.frenar()
    vehiculo.detenerMotor()
}

// Crear más vehículos para una demostración más amplia
print("\n\n🏭 CREANDO MÁS VEHÍCULOS")
print("=" * 30)

let cochesVariados = [
    Coche(marca: "BMW", modelo: "X5", numeroPuertas: 4),
    Coche(marca: "Tesla", modelo: "Model 3", numeroPuertas: 4),
    Coche(marca: "MINI", modelo: "Cooper", numeroPuertas: 2)
]

let motocicletasVariadas = [
    Motocicleta(marca: "Harley-Davidson", modelo: "Street 750", tipoManillar: "Crucero"),
    Motocicleta(marca: "Ducati", modelo: "Panigale", tipoManillar: "Deportivo"),
    Motocicleta(marca: "Honda", modelo: "Gold Wing", tipoManillar: "Touring")
]

// Array con todos los vehículos
let todosLosVehiculos: [Vehiculo] = [miCoche, miMotocicleta] + cochesVariados + motocicletasVariadas

print("\n🚗🏍️ GESTIÓN DE FLOTA COMPLETA")
print("=" * 35)

print("Total de vehículos en la flota: \(todosLosVehiculos.count)")

// Contar por tipo usando type checking
var conteoCoches = 0
var conteoMotocicletas = 0

for vehiculo in todosLosVehiculos {
    if vehiculo is Coche {
        conteoCoches += 1
    } else if vehiculo is Motocicleta {
        conteoMotocicletas += 1
    }
}

print("Coches: \(conteoCoches)")
print("Motocicletas: \(conteoMotocicletas)")

// Demostración de type casting
print("\n🔍 TYPE CASTING Y ACCESO A PROPIEDADES ESPECÍFICAS:")
for (index, vehiculo) in todosLosVehiculos.enumerated() {
    print("\n--- Vehículo \(index + 1): \(vehiculo.marca) \(vehiculo.modelo) ---")
    
    if let coche = vehiculo as? Coche {
        print("   ✅ Es un coche con \(coche.numeroPuertas) puertas")
    } else if let moto = vehiculo as? Motocicleta {
        print("   ✅ Es una motocicleta con manillar \(moto.tipoManillar)")
    }
}

// Simulación de arranque masivo
print("\n\n🚀 SIMULACIÓN DE ARRANQUE MASIVO (POLIMORFISMO)")
print("=" * 55)

func arrancarFlota(_ vehiculos: [Vehiculo]) {
    print("🔥 Arrancando toda la flota...")
    for vehiculo in vehiculos {
        vehiculo.arrancarMotor() // Cada vehículo usa su propia implementación
    }
    print("✅ Toda la flota está en marcha!")
}

arrancarFlota(todosLosVehiculos)

// Demostración de método polimórfico personalizado
print("\n\n⚡ DEMOSTRACIÓN DE ACELERACIÓN POLIMÓRFICA")
print("=" * 48)

func competencia(_ vehiculos: [Vehiculo]) {
    print("🏁 ¡Iniciando competencia!")
    for (index, vehiculo) in vehiculos.enumerated() {
        print("\nCompetidor \(index + 1): \(vehiculo.marca) \(vehiculo.modelo)")
        vehiculo.acelerar() // Comportamiento polimórfico
    }
    print("\n🏆 ¡Competencia finalizada!")
}

// Seleccionar algunos vehículos para la competencia
let competidores = Array(todosLosVehiculos.prefix(4))
competencia(competidores)

// Estadísticas finales
print("\n\n📊 ESTADÍSTICAS DE LA DEMOSTRACIÓN")
print("=" * 40)

print("📈 Resumen de herencia y polimorfismo:")
print("• Clase base: Vehiculo")
print("• Clases derivadas: Coche, Motocicleta")
print("• Total de instancias creadas: \(todosLosVehiculos.count)")
print("• Métodos sobrescritos: arrancarMotor(), acelerar()")
print("• Polimorfismo demostrado: ✅")
print("• Type casting utilizado: ✅")
print("• Herencia de propiedades y métodos: ✅")

print("\n✅ Demostración de herencia y polimorfismo completada!")
