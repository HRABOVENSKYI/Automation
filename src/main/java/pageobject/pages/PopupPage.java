package pageobject.pages;

import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class PopupPage extends BasePage {

    private static final String APPLE_STORE_BUTTON = "//a[@class='sidebar-item']//span[text()='Apple Store']";

    public PopupPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAppleStoreButton() {
        driver.findElement(xpath(APPLE_STORE_BUTTON)).click();
    }
}
