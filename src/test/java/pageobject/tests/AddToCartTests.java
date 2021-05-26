package pageobject.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddToCartTests extends BaseTest {

    private static final int EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART = 1;

    @Test
    public void checkAddToCart() {
        getHomePage().clickOnCatalogueButton();
        getPopupPage().clickOnAppleStoreButton();
        getAppleStorePage().clickOnIPhoneButton();
        getIPhonePage().waitForPageLoadingComplete(10); // works without this waiter
        getIPhonePage().clickOnAddToCartButton();
        getIPhonePage().waitForVisibilityOfElement(10, getIPhonePage().getAddToCartPopup());
        getIPhonePage().clickOnContinueShoppingButton();
        getIPhonePage().implicitWaitForLoading(10);
        getIPhonePage().clickOnCartButton();
        assertEquals(getCartPage().getAllCartElementsCount(), EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART);
    }
}
