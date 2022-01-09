package co.com.client.webproject.test.page.contactenos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateMessageContactUs {



    @CacheLookup
    @FindBy(xpath = "//option[@value='2']")
    WebElement customerService;

    @CacheLookup
    @FindBy(id = "email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "message")
    WebElement messageContacUS;

    @CacheLookup
    @FindBy(id = "submitMessage")
    WebElement buttonSend;



    public WebElement getCustomerService () {
        return customerService;
    }

    public WebElement getEmail () {
        return email;
    }

    public WebElement getMessageContacUS () {
        return messageContacUS;
    }

    public WebElement getButtonSend () {
        return buttonSend;
    }

    public CreateMessageContactUs (WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
}
