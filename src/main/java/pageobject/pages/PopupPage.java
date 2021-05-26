package pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopupPage extends BasePage {

    @FindBy(xpath = "//a[@class='sidebar-item']//span[text()='Apple Store']")
    private WebElement appleStoreButton;

    public PopupPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAppleStoreButton() {
        appleStoreButton.click();
    }
}
