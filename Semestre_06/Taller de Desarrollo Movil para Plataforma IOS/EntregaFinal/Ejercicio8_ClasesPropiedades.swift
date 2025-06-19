import Foundation

// EJERCICIO 8: Clases, Propiedades y Métodos
// Objetivo: Implementar clases con propiedades (almacenadas y computadas) y métodos

print("=== EJERCICIO 8: Clases, Propiedades y Métodos ===\n")

// 1. Define una clase llamada Libro
class Libro {
    // 2. Propiedades almacenadas
    var titulo: String
    var autor: String
    var numeroPaginas: Int
    var anoPublicacion: Int
    
    // 3. Propiedad computada llamada descripcion
    var descripcion: String {
        return "\(titulo) por \(autor), publicado en \(anoPublicacion)."
    }
    
    // Propiedades computadas adicionales
    var esClasico: Bool {
        let anoActual = Calendar.current.component(.year, from: Date())
        return (anoActual - anoPublicacion) > 50
    }
    
    var categoria: String {
        switch numeroPaginas {
        case 0..<100:
            return "Folleto"
        case 100..<300:
            return "Libro corto"
        case 300..<500:
            return "Libro estándar"
        case 500..<800:
            return "Libro largo"
        default:
            return "Libro épico"
        }
    }
    
    // 4. Inicializador para la clase Libro
    init(titulo: String, autor: String, numeroPaginas: Int, anoPublicacion: Int) {
        self.titulo = titulo
        self.autor = autor
        self.numeroPaginas = numeroPaginas
        self.anoPublicacion = anoPublicacion
        
        print("📚 Libro creado: \(titulo)")
    }
    
    // 5. Método de instancia esLibroLargo()
    func esLibroLargo() -> Bool {
        return numeroPaginas > 500
    }
    
    // Métodos adicionales
    func informacionCompleta() {
        print("=" * 50)
        print("📖 INFORMACIÓN DEL LIBRO")
        print("Título: \(titulo)")
        print("Autor: \(autor)")
        print("Páginas: \(numeroPaginas)")
        print("Año de publicación: \(anoPublicacion)")
        print("Descripción: \(descripcion)")
        print("Categoría: \(categoria)")
        print("Es libro largo: \(esLibroLargo() ? "Sí" : "No")")
        print("Es clásico: \(esClasico ? "Sí" : "No")")
        print("=" * 50)
    }
    
    func tiempoLecturaEstimado(palabrasPorMinuto: Int = 200) -> Double {
        // Estimación: 250 palabras por página en promedio
        let palabrasEstimadas = numeroPaginas * 250
        let minutos = Double(palabrasEstimadas) / Double(palabrasPorMinuto)
        return minutos / 60.0 // Convertir a horas
    }
    
    func actualizarInformacion(titulo: String? = nil, autor: String? = nil, 
                             numeroPaginas: Int? = nil, anoPublicacion: Int? = nil) {
        if let nuevoTitulo = titulo {
            self.titulo = nuevoTitulo
            print("✏️ Título actualizado a: \(nuevoTitulo)")
        }
        if let nuevoAutor = autor {
            self.autor = nuevoAutor
            print("✏️ Autor actualizado a: \(nuevoAutor)")
        }
        if let nuevasPaginas = numeroPaginas {
            self.numeroPaginas = nuevasPaginas
            print("✏️ Número de páginas actualizado a: \(nuevasPaginas)")
        }
        if let nuevoAno = anoPublicacion {
            self.anoPublicacion = nuevoAno
            print("✏️ Año de publicación actualizado a: \(nuevoAno)")
        }
    }
    
    func compararCon(_ otroLibro: Libro) -> String {
        var comparaciones: [String] = []
        
        if self.numeroPaginas > otroLibro.numeroPaginas {
            comparaciones.append("más largo (\(self.numeroPaginas) vs \(otroLibro.numeroPaginas) páginas)")
        } else if self.numeroPaginas < otroLibro.numeroPaginas {
            comparaciones.append("más corto (\(self.numeroPaginas) vs \(otroLibro.numeroPaginas) páginas)")
        } else {
            comparaciones.append("igual longitud (\(self.numeroPaginas) páginas)")
        }
        
        if self.anoPublicacion > otroLibro.anoPublicacion {
            comparaciones.append("más reciente (\(self.anoPublicacion) vs \(otroLibro.anoPublicacion))")
        } else if self.anoPublicacion < otroLibro.anoPublicacion {
            comparaciones.append("más antiguo (\(self.anoPublicacion) vs \(otroLibro.anoPublicacion))")
        } else {
            comparaciones.append("del mismo año (\(self.anoPublicacion))")
        }
        
        return "'\(self.titulo)' es \(comparaciones.joined(separator: " y ")) que '\(otroLibro.titulo)'"
    }
}

// 6. Crea dos instancias de Libro con diferentes datos
print("📚 CREANDO INSTANCIAS DE LIBROS")
print("=" * 35)

let libro1 = Libro(
    titulo: "El Principito",
    autor: "Antoine de Saint-Exupéry",
    numeroPaginas: 96,
    anoPublicacion: 1943
)

let libro2 = Libro(
    titulo: "Don Quijote de la Mancha",
    autor: "Miguel de Cervantes",
    numeroPaginas: 863,
    anoPublicacion: 1605
)

// 7. Imprime la descripcion de cada libro y si es o no un libro largo
print("\n📋 INFORMACIÓN BÁSICA DE LOS LIBROS")
print("=" * 40)

print("\n🔹 LIBRO 1:")
print("Descripción: \(libro1.descripcion)")
print("¿Es libro largo? \(libro1.esLibroLargo() ? "Sí (más de 500 páginas)" : "No (500 páginas o menos)")")

print("\n🔹 LIBRO 2:")
print("Descripción: \(libro2.descripcion)")
print("¿Es libro largo? \(libro2.esLibroLargo() ? "Sí (más de 500 páginas)" : "No (500 páginas o menos)")")

// DEMOSTRACIONES ADICIONALES
print("\n\n🚀 DEMOSTRACIONES ADICIONALES")
print("=" * 40)

// Información completa de los libros
print("\n📊 INFORMACIÓN COMPLETA:")
libro1.informacionCompleta()
libro2.informacionCompleta()

// Tiempo de lectura estimado
print("\n⏱️ TIEMPO DE LECTURA ESTIMADO:")
let tiempoLectura1 = libro1.tiempoLecturaEstimado()
let tiempoLectura2 = libro2.tiempoLecturaEstimado()

print("📖 \(libro1.titulo): \(String(format: "%.1f", tiempoLectura1)) horas")
print("📖 \(libro2.titulo): \(String(format: "%.1f", tiempoLectura2)) horas")

// Comparación entre libros
print("\n🔍 COMPARACIÓN ENTRE LIBROS:")
print(libro1.compararCon(libro2))

// Crear más libros para demostrar diferentes categorías
print("\n\n📚 CREANDO MÁS LIBROS PARA DEMOSTRAR CATEGORÍAS")
print("=" * 55)

let libros = [
    Libro(titulo: "Guía Rápida de Swift", autor: "Apple Inc.", numeroPaginas: 75, anoPublicacion: 2020),
    Libro(titulo: "Cien años de soledad", autor: "Gabriel García Márquez", numeroPaginas: 417, anoPublicacion: 1967),
    Libro(titulo: "Guerra y Paz", autor: "León Tolstói", numeroPaginas: 1225, anoPublicacion: 1869),
    Libro(titulo: "El Hobbit", autor: "J.R.R. Tolkien", numeroPaginas: 310, anoPublicacion: 1937)
]

print("\n📊 RESUMEN DE TODOS LOS LIBROS:")
print("-" * 80)
print(String(format: "%-30s %-20s %-8s %-4s %-12s %-8s", 
             "Título", "Autor", "Páginas", "Año", "Categoría", "Clásico"))
print("-" * 80)

for libro in libros {
    let autorCorto = libro.autor.count > 18 ? String(libro.autor.prefix(15)) + "..." : libro.autor
    let tituloCorto = libro.titulo.count > 28 ? String(libro.titulo.prefix(25)) + "..." : libro.titulo
    
    print(String(format: "%-30s %-20s %-8d %-4d %-12s %-8s",
                 tituloCorto,
                 autorCorto,
                 libro.numeroPaginas,
                 libro.anoPublicacion,
                 libro.categoria,
                 libro.esClasico ? "Sí" : "No"))
}

// Actualización de información
print("\n\n✏️ ACTUALIZANDO INFORMACIÓN DE UN LIBRO")
print("=" * 45)

print("Información original de '\(libro1.titulo)':")
print("Páginas: \(libro1.numeroPaginas)")

libro1.actualizarInformacion(numeroPaginas: 120)

print("Información actualizada:")
print("Páginas: \(libro1.numeroPaginas)")
print("Nueva categoría: \(libro1.categoria)")

// Estadísticas de la colección
print("\n\n📈 ESTADÍSTICAS DE LA COLECCIÓN")
print("=" * 40)

let todosLosLibros = [libro1, libro2] + libros
let totalLibros = todosLosLibros.count
let totalPaginas = todosLosLibros.reduce(0) { $0 + $1.numeroPaginas }
let promediopaginas = Double(totalPaginas) / Double(totalLibros)
let librosLargos = todosLosLibros.filter { $0.esLibroLargo() }.count
let clasicos = todosLosLibros.filter { $0.esClasico }.count

print("Total de libros: \(totalLibros)")
print("Total de páginas: \(totalPaginas)")
print("Promedio de páginas: \(String(format: "%.1f", promediopaginas))")
print("Libros largos (>500 páginas): \(librosLargos)")
print("Libros clásicos (>50 años): \(clasicos)")

// Libro más largo y más corto
if let libroMasLargo = todosLosLibros.max(by: { $0.numeroPaginas < $1.numeroPaginas }),
   let libroMasCorto = todosLosLibros.min(by: { $0.numeroPaginas < $1.numeroPaginas }) {
    
    print("\n📏 Extremos de la colección:")
    print("Libro más largo: '\(libroMasLargo.titulo)' (\(libroMasLargo.numeroPaginas) páginas)")
    print("Libro más corto: '\(libroMasCorto.titulo)' (\(libroMasCorto.numeroPaginas) páginas)")
}

print("\n✅ Demostración de clases, propiedades y métodos completada!")
