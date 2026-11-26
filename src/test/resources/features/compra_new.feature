Feature: Comprar un producto

  @CompraNew @HappyPath
  Scenario Outline: Realizar la compra de un producto de manera exitosa
    Given el usuario esta en la página de inicio
    And selecciona el producto "<producto>"
    And agrega el producto al carrito
    And acepta el mensaje de confirmacion
    And ingresa al carrito
    And selecciona el boton place order
    And ingresa los datos de compra nombre "<nombre>", pais "<pais>", ciudad "<ciudad>", tarjeta "<tarjeta>", mes "<mes>" y anio "<anio>"
    When selecciona el boton purchase
    Then el sistema muestra la confirmacion de compra "<mensaje>"
    Examples:
      | producto          | nombre | pais | ciudad | tarjeta          | mes | anio | mensaje                      |
      | Samsung galaxy s6 | Lucely | Peru | Arequipa   | 5111111111111111 | 12  | 2026 | Thank you for your purchase! |
