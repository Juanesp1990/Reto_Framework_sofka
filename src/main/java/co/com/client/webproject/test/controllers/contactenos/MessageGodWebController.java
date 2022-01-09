package co.com.client.webproject.test.controllers.contactenos;

import co.com.client.webproject.test.page.contactenos.ValidationMessage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class MessageGodWebController {
    private WebAction webAction;

    public void setWebAction (WebAction webAction) {
        this.webAction = webAction;

    }

    public String obtenerMensajeDeCorrecto () {
        String mensajeCorrecto = "";
        try {
            ValidationMessage validationMessage = new ValidationMessage(webAction.getDriver());
            mensajeCorrecto = webAction.getText(validationMessage.getMessageGod(), 4, true);

        } catch (WebActionsException e) {

            Report.reportFailure("Ocurrio un error al intentar capturar mensaje correcto.", e);

        }
        return mensajeCorrecto;
    }
}
