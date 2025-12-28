Feature: Contact Us Automation

  Scenario: Enviar formulario Contact Us exitosamente
    Given el usuario ingresa a Automation Exercise
    When navega al formulario Contact Us
    And completa el formulario con archivo adjunto
    Then valida el mensaje de éxito
    And regresa al Home