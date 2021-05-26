package pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class SearchResultPage extends BasePage {

    private static final String SEARCH_RESULT_PRODUCT_LIST = "//div[@class='prod-cart__descr']";
    private static final String SECOND_SEARCH_RESULT_PAGE = "//li[@data-paginator='2']/a";
    private static final String THIRD_SEARCH_RESULT_PAGE = "//li[@data-paginator='3']/a";
    private static final String SHOW_MORE_ELEMENTS = "//a[@class='btn-see-more js_show_more']";

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSearchResultList() {
        return driver.findElements(xpath(SEARCH_RESULT_PRODUCT_LIST));
    }

    public int getSearchResultCount() {
        return getSearchResultList().size();
    }

    public void goToSecondSearchResultPage() {
        driver.findElement(xpath(SECOND_SEARCH_RESULT_PAGE)).click();
    }

    public void goToThirdSearchResultPage() {
        driver.findElement(xpath(THIRD_SEARCH_RESULT_PAGE)).click();
    }

    public void showMoreElements() {
        driver.findElement(xpath(SHOW_MORE_ELEMENTS)).click();
    }
}
