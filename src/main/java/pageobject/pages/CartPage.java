package pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//div[@class='cart-parent-limit']/*")
    private List<WebElement> allCartElements;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getAllCartElements() {
        return allCartElements;
    }

    public int getAllCartElementsCount() {
        return getAllCartElements().size();
    }
}
