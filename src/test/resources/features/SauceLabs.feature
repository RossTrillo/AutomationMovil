@LoginTest
Feature: Sauce Labs App

  @Login1
  Scenario: Login Ok
    Given ingreso al aplicativo de SauceLabs
    When inicio sesión con mi usuario "standard_user" y clave "secret_sauce"

  @Login2
  Scenario: Login 2 Ok
    Given ingreso al aplicativo de SauceLabs
    When ingreso el usuario "standard_user"
    And ingreso la clave "secret_sauce"
    And hago clic en LOGIN
    Then valido el login OK

  @AgregarProducto
  Scenario Outline: Agregar productos al carrito
    Given estoy en la aplicación de SauceLabs
   And valido que carguen correctamente los productos en la galería
    When agrego <UNIDADES> del siguiente producto "<PRODUCTO>"
    Then valido que el carrito de compra se actualice correctamente
    Examples:
      | PRODUCTO                        | UNIDADES |
      | Sauce Labs Backpack             | 1        |
      | Sauce Labs Bolt - T-Shirt       | 1        |
      | Sauce Labs Bike Light           | 2        |
