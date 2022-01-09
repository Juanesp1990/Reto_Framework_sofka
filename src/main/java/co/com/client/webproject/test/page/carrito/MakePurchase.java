package co.com.client.webproject.test.page.carrito;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MakePurchase {

    @CacheLookup
    @FindBy(xpath = "//button[@name='processAddress']")
    WebElement buttonProcessAddress;

    @CacheLookup
    @FindBy(id = "uniform-cgv")
    WebElement buttonCheckbox;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"form\"]/p/button")
    WebElement buttonProcessCarrier;

    @CacheLookup
    @FindBy(xpath= "//a[@class='bankwire']")
    WebElement buttonBank;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
    WebElement buttonConfirmOrden;

    public WebElement getButtonProcessAddress () {
        return buttonProcessAddress;
    }

    public WebElement getButtonCheckbox () {
        return buttonCheckbox;
    }

    public WebElement getButtonProcessCarrier () {
        return buttonProcessCarrier;
    }

    public WebElement getButtonBank () {
        return buttonBank;
    }

    public WebElement getButtonConfirmOrden () {
        return buttonConfirmOrden;
    }


   public MakePurchase ( WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
