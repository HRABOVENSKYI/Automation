package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitUntilElementAppears(int timeoutInSeconds, String elementXPath) {
        (new WebDriverWait(driver, timeoutInSeconds)).until(ExpectedConditions.presenceOfElementLocated(xpath(elementXPath)));
    }

    public void waitForPageLoadingComplete(long timeout) {
        new WebDriverWait(driver, timeout)
                .until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForVisibilityOfElement(long timeout, By locator) {
        (new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void implicitWaitForLoading(int timeoutInSeconds) {
        driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
    }
}
