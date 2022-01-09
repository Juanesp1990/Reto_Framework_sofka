# language: es

@FeatureName:CarroCompras
Característica: Carro de compras
  yo como cliente quiero poder ingresar a la página y comprar
  prendas de vestir de la empresa Automation Practice

  @ScenarioName:UsuarioNoRegistrado
  Escenario: Usuario no registrado
    Dado el cliente se encuentra en la página de automation
    Cuando el cliente navega hasta la opción Dresses, selecciona una prenda y llega al carrito
    Y se registra en la plataforma y concluye su compra
    Entonces la página debería mostrar un mensaje orden completada

  @ScenarioName:UsuarioRegistrado
  Escenario: Usuario esta registrado
    Dado el cliente se dirige a la página de automation
    Cuando el cliente se registra en la página,
    Y selecciona una prenda y llega al carrito para concluir su compra
    Entonces la página debería mostrar la opción de confirmation orden