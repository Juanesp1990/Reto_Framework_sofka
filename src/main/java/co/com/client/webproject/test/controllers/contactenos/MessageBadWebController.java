package co.com.client.webproject.test.controllers.contactenos;

import co.com.client.webproject.test.page.contactenos.ValidationMessage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;


public class MessageBadWebController {
    private WebAction webAction;

    public void setWebAction (WebAction webAction) {
        this.webAction = webAction;
    }

    public String obtenerMensajeDeError(){
        String mensajeError="";
        try{
            ValidationMessage validationMessage=new ValidationMessage(webAction.getDriver());
            mensajeError=webAction.getText(validationMessage.getMessageError(),4,true);

        }catch (WebActionsException e){

            Report.reportFailure("Ocurrio un error al intentar capturar mensaje de error.", e);

        }
        return mensajeError;
    }
}
