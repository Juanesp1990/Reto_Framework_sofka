package co.com.client.webproject.test.controllers.contactenos;

import co.com.client.webproject.test.models.ContacUs;
import co.com.client.webproject.test.page.contactenos.CreateMessageContactUs;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class CreateNewMessageWebContoller {

    private final WebAction webAction;

    private final boolean stateEscenario;


    public CreateNewMessageWebContoller (WebAction webAction, boolean stateEscenario) {
        this.webAction = webAction;
        this.stateEscenario = stateEscenario;
    }

    public void crearUnNuevoMensaje () {
        try {
            ContacUs contacUs = createConctacUS();
            CreateMessageContactUs createMessageContactUs = new CreateMessageContactUs(webAction.getDriver());
            webAction.click(createMessageContactUs.getCustomerService(), true);
            webAction.sendText(createMessageContactUs.getEmail(), contacUs.getEmail(), true);
            if (stateEscenario) {
                webAction.sendText(createMessageContactUs.getMessageContacUS(), contacUs.getMessage(), true);
            }
            webAction.click(createMessageContactUs.getButtonSend(), 5, true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al crear mensaje.", e);

        }

    }

    private ContacUs createConctacUS () {
        ContacUs contacUsNew = new ContacUs();
        contacUsNew.setMessage("No llegaron las tallas correctas para todas las prendas");
        contacUsNew.setEmail("vanessa123@gmail.com");
        return contacUsNew;
    }
}
