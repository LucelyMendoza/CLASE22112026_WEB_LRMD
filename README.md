# EJERCICIO AUTOMATIZACIÓN WEB

Realizado por: Lucely Rubi Mendoza Deza

Automatización web de https://www.demoblaze.com/ con **Serenity BDD 4.0.0** (Cambiado en el pom.xml por problemas que se me presentaron en MAC), Screenplay y Cucumber (Gherkin).

## Escenarios incluidos

| Feature | Escenario | Tags |
|---|---|---|
| `carrito_new.feature` | Agregar un producto al carrito de manera exitosa | `@CarritoNew @HappyPath` |
| `carrito_new.feature` | Verificar que el producto agregado aparece en el carrito | `@CarritoNew` |
| `compra_new.feature` | Realizar la compra de un producto de manera exitosa | `@CompraNew @HappyPath` |

No requieren usuario ni login: se navega como invitado en demoblaze.


## Versiones necesarias

| Componente | Versión |
|---|---|
| Serenity BDD (core, junit, cucumber, screenplay, screenplay-webdriver) | **4.0.0** |
| serenity-maven-plugin | **4.0.0** |
| JUnit | 4.13.2 |
| Java | 17 |

## Cómo ejecutar

Desde la carpeta raíz del proyecto, en la Terminal:

```bash
mvn clean verify o mvn serenity:aggregate
```
Se abre Chrome (modo incógnito, maximizado), se ejecutan los 3 escenarios y al terminar se genera el reporte.

Ejecutar solo un tag:

```bash
mvn clean verify -Dcucumber.filter.tags="@CarritoNew"
mvn clean verify -Dcucumber.filter.tags="@CompraNew"
mvn clean verify -Dcucumber.filter.tags="@HappyPath"
```
## Reporte y resultados

1. **Test results**
   ```bash
   mvn serenity:aggregate
   ```
   Resultado general de los 3 escenarios especificados.
   ![Resultados](evidencias/vista1.png)
2. **Test completados exitosamente**
   ![Resultados](evidencias/vista3.png)
2. **Escenario 1 y 2: Agregar productos al carrito (carrito_new.feature)**
   ![Resultados](evidencias/vista4.png)
   ![Resultados](evidencias/vista6.png)
   ![Resultados](evidencias/vista7.png)
3. **Escenario 3:  Comprar producto del carrito (compra_new.feature)**
   ![Resultados](evidencias/vista5.png)
   ![Resultados](evidencias/vista9.png)

## Evidencias

Cada escenario guarda capturas de pantalla (`Paso 1`, `Paso 2`, ...) en la carpeta `evidencias`.

## Estructura del proyecto

```
src
├── main/java/org/example
│   ├── Pages        
│   ├── Tasks        
│   ├── Questions   
│   └── Utils        
└── test
    ├── java/org/example
    │   ├── RunnerTest.java 
    │   └── StepDefinitions
    └── resources
        ├── features
        └── serenity.conf
```

## Problemas que presneté en mac

- **`Unable to launch the chrome service` / versión de driver:** actualizar Chrome y volver a correr; Selenium Manager baja el driver correcto.
- Se tuvo que usar serenity en su versión 4 para correr el chrome drive en su versión de 158.