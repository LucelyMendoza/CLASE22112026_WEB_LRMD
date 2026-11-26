Feature: Agregar productos al carrito

  @CarritoNew @HappyPath
  Scenario Outline: Agregar un producto al carrito de manera exitosa
    Given el usuario esta en la página de inicio
    And selecciona el producto "<producto>"
    When agrega el producto al carrito
    Then el sistema muestra un mensaje que contiene "<mensaje>"
    Examples:
      | producto         | mensaje       |
      | Samsung galaxy s6 | Product added |

  @CarritoNew
  Scenario Outline: Verificar que el producto agregado aparece en el carrito
    Given el usuario esta en la página de inicio
    And selecciona el producto "<producto>"
    And agrega el producto al carrito
    And acepta el mensaje de confirmacion
    When ingresa al carrito
    Then el carrito muestra el producto "<producto>"
    Examples:
      | producto   |
      | Nokia lumia 1520 |
