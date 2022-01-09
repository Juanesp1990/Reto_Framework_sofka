package co.com.client.webproject.test.stepdefinition;

import co.com.client.webproject.test.controllers.contactenos.ContactUsWebController;
import co.com.client.webproject.test.controllers.contactenos.CreateNewMessageWebContoller;
import co.com.client.webproject.test.controllers.contactenos.MessageBadWebController;
import co.com.client.webproject.test.controllers.contactenos.MessageGodWebController;
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

public class ContactenosStepsDefinitions extends GeneralSetup {

    private WebAction webAction;

    @Before
    public void setUp (Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("el cliente se encuentra en la página de inicio")
    public void elClienteSeEncuentraEnLaPaginaDeInicio () {
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

    @Cuando("el cliente navega hasta el formulario de contáctenos")
    public void elClienteNavegaHastaElFormularioDeContactenos () {
        try {
            ContactUsWebController contactUsWebController = new ContactUsWebController();
            contactUsWebController.setWebAction(webAction);
            contactUsWebController.irHaciaContacUs();
        } catch (Exception e) {
            Report.reportFailure("Error navegando hacia contactenos");
            Assertions.fail("");

        }

    }

    @Cuando("ingresa la información incompleta y presiona el botón enviar")
    public void ingresaLaInformacionIncompletaYPresionaElBotonEnviar () {
        try {
            CreateNewMessageWebContoller createNewMessageWebContoller = new CreateNewMessageWebContoller(webAction, false);
            createNewMessageWebContoller.crearUnNuevoMensaje();
        } catch (Exception e) {
            Report.reportFailure("Error enviando mensaje");
            Assertions.fail("");

        }
    }

    @Entonces("la página debería mostrar un mensaje de error")
    public void laPaginaDeberiaMostrarUnMensajeDeError () {
        try {
            MessageBadWebController messageBadWebController = new MessageBadWebController();
            messageBadWebController.setWebAction(webAction);

            Assert.Hard
                    .thatString(messageBadWebController.obtenerMensajeDeError())
                    .isEqualTo("The message cannot be blank.");
        } catch (Exception e) {
            Report.reportFailure("Error comparando el mensaje de respuesta");
            Assertions.fail("");

        }

    }


    @Dado("el clientre se encuentra en la página inicial")
    public void elClientreSeEncuentraEnLaPaginaInicial () {
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

    @Cuando("el cliente navega hasta la opción contáctenos")
    public void elClienteNavegaHastaLaOpcionContactenos () {
        try {
            ContactUsWebController contactUsWebController = new ContactUsWebController();
            contactUsWebController.setWebAction(webAction);
            contactUsWebController.irHaciaContacUs();
        } catch (Exception e) {
            Report.reportFailure("Error navegando hacia contactenos");
            Assertions.fail("");

        }

    }

    @Cuando("ingresa la información completa y presiona el botón enviar")
    public void ingresaLaInformacionCompletaYPresionaElBotonEnviar () {
        try {
            CreateNewMessageWebContoller createNewMessageWebContoller = new CreateNewMessageWebContoller(webAction, true);
            createNewMessageWebContoller.crearUnNuevoMensaje();
        } catch (Exception e) {
            Report.reportFailure("Error escribiendo el mensaje");
            Assertions.fail("");

        }

    }

    @Entonces("la página debería indicarle la recepción del mensaje")
    public void laPaginaDeberiaIndicarleLaRecepcionDelMensaje () {
        try {
            MessageGodWebController messageGodWebController = new MessageGodWebController();
            messageGodWebController.setWebAction(webAction);

            Assert.Hard
                    .thatString(messageGodWebController.obtenerMensajeDeCorrecto())
                    .isEqualTo("Your message has been successfully sent to our team.");
        } catch (Exception e) {
            Report.reportFailure("Error en la comparacion del mensaje de aceptacion");
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
