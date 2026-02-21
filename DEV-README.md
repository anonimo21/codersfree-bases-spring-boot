# Desarrollo: recarga en caliente y Tailwind CSS

Este archivo resume cómo evitar recargar manualmente el navegador cuando desarrollas la aplicación Spring Boot con Thymeleaf y Tailwind CSS.

## Resumen

- Usar `spring-boot-devtools` para reinicio automático y LiveReload.
- Desactivar la caché de Thymeleaf para ver cambios en plantillas sin reiniciar.
- Ejecutar `npm run watch:css` para recompilar Tailwind automáticamente.
- Opcional: usar extensión LiveReload en el navegador o incluir el script `livereload.js` en desarrollo.

## Archivos clave

- `pom.xml`: incluye `spring-boot-devtools` (scope `runtime`).
- `src/main/resources/application.properties`: ajustes de desarrollo (ej.: `spring.thymeleaf.cache=false`).
- `package.json`: scripts `build:css` y `watch:css`.
- `src/main/resources/static/css/input.css`: entrada de Tailwind.

## Configuración recomendada (ya aplicada)

- `application.properties` (ejemplo):

```
spring.application.name=prueba
server.port=8081
spring.thymeleaf.cache=false
spring.devtools.restart.enabled=true
spring.devtools.livereload.enabled=true
```

- `package.json` (scripts relevantes):

```
"build:css": "tailwindcss -i ./src/main/resources/static/css/input.css -o ./src/main/resources/static/css/styles.css --minify",
"watch:css": "tailwindcss -i ./src/main/resources/static/css/input.css -o ./src/main/resources/static/css/styles.css --watch"
```

## Comandos útiles

- Instalar dependencias npm (solo la primera vez):

```bash
cd "prueba"
npm install --save-dev tailwindcss postcss autoprefixer
```

- Compilar CSS una vez:

```bash
npm run build:css
```

- Ejecutar el watch (recomendado en desarrollo):

```bash
npm run watch:css
```

- Ejecutar la app Spring Boot con Maven (verá cambios en templates y reinicios automáticos):

```bash
./mvnw spring-boot:run
```

## LiveReload en el navegador

- Opción 1 (recomendada): instalar una extensión LiveReload para tu navegador (Chrome/Firefox) y activarla cuando trabajes en la app. `spring-boot-devtools` envía el trigger.

- Opción 2 (solo desarrollo): incluir este script en tus plantillas al final del `body` para conectarte al servidor LiveReload:

```html
<!-- Sólo para desarrollo local -->
<script src="http://localhost:35729/livereload.js"></script>
```

> Nota: no incluyas el script en producción.

## Problemas comunes

- Tailwind reporta "No utility classes were detected" si `tailwind.config.cjs` no apunta correctamente a tus plantillas. Asegúrate de que `content` incluya `./src/main/resources/templates/**/*.html`.
- Si no ves recarga automática en el navegador: verifica que la extensión LiveReload esté activa o que `spring-boot-devtools` esté presente en `pom.xml` y que la app se esté ejecutando con Maven desde el código en desarrollo (no desde el JAR empaquetado en production).

## Estado actual en este proyecto

- Se añadió `spring-boot-devtools` al `pom.xml`.
- Se modificó `application.properties` para deshabilitar la caché de Thymeleaf y habilitar LiveReload.
- `npm run watch:css` fue iniciado en background para recompilar `styles.css` automáticamente.

Si quieres, puedo:

- añadir el snippet `livereload.js` automáticamente en las plantillas (solo en entorno dev), o
- configurar un `README` más largo con pasos para Windows/macOS y ejemplos adicionales.
