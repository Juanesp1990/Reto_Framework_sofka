# language: es
@FeatureName:Contactenos
Característica: Contáctenos
  yo como cliente quiero poder ingresar a la opción de
  contactenos para comunicarme con el departamento de
  compras de la empresa Automation Practice

  @ScenarioName:InformacionIncompleta
  Escenario: informacion incompleta
    Dado el cliente se encuentra en la página de inicio
    Cuando el cliente navega hasta el formulario de contáctenos
    Y ingresa la información incompleta y presiona el botón enviar
    Entonces la página debería mostrar un mensaje de error

  @ScenarioName:InformacionCompleta
  Escenario: informacion completa
    Dado el clientre se encuentra en la página inicial
    Cuando el cliente navega hasta la opción contáctenos
    Y ingresa la información completa y presiona el botón enviar
    Entonces la página debería indicarle la recepción del mensaje