package pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//div[@class='prod-cart__descr']")
    private List<WebElement> searchResultProductList;

    @FindBy(xpath = "//li[@data-paginator='2']/a")
    private WebElement secondSearchResultPage;

    @FindBy(xpath = "//li[@data-paginator='3']/a")
    private WebElement thirdSearchResultPage;

    @FindBy(xpath = "//a[@class='btn-see-more js_show_more']")
    private WebElement showMoreElements;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSearchResultList() {
        return searchResultProductList;
    }

    public int getSearchResultCount() {
        return getSearchResultList().size();
    }

    public void goToSecondSearchResultPage() {
        secondSearchResultPage.click();
    }

    public void goToThirdSearchResultPage() {
        thirdSearchResultPage.click();
    }

    public void showMoreElements() {
        showMoreElements.click();
    }
}
