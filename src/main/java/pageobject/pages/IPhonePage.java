package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.By.id;

public class IPhonePage extends BasePage {

    private static final String ADD_TO_CART_BUTTON = "//a[@class='prod-cart__buy'][contains(@data-ecomm-cart, 'Apple iPhone 12 Mini 64GB Black (MGDX3) (Open Box)')]";
    private static final String ADD_TO_CART_POPUP = "js_cart";
    private static final String CONTINUE_SHOPPING_BUTTON = "//div[@class='btns-cart-holder']//a[contains(@class,'btn--orange')]";
    private static final String CART_BUTTON = "//div[@class='header-bottom__right-icon']//i[@class='icon icon-cart-new']";

    public IPhonePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToCartButton() {
        driver.findElement(xpath(ADD_TO_CART_BUTTON)).click();
    }

    public By getAddToCartPopup() {
        return id(ADD_TO_CART_POPUP);
    }

    public void clickOnContinueShoppingButton() {
        driver.findElement(xpath(CONTINUE_SHOPPING_BUTTON)).click();
    }

    public void clickOnCartButton() {
        driver.findElement(xpath(CART_BUTTON)).click();
    }
}
