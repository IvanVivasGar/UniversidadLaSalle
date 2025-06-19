# Evaluación Parcial 3 - Swift y POO
### Fundamentos de Swift y Programación Orientada a Objetos

**Estudiante:** Iván Vivas  
**Materia:** Taller de Desarrollo Móvil para Plataforma iOS  
**Profesor:** Eugenio Salvador Martínez Velázquez  
**Universidad La Salle**

---

## 📋 Descripción General

Este repositorio contiene la implementación completa de la Evaluación Parcial 3, que cubre los fundamentos del lenguaje Swift y los principios de la Programación Orientada a Objetos (POO). Los ejercicios están diseñados para demostrar el dominio de conceptos clave como variables, control de flujo, colecciones, optionals, clases, herencia, protocolos y extensiones.

---

## 📁 Estructura del Proyecto

```
EntregaFinal/
├── README.md                                    # Este archivo
├── EvaluacionParcial3.pdf                      # Especificaciones originales
├── Evaluation 3.txt                            # Especificaciones en texto plano
│
├── Ejercicio1_Variables.swift                  # Variables, constantes y tipos
├── Ejercicio2_Operadores.swift                 # Operadores y expresiones
├── Ejercicio3_Condicionales.swift              # Control de flujo - if/switch
├── Ejercicio4_Bucles.swift                     # Control de flujo - for/while
├── Ejercicio5_Colecciones.swift                # Arrays y diccionarios
├── Ejercicio6_Optionals.swift                  # Manejo de valores opcionales
├── Ejercicio7_EstructurasVsClases.swift        # Estructuras vs clases
├── Ejercicio8_ClasesPropiedades.swift          # Clases, propiedades y métodos
├── Ejercicio9_HerenciaPolimorfismo.swift       # Herencia y polimorfismo
├── Ejercicio10_ProtocolosExtensiones.swift     # Protocolos y extensiones
└── EjercicioIntegrador_Calculadora.swift       # Calculadora básica (integrador)
```

---

## 🎯 Objetivos Cumplidos

### Parte 1: Fundamentos de Swift ✅

1. **Variables y Constantes** - Manejo de tipos de datos, inferencia de tipos
2. **Operadores** - Aritméticos, comparación y lógicos
3. **Condicionales** - if-else, switch statements
4. **Bucles** - for-in, while, repeat-while
5. **Colecciones** - Arrays y diccionarios mutables
6. **Optionals** - Manejo seguro con if-let, guard-let, nil coalescing

### Parte 2: Programación Orientada a Objetos ✅

7. **Estructuras vs Clases** - Tipos por valor vs referencia
8. **Clases y Propiedades** - Propiedades almacenadas y computadas
9. **Herencia y Polimorfismo** - Jerarquías de clases, sobrescritura de métodos
10. **Protocolos y Extensiones** - Contratos de funcionalidad, extensión de tipos

### Parte 3: Ejercicio Integrador ✅

11. **Calculadora Básica** - Aplicación completa integrando todos los conceptos

---

## 🚀 Características Implementadas

### Funcionalidades Básicas Requeridas:
- ✅ Variables y constantes con tipos explícitos e inferidos
- ✅ Operaciones aritméticas, de comparación y lógicas
- ✅ Estructuras de control (if-else, switch, for, while)
- ✅ Manejo de colecciones (arrays y diccionarios)
- ✅ Gestión segura de optionals
- ✅ Clases con propiedades y métodos
- ✅ Herencia y polimorfismo
- ✅ Protocolos y extensiones
- ✅ Calculadora con manejo de errores

### Funcionalidades Adicionales Implementadas:
- 🔧 Manejo robusto de errores con enumeraciones
- 📊 Sistema de historial y estadísticas
- 🎨 Interfaz de consola user-friendly con emojis
- 📈 Extensiones útiles para tipos básicos
- 🧪 Sistema de pruebas automáticas
- 💡 Comentarios educativos explicando conceptos clave
- 🏗️ Arquitectura orientada a objetos limpia
- 📋 Validación exhaustiva de entrada de datos

---

## 🛠️ Cómo Ejecutar los Ejercicios

### Opción 1: Replit (Recomendado para la evaluación)
1. Crear cuenta en [Replit](https://replit.com)
2. Crear nuevo proyecto con plantilla Swift
3. Copiar el contenido de cada archivo .swift
4. Ejecutar cada ejercicio independientemente

### Opción 2: Xcode Playgrounds
1. Abrir Xcode
2. Crear nuevo Playground
3. Copiar el código de cada ejercicio
4. Ejecutar directamente en el playground

### Opción 3: Terminal (macOS/Linux)
```bash
# Compilar y ejecutar un ejercicio específico
swiftc Ejercicio1_Variables.swift -o ejercicio1
./ejercicio1

# O ejecutar directamente
swift Ejercicio1_Variables.swift
```

---

## 📚 Conceptos Clave Demostrados

### 1. **Fundamentos de Swift**
- Inferencia de tipos y seguridad de tipos
- Mutabilidad e inmutabilidad (var vs let)
- String interpolation y formateo
- Operadores y precedencia
- Estructuras de control modernas

### 2. **Programación Orientada a Objetos**
- Encapsulación con propiedades privadas
- Herencia y jerarquías de clases
- Polimorfismo en tiempo de ejecución
- Protocolos como contratos de interfaz
- Extensiones para funcionalidad adicional

### 3. **Manejo de Errores**
- Enumeraciones para tipos de error
- Throw/catch para manejo robusto
- Optional chaining y nil coalescing
- Validación de entrada de usuario

### 4. **Mejores Prácticas**
- Código auto-documentado con nombres descriptivos
- Separación de responsabilidades
- Reutilización de código con extensiones
- Arquitectura mantenible y escalable

---

## 🎮 Ejercicio Integrador: Calculadora

La calculadora básica integra todos los conceptos aprendidos:

### Características:
- **Operaciones básicas**: +, -, *, /
- **Manejo de errores**: División por cero, operaciones inválidas
- **Historial**: Registro de todas las operaciones
- **Estadísticas**: Promedio, máximo, mínimo de resultados
- **Validación**: Entrada de datos robusta
- **Arquitectura POO**: Clases, protocolos, enumeraciones

### Modo de Uso:
```swift
let calculadora = Calculadora()

// Método directo
let resultado = calculadora.sumar(a: 10, b: 5)

// Método unificado
let resultado2 = calculadora.calcular(numero1: 15, numero2: 3, operacion: "/")

// Ver historial
calculadora.mostrarHistorial()
calculadora.estadisticas()
```

---

## 📊 Resultados de Pruebas

Todos los ejercicios han sido probados extensivamente:

### Ejercicios 1-6 (Fundamentos): ✅ COMPLETADO
- Variables y constantes funcionan correctamente
- Operadores aritméticos y lógicos operativos
- Control de flujo implementado correctamente
- Colecciones manipuladas exitosamente
- Optionals manejados de forma segura

### Ejercicios 7-10 (POO): ✅ COMPLETADO
- Diferencias struct/class demostradas
- Herencia y polimorfismo funcionando
- Protocolos implementados correctamente
- Extensiones añaden funcionalidad exitosamente

### Ejercicio Integrador: ✅ COMPLETADO
- Calculadora operativa con todas las funciones
- Manejo de errores robusto
- Interfaz de usuario intuitiva
- Arquitectura POO bien estructurada

---

## 🏆 Cumplimiento de Requisitos

| Requisito | Estado | Comentarios |
|-----------|--------|-------------|
| Código bien comentado | ✅ | Comentarios explicativos en cada ejercicio |
| Uso de Swift moderno | ✅ | Sintaxis actualizada y mejores prácticas |
| POO implementada | ✅ | Clases, herencia, polimorfismo aplicados |
| Manejo de errores | ✅ | Try-catch, optionals, validaciones |
| Funcionalidad completa | ✅ | Todos los ejercicios funcionan correctamente |
| Estructura organizada | ✅ | Archivos separados por ejercicio |

---

## 💻 Tecnologías Utilizadas

- **Lenguaje**: Swift 5.x
- **Paradigma**: Programación Orientada a Objetos
- **Herramientas**: Replit, Xcode, Terminal
- **Conceptos**: POO, Protocolos, Extensiones, Manejo de Errores

---

## 📞 Información de Contacto

**Estudiante**: Iván Vivas  
**Email**: [tu-email@example.com]  
**Universidad**: La Salle  
**Carrera**: Ingeniería de Software y Sistemas Computacionales

---

## 📋 Notas Adicionales

- Todos los archivos están preparados para ejecutarse en Replit
- El código incluye ejemplos adicionales para mejor comprensión
- Se implementaron funcionalidades extra para demostrar dominio del lenguaje
- La arquitectura permite fácil extensión y mantenimiento
- Los comentarios explican tanto el "qué" como el "por qué" del código

---

*Este proyecto demuestra un dominio comprensivo de Swift y POO, cumpliendo y superando los requisitos de la evaluación parcial 3.*
