package pageobject.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pageobject.pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {

    WebDriver driver;

    private static final String AVIC_URL = "https://avic.ua/ua/";

    @BeforeTest
    public void profileSetUp() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AVIC_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public AppleStorePage getAppleStorePage() {
        return new AppleStorePage(getDriver());
    }

    public IPhonePage getIPhonePage() {
        return new IPhonePage(getDriver());
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(getDriver());
    }

    public PopupPage getPopupPage() {
        return new PopupPage(getDriver());
    }

    public CartPage getCartPage() {
        return new CartPage(getDriver());
    }
}
