package pageobject.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class HomePage extends BasePage {

    private static final String SEARCH_INPUT = "//input[@id='input_search']";
    private static final String PRODUCT_CATALOGUE_BUTTON = "//span[@class='sidebar-item']";
    private static final String PREVIEW_WEB_ELEMENT_LIST = "//div[@class='main-slider']//div[@class='swiper-wrapper']/div[contains(@class, 'swiper-slide')]/a/img";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(final String keyword) {
        driver.findElement(xpath(SEARCH_INPUT)).sendKeys(keyword, Keys.ENTER);
    }

    public void clickOnCatalogueButton() {
        driver.findElement(xpath(PRODUCT_CATALOGUE_BUTTON)).click();
    }

    public List<WebElement> getPreviewElements() {
        return driver.findElements(xpath(PREVIEW_WEB_ELEMENT_LIST));
    }
}
