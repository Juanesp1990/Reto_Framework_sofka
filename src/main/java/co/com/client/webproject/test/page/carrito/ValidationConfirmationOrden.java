package co.com.client.webproject.test.page.carrito;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationConfirmationOrden {
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/p/strong")
    WebElement messageConfirmationOrden;

    public WebElement getMessageConfirmationOrden () {
        return messageConfirmationOrden;
    }

    public ValidationConfirmationOrden (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
