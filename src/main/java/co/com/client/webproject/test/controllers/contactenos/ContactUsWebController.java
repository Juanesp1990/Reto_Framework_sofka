package co.com.client.webproject.test.controllers.contactenos;

import co.com.client.webproject.test.page.LandingPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class ContactUsWebController {
    private WebAction webAction;

    public void setWebAction (WebAction webAction) {
        this.webAction = webAction;
    }

    public void irHaciaContacUs(){
        try{
            LandingPage landingPage = new LandingPage(webAction.getDriver());
            webAction.click(landingPage.getContacUS(), 2, true);
        } catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar ir a la página de Contactenos", e);
        }

    }
}
