package co.com.client.webproject.test.controllers.carrocompras;

import co.com.client.webproject.test.page.carrito.MakePurchase;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class MakePurchaseWebController {

    private WebAction webAction;

    public void setWebAction (WebAction webAction) {
        this.webAction = webAction;
    }

    public void confirmarOrden(){
        try {
            MakePurchase makePurchase = new MakePurchase(webAction.getDriver());
            webAction.click(makePurchase.getButtonProcessAddress(), 5, true);
            webAction.click(makePurchase.getButtonCheckbox(),5,true);
            webAction.click(makePurchase.getButtonProcessCarrier(),5,true);
            webAction.click(makePurchase.getButtonBank(),5,true);
            webAction.click(makePurchase.getButtonConfirmOrden(),5,true);
        }catch (WebActionsException e){
            Report.reportFailure("Erro confirmando la orden");

        }

    }
}
