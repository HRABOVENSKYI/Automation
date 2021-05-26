package pageobject.pages;

import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class AppleStorePage extends BasePage {

    public static final String IPHONE_BUTTON = "//div[@class='brand-box__info']//a[text()='iPhone']";

    public AppleStorePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnIPhoneButton() {
        driver.findElement(xpath(IPHONE_BUTTON)).click();
    }
}
