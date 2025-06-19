import Foundation

// EJERCICIO 3: Control de Flujo - Condicionales
// Objetivo: Implementar toma de decisiones usando if-else y switch

print("=== EJERCICIO 3: Control de Flujo - Condicionales ===\n")

// 1. Pide al usuario que ingrese una calificación numérica (0-100)
print("Por favor, ingresa una calificación numérica (0-100):")

if let input = readLine(), let calificacion = Int(input) {
    // 2. Utilizando estructura if-else if-else para evaluar rendimiento
    print("Calificación ingresada: \(calificacion)")
    
    let rendimiento: String
    
    if calificacion >= 90 && calificacion <= 100 {
        rendimiento = "Excelente"
    } else if calificacion >= 80 && calificacion <= 89 {
        rendimiento = "Bueno"
    } else if calificacion >= 70 && calificacion <= 79 {
        rendimiento = "Suficiente"
    } else if calificacion >= 0 && calificacion < 70 {
        rendimiento = "Necesita mejorar"
    } else {
        rendimiento = "Calificación inválida (debe estar entre 0 y 100)"
    }
    
    print("Rendimiento: \(rendimiento)")
    
    // Evaluación adicional con emojis
    switch calificacion {
    case 90...100:
        print("🌟 ¡Felicitaciones! Excelente trabajo")
    case 80...89:
        print("👍 Buen trabajo, sigue así")
    case 70...79:
        print("📚 Suficiente, pero puedes mejorar")
    case 0..<70:
        print("💪 Necesitas estudiar más, ¡tú puedes!")
    default:
        print("⚠️ Calificación fuera del rango válido")
    }
    
} else {
    print("⚠️ Error: Por favor ingresa un número válido")
    // Para propósitos de demostración, usaremos una calificación de ejemplo
    let calificacionEjemplo = 85
    print("Usando calificación de ejemplo: \(calificacionEjemplo)")
    
    if calificacionEjemplo >= 90 {
        print("Rendimiento: Excelente")
    } else if calificacionEjemplo >= 80 {
        print("Rendimiento: Bueno")
    } else if calificacionEjemplo >= 70 {
        print("Rendimiento: Suficiente")
    } else {
        print("Rendimiento: Necesita mejorar")
    }
}

// 3. Declara una variable diaSemana
let diaSemana = "Lunes"
print("\nDía de la semana: \(diaSemana)")

// 4. Utilizando sentencia switch para diferentes días
switch diaSemana {
case "Lunes":
    print("🔋 ¡Nuevo comienzo! Es hora de empezar la semana con energía")
case "Martes":
    print("💪 Segundo día de la semana, mantén el ritmo")
case "Miércoles":
    print("🐪 ¡Mitad de semana! Ya vamos por la mitad")
case "Jueves":
    print("⚡ Casi llegamos al fin de semana, ¡un día más!")
case "Viernes":
    print("🎉 ¡Por fin viernes! El fin de semana está cerca")
case "Sábado":
    print("🌞 ¡Sábado de relajación y diversión!")
case "Domingo":
    print("😎 Domingo de descanso y preparación para la nueva semana")
default:
    print("🤔 Ese no parece ser un día válido de la semana")
}

// Ejemplo adicional con múltiples casos
print("\nClasificación del día:")
switch diaSemana {
case "Lunes", "Martes", "Miércoles", "Jueves", "Viernes":
    print("📚 Día laboral/escolar")
case "Sábado", "Domingo":
    print("🏖️ Fin de semana")
default:
    print("❓ Día no reconocido")
}

// Ejemplo con rangos en switch
let hora = 14
print("\nHora actual: \(hora):00")

switch hora {
case 6..<12:
    print("🌅 Buenos días")
case 12..<18:
    print("☀️ Buenas tardes")
case 18..<22:
    print("🌆 Buenas noches")
case 22...23, 0..<6:
    print("🌙 Es hora de dormir")
default:
    print("⏰ Hora inválida")
}
