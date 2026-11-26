# demoblaze_web_serenity

Automatización web de https://www.demoblaze.com/ con **Serenity BDD 4.0.0**, Screenplay y Cucumber (Gherkin), pensada para correr en **Google Chrome en macOS**.

## Escenarios incluidos

| Feature | Escenario | Tags |
|---|---|---|
| `carrito_new.feature` | Agregar un producto al carrito de manera exitosa | `@CarritoNew @HappyPath` |
| `carrito_new.feature` | Verificar que el producto agregado aparece en el carrito | `@CarritoNew` |
| `compra_new.feature` | Realizar la compra de un producto de manera exitosa | `@CompraNew @HappyPath` |

No requieren usuario ni login: se navega como invitado en demoblaze.

## Requisitos (macOS)

1. **Java JDK 17**
   ```bash
   brew install openjdk@17
   ```
   Verificar: `java -version` (debe indicar 17).
2. **Maven 3.8+**
   ```bash
   brew install maven
   ```
   Verificar: `mvn -version`.
3. **Google Chrome** instalado en `/Applications`. Selenium Manager descarga el ChromeDriver compatible automáticamente (`autodownload = true` en `serenity.conf`), por lo que solo se necesita conexión a internet.
4. Un IDE (IntelliJ IDEA) con el JDK 17 configurado como SDK del proyecto.

## Versiones clave

| Componente | Versión |
|---|---|
| Serenity BDD (core, junit, cucumber, screenplay, screenplay-webdriver) | **4.0.0** |
| serenity-maven-plugin | **4.0.0** |
| JUnit | 4.13.2 |
| Java | 17 |

## Cómo ejecutar

Desde la carpeta raíz del proyecto, en la Terminal:

```bash
mvn clean verify
```

Se abre Chrome (modo incógnito, maximizado), se ejecutan los 3 escenarios y al terminar se genera el reporte.

Ejecutar solo un tag:

```bash
mvn clean verify -Dcucumber.filter.tags="@CarritoNew"
mvn clean verify -Dcucumber.filter.tags="@CompraNew"
mvn clean verify -Dcucumber.filter.tags="@HappyPath"
```

Ejecutar sin abrir ventana (headless):

```bash
mvn clean verify -Dheadless.mode=true
```

## Reporte Serenity

Al finalizar `mvn clean verify`, abrir:

```bash
open target/site/serenity/index.html
```

## Evidencias

Cada escenario guarda capturas de pantalla (`Paso 1`, `Paso 2`, ...) en la carpeta `evidencias/<fecha>_<nombre del escenario>/`.

## Estructura del proyecto

```
src
├── main/java/org/example
│   ├── Pages        → UI: locators (Targets) de la página
│   ├── Tasks        → acciones de negocio del actor (NavigateHome)
│   ├── Questions    → validaciones (alerta, carrito, confirmación de compra)
│   └── Utils        → Parameters, ScreenShot, WaitImplicitly, PreAndProsCondition (hooks)
└── test
    ├── java/org/example
    │   ├── RunnerTest.java       → runner (tags por defecto)
    │   └── StepDefinitions       → pasos Gherkin
    └── resources
        ├── features              → archivos .feature
        └── serenity.conf         → configuración de Chrome / Serenity
```

## Problemas frecuentes en Mac

- **`Unable to launch the chrome service` / versión de driver:** actualizar Chrome y volver a correr; Selenium Manager baja el driver correcto.
- **macOS bloquea chromedriver ("no se puede verificar el desarrollador"):** Ajustes del Sistema → Privacidad y seguridad → *Permitir de todos modos*, o `xattr -d com.apple.quarantine <ruta del chromedriver>`.
- **`release version 17 not supported`:** Maven usa otro JDK. Configurar `export JAVA_HOME=$(/usr/libexec/java_home -v 17)`.
