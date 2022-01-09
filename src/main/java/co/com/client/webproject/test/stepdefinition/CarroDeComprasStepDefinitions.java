package co.com.client.webproject.test.stepdefinition;

import co.com.client.webproject.test.controllers.CreateAnAccountWebController;
import co.com.client.webproject.test.controllers.LoginPageWebController;
import co.com.client.webproject.test.controllers.carrocompras.MakePurchaseWebController;
import co.com.client.webproject.test.controllers.carrocompras.MessageConfirmationOrden;
import co.com.client.webproject.test.controllers.carrocompras.SelectProductWebController;
import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import org.assertj.core.api.Assertions;

public class CarroDeComprasStepDefinitions extends GeneralSetup {
    private WebAction webAction;

    @Before
    public void setUp (Scenario scenario) {

        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());

    }

    @Dado("el cliente se encuentra en la página de automation")
    public void elClienteSeEncuentraEnLaPaginaDeAutomation () {
        try {
            StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
            startBrowserWebController.setBrowser(browser());
            startBrowserWebController.setWebAction(webAction);
            startBrowserWebController.setFeature(testInfo.getFeatureName());
            startBrowserWebController.abrirTiendaOnline();
        } catch (Exception e) {
            Report.reportFailure("Error abriendo el navegador");
            Assertions.fail("");

        }

    }

    @Cuando("el cliente navega hasta la opción Dresses, selecciona una prenda y llega al carrito")
    public void elClienteNavegaHastaLaOpcionDressesSeleccionaUnaPrendaYLlegaAlCarrito () {
        try {
            SelectProductWebController selectProductWebController = new SelectProductWebController();
            selectProductWebController.setWebAction(webAction);
            selectProductWebController.seleccionarProductos();
        } catch (Exception e) {
            Report.reportFailure("Error navegando a la opcion dresses");
            Assertions.fail("");

        }

    }

    @Cuando("se registra en la plataforma y concluye su compra")
    public void seRegistraEnLaPlataformaYConcluyeSuCompra () {
        try {
            CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
            createAnAccountWebController.setWebAction(webAction);
            createAnAccountWebController.crearUnaCuenta();

            MakePurchaseWebController makePurchaseWebController = new MakePurchaseWebController();
            makePurchaseWebController.setWebAction(webAction);
            makePurchaseWebController.confirmarOrden();
        } catch (Exception e) {
            Report.reportFailure("Error en el registro de usuario");
            Assertions.fail("");

        }

    }

    @Entonces("la página debería mostrar un mensaje orden completada")
    public void laPaginaDeberiaMostrarUnMensajeOrdenCompletada () {
        try {
            MessageConfirmationOrden messageConfirmationOrden = new MessageConfirmationOrden();
            messageConfirmationOrden.setWebAction(webAction);
            Assert.Hard
                    .thatString(messageConfirmationOrden.obtenerMensajeConfirmacion())
                    .isEqualTo("Your order on My Store is complete.");
        } catch (Exception e) {
            Report.reportFailure("Error en la visualziación del mensaje");
            Assertions.fail("");

        }

    }

    @Dado("el cliente se dirige a la página de automation")
    public void elClienteSeDirigeLaPaginaDeAutomation () {
        try {
            StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
            startBrowserWebController.setBrowser(browser());
            startBrowserWebController.setWebAction(webAction);
            startBrowserWebController.setFeature(testInfo.getFeatureName());
            startBrowserWebController.abrirTiendaOnline();
        } catch (Exception e) {
            Report.reportFailure("Error abriendo el navegador");
            Assertions.fail("");

        }

    }

    @Cuando("el cliente se registra en la página,")
    public void elClienteSeRegistraEnLaPagina () {
        try {
            LoginPageWebController loginPageWebController = new LoginPageWebController();
            loginPageWebController.setWebAction(webAction);
            loginPageWebController.irHaciaLoginPage();

            CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
            createAnAccountWebController.setWebAction(webAction);
            createAnAccountWebController.crearUnaCuenta();
        } catch (Exception e) {
            Report.reportFailure("Error en el registro");
            Assertions.fail("");

        }

    }

    @Cuando("selecciona una prenda y llega al carrito para concluir su compra")
    public void seleccionaUnaPrendaYLlegaAlCarritoParaConcluirSuCompra () {
        try {
            SelectProductWebController selectProductWebController = new SelectProductWebController();
            selectProductWebController.setWebAction(webAction);
            selectProductWebController.seleccionarProductos();

            MakePurchaseWebController makePurchaseWebController = new MakePurchaseWebController();
            makePurchaseWebController.setWebAction(webAction);
            makePurchaseWebController.confirmarOrden();
        } catch (Exception e) {
            Report.reportFailure("Error seleccionando las prendas");
            Assertions.fail("");

        }

    }

    @Entonces("la página debería mostrar la opción de confirmation orden")
    public void laPaginaDeberiaMostrarLaOpcionDeConfirmationOrden () {
        try {
            MessageConfirmationOrden messageConfirmationOrden = new MessageConfirmationOrden();
            messageConfirmationOrden.setWebAction(webAction);
            Assert.Hard
                    .thatString(messageConfirmationOrden.obtenerMensajeConfirmacion())
                    .isEqualTo("Your order on My Store is complete.");
        } catch (Exception e) {
            Report.reportFailure("Error en el mensaje de respuesta");
            Assertions.fail("");

        }

    }

    @After
    public void tearDowm () {
        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }


}
