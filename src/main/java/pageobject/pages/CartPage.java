package pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class CartPage extends BasePage {

    private static final String ALL_CART_ELEMENTS_XPATH = "//div[@class='cart-parent-limit']/*";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getAllCartElements() {
        return driver.findElements(xpath(ALL_CART_ELEMENTS_XPATH));
    }

    public int getAllCartElementsCount() {
        return getAllCartElements().size();
    }
}
