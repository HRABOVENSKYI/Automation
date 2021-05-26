package pageobject.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTest {

    public static final String SEARCH_INPUT = "iPhone 11";
    public static final String EXPECTED_SEARCH_QUERY = "query=iPhone+11";
    private static final String THIRTEENTH_ELEMENT_XPATH = "(//div[@class='prod-cart__descr'])[13]";
    private static final String TWENTY_FIFTH_ELEMENT_XPATH = "(//div[@class='prod-cart__descr'])[25]";
    private static final String THIRTY_SEVENTH_ELEMENT_XPATH = "(//div[@class='prod-cart__descr'])[37]";

    @Test
    public void checkThatUrlContainsSearchWord() {
        getHomePage().searchByKeyword(SEARCH_INPUT);
        assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_SEARCH_QUERY));
    }

    @Test
    public void checkElementsAmountOnSearchPages() {
        getHomePage().searchByKeyword(SEARCH_INPUT);

        // first page
        assertEquals(getSearchResultPage().getSearchResultCount(), 12);

        // second page
        getSearchResultPage().goToSecondSearchResultPage();
        assertEquals(getSearchResultPage().getSearchResultCount(), 12);

        // third page
        getSearchResultPage().goToThirdSearchResultPage();
        assertEquals(getSearchResultPage().getSearchResultCount(), 12);
    }

    @Test
    public void checkElementsAmountAfterClickingOnShowTwelveMoreElements() throws InterruptedException {
        getHomePage().searchByKeyword(SEARCH_INPUT);

        // After first click
        getSearchResultPage().showMoreElements();
        getSearchResultPage().waitUntilElementAppears(10, THIRTEENTH_ELEMENT_XPATH);
        assertEquals(getSearchResultPage().getSearchResultCount(), 24);

        // After second click
        getSearchResultPage().showMoreElements();
        getSearchResultPage().waitUntilElementAppears(10, TWENTY_FIFTH_ELEMENT_XPATH);
        assertEquals(getSearchResultPage().getSearchResultCount(), 36);

        // After third click
        getSearchResultPage().showMoreElements();
        getSearchResultPage().waitUntilElementAppears(10, THIRTY_SEVENTH_ELEMENT_XPATH);
        assertEquals(getSearchResultPage().getSearchResultCount(), 48);
    }

    @Test
    public void checkThatSearchResultsContainsSearchWord() {
        getHomePage().searchByKeyword(SEARCH_INPUT);

        for (WebElement webElement : getSearchResultPage().getSearchResultList()) {
            assertTrue(webElement.getText().contains("iPhone 11"));
        }
    }
}
