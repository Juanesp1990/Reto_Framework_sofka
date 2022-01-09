package co.com.client.webproject.test.controllers.carrocompras;

import co.com.client.webproject.test.page.carrito.SelectProduct;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class SelectProductWebController {

    private WebAction webAction;

    public void setWebAction (WebAction webAction) {
        this.webAction = webAction;
    }

    public void seleccionarProductos(){
        try{
            SelectProduct selectProduct = new SelectProduct(webAction.getDriver());
            webAction.click(selectProduct.getButtonDresses(),3,true);
            webAction.moveTo(selectProduct.getProduct(),5,true);
            webAction.click(selectProduct.getButtonAdd(),5,true);
            webAction.click(selectProduct.getButtonProceed(),5,true);
            webAction.click(selectProduct.getButtonContinue(),5,true);

        }catch (WebActionsException e){
            Report.reportFailure("Error seleccionando los productos");

        }
    }
}
