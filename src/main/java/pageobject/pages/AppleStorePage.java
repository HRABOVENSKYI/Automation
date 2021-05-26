package pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppleStorePage extends BasePage {

    @FindBy(xpath = "//div[@class='brand-box__info']//a[text()='iPhone']")
    private WebElement iPhoneButton;

    public AppleStorePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnIPhoneButton() {
        iPhoneButton.click();
    }
}
