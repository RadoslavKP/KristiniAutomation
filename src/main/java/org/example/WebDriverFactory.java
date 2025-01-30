package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class WebDriverFactory {
    private static WebDriver webDriver;
    WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60));

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            webDriver = new ChromeDriver(chromeOptions);
            webDriver.manage().window().maximize();
        }
        return webDriver;
    }

    public static void quitWebDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

    public boolean isElementPresented(final By locator) {
        return !findElements(locator).isEmpty();
    }

    public List<WebElement> findElements(By locator) {
        return webDriver.findElements(locator);
    }

    public WebElement findElement(By locator) {
        return webDriver.findElement(locator);
    }

    public boolean isElementDisplayed(final By locator) {
        return isElementPresented(locator) && findElement(locator).isDisplayed() &&
                findElement(locator).getSize().getHeight() > 0 &&
                findElement(locator).getSize().getWidth() > 0;
    }

    public boolean isElementSelected(final By locator) {
        return webDriver.findElement(locator).isSelected();
    }

    public boolean isElementSelected(final WebElement locator) {
        return locator.isSelected();
    }

    public void waitForElementToBeClickable(final By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementToBeClickable(final WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementToBeDisplayed(final By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToNotBeDisplayed(final By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForElementToSelected(final By locator) {
        wait.until(ExpectedConditions.elementToBeSelected(locator));
    }

    public void waitForElementToSelected(final WebElement locator) {
        wait.until(ExpectedConditions.elementToBeSelected(locator));
    }

}
