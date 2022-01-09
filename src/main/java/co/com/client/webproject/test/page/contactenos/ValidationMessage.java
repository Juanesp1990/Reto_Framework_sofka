package co.com.client.webproject.test.page.contactenos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationMessage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/ol/li")
    WebElement messageError;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    WebElement messageGod;

    public WebElement getMessageError () {
        return messageError;
    }

    public WebElement getMessageGod () {
        return messageGod;
    }

    public ValidationMessage (WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
}
