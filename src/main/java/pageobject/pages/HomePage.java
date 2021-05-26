package pageobject.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id='input_search']")
    private WebElement searchInput;

    @FindBy(xpath = "//span[@class='sidebar-item']")
    private WebElement productCatalogueButton;

    @FindBy(xpath = "//div[@class='main-slider']//div[@class='swiper-wrapper']/div[contains(@class, 'swiper-slide')]/a/img")
    private List<WebElement> previewWebElementList;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword, Keys.ENTER);
    }

    public void clickOnCatalogueButton() {
        productCatalogueButton.click();
    }

    public List<WebElement> getPreviewElements() {
        return previewWebElementList;
    }
}
