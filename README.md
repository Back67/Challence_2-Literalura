

# Gutendex Book Search - Java Application

![Gutendex Logo](https://gutendex.com/static/logo.png)

Este proyecto es una aplicación en Java que permite buscar libros en español utilizando la API Gutendex. Gutendex es una API que se basa en el proyecto Gutenberg y proporciona acceso a una gran cantidad de libros digitales de dominio público.

## Características

- Búsqueda de libros por idioma (ES, EN, FR, PT) utilizando la API Gutendex.
- Evita la inserción de libros duplicados en la base de datos local.
- Manejo de errores y mensajes claros para libros no encontrados.

## Requisitos Previos

Para ejecutar esta aplicación, necesitas tener instalado lo siguiente:

- Java Development Kit (JDK) versión 8 o superior.
- Acceso a Internet para realizar consultas a la API Gutendex.

## Configuración del Proyecto

1. **Clonar el Repositorio:**

   ```bash
   git clone https://github.com/tu_usuario/gutendex-book-search.git
   cd gutendex-book-search
   ```

2. **Importar el Proyecto:**

   - Abre el proyecto en tu IDE preferido (Eclipse, IntelliJ IDEA, etc.).

3. **Ejecutar la Aplicación:**

   - Ejecuta la clase `GutendexBookSearch.java` desde tu IDE.

## Uso

1. **Ejecución de la Aplicación:**

   - Al iniciar la aplicación, se te pedirá que ingreses el código de idioma (ES, EN, FR, PT).
   - La aplicación buscará automáticamente libros en el idioma especificado usando la API Gutendex.
   - Mostrará los detalles de los libros encontrados, evitando mostrar duplicados.

## Ejemplo de Código

```java
// Ejemplo de búsqueda de libros en español
public class GutendexBookSearch {
    // Implementación del código aquí
    // Consulta a la API, manejo de respuestas JSON, etc.
}
```

## Contribución

- Si deseas contribuir a este proyecto, sigue estos pasos:
  1. Haz un fork del repositorio.
  2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
  3. Realiza tus cambios y haz commit (`git commit -am 'Añadir nueva funcionalidad'`).
  4. Sube tus cambios (`git push origin feature/nueva-funcionalidad`).
  5. Haz un pull request en GitHub.
