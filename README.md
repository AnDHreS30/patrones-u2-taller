# Taller Patrones de Diseño – Unidad 2

**Estudiante:** Adrián Villarroel González
**Asignatura:** Patrones de Diseño y UML para el Desarrollo de Software Eficiente (IPLACEX)

Solución del taller sobre la tienda web **Deccos**, desarrollada a partir del código base:
https://github.com/stgoneira/patrones-u2-taller

## Patrones implementados

| Actividad | Patrones | Clases principales |
|---|---|---|
| 1. Menú | Adapter + Composite | `EnlaceItemMenu`, `CategoriaItemMenu`, `MenuControllerAdvice` |
| 2. Avisos | Adapter + Fachada | `ProductoAvisoAdapter`, `TiendaFacade`, `TiendaController`, `CategoriaService.getCategoriaPorSku()` |
| 3. Usuario anónimo | Null-Object | `UsuarioAnonimo`, `SecurityConfig` |

## Requisitos

- Java 17
- Eclipse IDE (o IntelliJ IDEA) con soporte para Gradle

## Ejecutar

1. Importar la carpeta `tienda` como proyecto Gradle (*File → Import → Gradle → Existing Gradle Project*).
2. Ejecutar la clase `cl.patrones.taller.u2.TiendaApplication` (*Run As → Java Application*).
3. Abrir http://localhost:8080

Usuario de prueba: `jperez@123.cl` / `1234`
