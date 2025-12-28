Feature: Product API lifecycle

  Scenario: Create and get a product
    Given usuario crea un nuevo producto
    When consulta el producto creado por id
    Then la informacion del producto debe ser correcta