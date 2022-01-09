package co.com.client.webproject.test.page.carrito;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectProduct {
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]")
    WebElement buttonDresses;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-container']")
    WebElement product;



    @CacheLookup
    @FindBy(xpath = "//a[@title='Add to cart']")
    WebElement buttonAdd;

    @CacheLookup
    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement buttonProceed;

    @CacheLookup
    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
    WebElement buttonContinue;

    public WebElement getButtonDresses () {
        return buttonDresses;
    }

    public WebElement getProduct () {
        return product;
    }

    public WebElement getButtonAdd () {
        return buttonAdd;
    }

    public WebElement getButtonProceed () {
        return buttonProceed;
    }

    public WebElement getButtonContinue () {
        return buttonContinue;
    }

    public SelectProduct (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
