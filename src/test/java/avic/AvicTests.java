package avic;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.openqa.selenium.By.*;
import static org.openqa.selenium.Keys.ENTER;
import static org.testng.Assert.*;

public class AvicTests {

    private WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://avic.ua/");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void checkThatUrlContainsSearchWord() {
        driver.findElement(xpath("//input[@id='input_search']")).sendKeys("iPhone 11", Keys.ENTER);
        assertTrue(driver.getCurrentUrl().contains("query=iPhone+11"));
    }

    @Test
    public void checkElementsAmountOnSearchPages() {
        driver.findElement(xpath("//input[@id='input_search']")).sendKeys("iPhone 11", Keys.ENTER);

        // first page
        List<WebElement> elementList1 = driver.findElements(xpath("//div[@class='prod-cart__descr']"));
        int actualElementSize1 = elementList1.size();
        assertEquals(actualElementSize1, 12);

        // second page
        driver.findElement(xpath("//li[@data-paginator='2']/a")).click();
        List<WebElement> elementList2 = driver.findElements(xpath("//div[@class='prod-cart__descr']"));
        int actualElementSize2 = elementList2.size();
        assertEquals(actualElementSize2, 12);

        // third page
        driver.findElement(xpath("//li[@data-paginator='3']/a")).click();
        List<WebElement> elementList3 = driver.findElements(xpath("//div[@class='prod-cart__descr']"));
        int actualElementSize3 = elementList3.size();
        assertEquals(actualElementSize3, 12);
    }

    @Test
    public void checkElementsAmountAfterClickOnShowTwelveMoreElements() throws InterruptedException {
        driver.findElement(xpath("//input[@id='input_search']")).sendKeys("iPhone 11", Keys.ENTER);
        driver.findElement(xpath("//li[@data-paginator='2']/a")).click();

        // After first click
        driver.findElement(xpath("//a[@class='btn-see-more js_show_more']")).click();
        Thread.sleep(1500); // implicit and explicit wait doesn't work here
        List<WebElement> elementList1 = driver.findElements(xpath("//div[@class='prod-cart__descr']"));
        int actualElementSize1 = elementList1.size();
        assertEquals(actualElementSize1, 24);

        // After second click
        driver.findElement(xpath("//a[@class='btn-see-more js_show_more']")).click();
        Thread.sleep(1500); // implicit and explicit wait doesn't work here
        List<WebElement> elementList2 = driver.findElements(xpath("//div[@class='prod-cart__descr']"));
        int actualElementSize2 = elementList2.size();
        assertEquals(actualElementSize2, 36);

        // After third click
        driver.findElement(xpath("//a[@class='btn-see-more js_show_more']")).click();
        Thread.sleep(1500); // implicit and explicit wait doesn't work here
        List<WebElement> elementList3 = driver.findElements(xpath("//div[@class='prod-cart__descr']"));
        int actualElementSize3 = elementList3.size();
        assertEquals(actualElementSize3, 48);
    }

    @Test
    public void checkThatSearchResultsContainsSearchWord() {
        driver.findElement(xpath("//input[@id='input_search']")).sendKeys("iPhone 11", ENTER);
        List<WebElement> elementList = driver.findElements(xpath("//div[@class='prod-cart__descr']"));
        for (WebElement webElement : elementList) {
            assertTrue(webElement.getText().contains("iPhone 11"));
        }
    }

    @Test
    public void checkAddToCart() throws InterruptedException {
        driver.findElement(xpath("//span[@class='sidebar-item']")).click();
        driver.findElement(xpath("//a[@class='sidebar-item']//span[text()='Apple Store']")).click();
        driver.findElement(xpath("//div[@class='brand-box__info']//a[text()='iPhone']")).click();
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(xpath("//a[@class='prod-cart__buy'][contains(@data-ecomm-cart, 'Apple iPhone 12 Mini 64GB Black (MGDX3) (Open Box)')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js_cart")));
        driver.findElement(xpath("//div[@class='btns-cart-holder']//a[contains(@class,'btn--orange')]")).click();
        Thread.sleep(1000);
        String actualProductsCountInCart =
                driver.findElement(xpath("//div[contains(@class,'header-bottom__cart')]//div[contains(@class,'cart_count')]")).getText();
        assertEquals(actualProductsCountInCart, "1");
    }
}
