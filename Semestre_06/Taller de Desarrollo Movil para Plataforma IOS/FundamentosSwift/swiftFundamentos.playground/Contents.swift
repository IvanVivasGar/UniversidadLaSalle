// Actividad Practica: Explorando los fundamentos de Swift
// Alumno: Iván Vivas García
// Fecha: Martes 5 de marzo, 2025

// Clase para repasar los fundamentos de Swift
class FundamentosSwift{
    // MARK: - PROPIEDADES
    
    /// **Variables y Constantes** Demostración de declaración y uso
    var variableEjemplo: String = "Valor Inicial"
    let constanteEjemplo: Int = 10
    
    /// **Tipos de Datos** Ejemplos de tipos fundamentales
    var entero: Int = 42
    var decimal: Double = 3.14159
    var texto: String = "Hola, Swift!"
    var booleano: Bool = true
    var arreglo: [String] = ["A", "B", "C"]
    var diccionario: [String: Int] = ["A": 1, "B": 2, "C": 3]
    var opcional: String? = "Puede tener un valor o ser null"
    
    // MARK: - INICIALIZADOR
    
    init() {
        print("Clase FundamentosSwift inicializada.")
        self.mostrarEjemplos()
    }
    
    // MARK: - METODOS
    
    /// ** Control de Flujo** Ilustración de estructuras condicionales y bucles
    func ejemplosControlFlujo(){
        print("\n--- Control de Flujo ---")
        // Condicional if-else
        if entero > 40 {
            print("El entero es mayor que 40")
        } else {
            print("El entero no es mayor que 40")
        }
        
        // Bucle for-in para arreglos
        print("\nElementos del arreglo:")
        for fruta in arreglo {
            print(fruta)
        }
        
        // Bucle for-in para rangos:
        print("\nNúmeros del 1 al 5:")
        for i in 1...5 {
            print(i)
        }
        
        // Bucle while
        var contador = 0
        while contador < 3{
            print("Contador: \(contador)")
            contador += 1
        }
    }
    
    /// **Funciones** Definicion y llamada de funciones con parametros y valor de retorno
    func saludar(nombre: String) -> String {
        return "Hola \(nombre)!"
    }
    
    func calcularArea(base: Double, altura: Double) -> Double {
        return 0.5 * base * altura
    }
    
    /// **Opcionales** Demostracion del manejo de valores opcionales
    func manejarOpcional(){
        print("\n--- Opcionales ---")
        if let valor = opcional {
            print("El opcional tiene valor: \(valor).")
        } else {
            print("El opcional es null.")
        }
        
        // Unwrapping forzado (¡usar con precaucion!)
        // print("Calor del opcional (forzado): \(opcional!)")
    }
    
    ///Metodo para mostrar todos los ejemplos
    func mostrarEjemplos(){
        print("\n--- Fundamentos de Swift ---")
        print("\n**Variables y Constantes:**")
        print("Variable: \(variableEjemplo)")
        print("Constante: \(constanteEjemplo)")
        
        print("\n**Tipos de Datos:**")
        print("Entero: \(entero)")
        print("Decimal: \(decimal)")
        print("Texto: \(texto)")
        print("Booleano: \(booleano)")
        print("Arreglo: \(arreglo)")
        print("Diccionario: \(diccionario)")
        print("Opcional: \(opcional ?? "Null")") // Usando nil-coalescing operator
        
        self.ejemplosControlFlujo()
        print("\n**Funciones:**")
        print(saludar(nombre: "Estudiante de sexto semestre"))
        print("Area del triangulo: \(calcularArea(base: 10.0, altura: 5.0))")
        self.manejarOpcional()
    }
}

let fundamentos = FundamentosSwift()
// La inicialización de la clase llamará a mostrarEjemplos() automáticamente
