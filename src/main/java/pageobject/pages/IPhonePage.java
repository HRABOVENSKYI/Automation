package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.By.id;

public class IPhonePage extends BasePage {

    @FindBy(xpath = "//a[@class='prod-cart__buy'][contains(@data-ecomm-cart, 'Apple iPhone 12 Mini 64GB Black (MGDX3) (Open Box)')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='btns-cart-holder']//a[contains(@class,'btn--orange')]")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//div[@class='header-bottom__right-icon']//i[@class='icon icon-cart-new']")
    private WebElement cartButton;

    private static final String ADD_TO_CART_POPUP = "js_cart";

    public IPhonePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public By getAddToCartPopup() {
        return id(ADD_TO_CART_POPUP);
    }

    public void clickOnContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public void clickOnCartButton() {
        cartButton.click();
    }
}
