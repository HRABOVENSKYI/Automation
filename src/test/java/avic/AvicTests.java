package avic;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.Keys.ENTER;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    @Test(enabled = false)
    public void checkThatUrlContainsSearchWord() {
        driver.findElement(xpath("//input[@id='input_search']")).sendKeys("iPhone 11", Keys.ENTER);
        assertTrue(driver.getCurrentUrl().contains("query=iPhone+11"));
    }

    @Test(enabled = false)
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

    @Test(enabled = false)
    public void checkElementsAmountAfterClickOnShowTwelveMoreElements() {
        driver.findElement(xpath("//input[@id='input_search']")).sendKeys("iPhone 11", Keys.ENTER);

        // After first click
        driver.findElement(xpath("//a[@class='btn-see-more js_show_more']")).click();
        // Wait for 13-th element to appear
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(xpath("(//div[@class='prod-cart__descr'])[13]")));
        List<WebElement> elementList1 = driver.findElements(xpath("//div[@class='prod-cart__descr']"));
        int actualElementSize1 = elementList1.size();
        assertEquals(actualElementSize1, 24);

        // After second click
        driver.findElement(xpath("//a[@class='btn-see-more js_show_more']")).click();
        // Wait for 25-th element to appear
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(xpath("(//div[@class='prod-cart__descr'])[25]")));
        List<WebElement> elementList2 = driver.findElements(xpath("//div[@class='prod-cart__descr']"));
        int actualElementSize2 = elementList2.size();
        assertEquals(actualElementSize2, 36);

        // After third click
        driver.findElement(xpath("//a[@class='btn-see-more js_show_more']")).click();
        // Wait for 37-th element to appear
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(xpath("(//div[@class='prod-cart__descr'])[37]")));
        List<WebElement> elementList3 = driver.findElements(xpath("//div[@class='prod-cart__descr']"));
        int actualElementSize3 = elementList3.size();
        assertEquals(actualElementSize3, 48);
    }

    @Test(enabled = false)
    public void checkThatSearchResultsContainsSearchWord() {
        driver.findElement(xpath("//input[@id='input_search']")).sendKeys("iPhone 11", ENTER);
        List<WebElement> elementList = driver.findElements(xpath("//div[@class='prod-cart__descr']"));
        for (WebElement webElement : elementList) {
            assertTrue(webElement.getText().contains("iPhone 11"));
        }
    }

    @Test
    public void checkAddToCart() {
        driver.findElement(xpath("//span[@class='sidebar-item']")).click();
        driver.findElement(xpath("//a[@class='sidebar-item']//span[text()='Apple Store']")).click();
        driver.findElement(xpath("//div[@class='brand-box__info']//a[text()='iPhone']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // works without this waiter
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(xpath("//a[@class='prod-cart__buy'][contains(@data-ecomm-cart, 'Apple iPhone 12 Mini 64GB Black (MGDX3) (Open Box)')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js_cart")));
        driver.findElement(xpath("//div[@class='btns-cart-holder']//a[contains(@class,'btn--orange')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(xpath("//div[@class='header-bottom__right-icon']//i[@class='icon icon-cart-new']")).click();
        List<WebElement> elementList = driver.findElements(xpath("//div[@class='cart-parent-limit']/*"));
        elementList.forEach(System.out::println);
        assertEquals(elementList.size(), 1);
    }

    @Test(enabled = false)
    public void checkIfAllLinksToPreviewImagesAreDifferent() {
        List<WebElement> elementList = driver.findElements(xpath("//div[@class='main-slider']//div[@class='swiper-wrapper']/div[contains(@class, 'swiper-slide')]/a/img"));

        List<String> linksToImages = new ArrayList<>();
        for (WebElement element : elementList) {
            linksToImages.add(element.getAttribute("data-src"));
        }

        // Hardcode first element because it is opened by default and we read another instead
        linksToImages.set(0, "https://avic.ua/assets/cache/sliders/1/dnipro-25-1031-299.png");

        Assert.assertTrue(areDistinct(linksToImages));
    }

    public boolean areDistinct(List<String> linksList) {
        Set<String> linksSet = new HashSet<>(linksList);
        return (linksSet.size() == linksList.size());
    }
}
