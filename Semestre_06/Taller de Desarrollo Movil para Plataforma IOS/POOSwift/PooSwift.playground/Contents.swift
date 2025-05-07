// Actividad Practica: Explorando los Fundamentos de Swift
// Alumno: Iván Vivas García
// Fecha: Miercoles 7 de mayo, 2025

class ProgramacionOrientadaObjetos {
    // MARK: - Clases y Objetos
    
    /// **Clases y Objetos** Definicion de una clase simple y creacion de instancias
    class Vehiculo {
        var marca: String
        var modelo: String
        
        init(marca: String, modelo: String) {
            self.marca = marca
            self.modelo = modelo
        }
        
        func presentarse() {
            print("Soy un \(marca) \(modelo).")
        }
    }
    
    func crearVehiculo() {
        print("\n--- Clases y Objetos ---")
        let miCoche = Vehiculo(marca: "MG", modelo: "5E")
        miCoche.presentarse()
    }
    
    // MARK: - Herencia
    
    /// **Herencia** Creacion de una subclase que hereda de clase Vehiculo
    class CocheDeportivo: Vehiculo {
        var velocidadMaxima: Int
        
        init(marca: String, modelo: String, velocidadMaxima: Int){
            self.velocidadMaxima = velocidadMaxima
            super.init(marca: marca, modelo: modelo)
        }
        
        override func presentarse() {
            super.presentarse()
            print("Y mi velocidad máxima es de \(velocidadMaxima) km/h.")
        }
    }
    
    func crearCocheDeportivo() {
        print("\n--- Herencia ---")
        let miDeportivo = CocheDeportivo(marca: "Audi", modelo: "RS7 Sport", velocidadMaxima: 260)
        miDeportivo.presentarse()
    }
    
    // MARK: - Encapsulamiento
    
    /// **Encapsulamiento** Uso de modificadores de acceso (internal por defecto, private, public)
    class CuentaBancaria {
        private var saldo: Double = 0
        
        func depositar(cantidad: Double){
            if cantidad > 0 {
                saldo += cantidad
                print("Se depositaron \(cantidad). Nuevo saldo: \(saldo)")
            } else {
                print("La cantidad a depositar debe ser mayor que cero.")
            }
        }
        
        func obtenerSaldo() -> Double {
            return saldo
        }
    }
    
    func usarCuentaBancaria() {
        print("\n--- Encapsulamiento ---")
        let miCuenta = CuentaBancaria()
        miCuenta.depositar(cantidad: 5000.0)
        // print(miCuenta.saldo) // Esto daria un error porque 'saldo' es privado
        print("Saldo actual: \(miCuenta.obtenerSaldo())")
    }
    
    // MARK: - Polimorfismo
    
    /// **Polimorfismo** Ejemplo basico de como objetos de diferentes clases pueden responder al mismo metodo
    func hacerPresentacion(vehiculo: Vehiculo) {
        vehiculo.presentarse()
    }
    
    func ejemploPolimorfismo() {
        print("\n--- Polimorfismo ---")
        let cocheBase = Vehiculo(marca: "Toyota", modelo: "Corolla")
        let cocheDeportivo = CocheDeportivo(marca: "Porsche", modelo: "911", velocidadMaxima: 300)
        
        hacerPresentacion(vehiculo: cocheBase)
        hacerPresentacion(vehiculo: cocheDeportivo)
    }
    
    // MARK: - Inicializador
    
    init() {
        print("\nClase ProgramacionOrientadaObjetos inicializada")
        self.crearVehiculo()
        self.crearCocheDeportivo()
        self.usarCuentaBancaria()
        self.ejemploPolimorfismo()
    }
}

let pooSwift = ProgramacionOrientadaObjetos()
