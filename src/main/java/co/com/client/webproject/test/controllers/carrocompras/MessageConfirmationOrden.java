package co.com.client.webproject.test.controllers.carrocompras;

import co.com.client.webproject.test.page.carrito.ValidationConfirmationOrden;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class MessageConfirmationOrden {
    private WebAction webAction;

    public void setWebAction (WebAction webAction) {
        this.webAction = webAction;
    }

    public String obtenerMensajeConfirmacion(){
        String mensajeConfirmacion="";
        try{
            ValidationConfirmationOrden validationConfirmationOrden = new ValidationConfirmationOrden(webAction.getDriver());
            mensajeConfirmacion=webAction.getText(validationConfirmationOrden.getMessageConfirmationOrden(),5,true);
        }catch (WebActionsException e){
            Report.reportFailure("Error en la captura de mensaje de confirmación");

        }
        return mensajeConfirmacion;
    }
}
