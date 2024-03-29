package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class WebDriverFactory {
    private static WebDriver webDriver;

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
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

    public boolean isElementPresented (final By locator) {
        return !findElements(locator).isEmpty();
    }

    public List<WebElement> findElements(By locator) {
        return webDriver.findElements(locator);
    }

    public WebElement findElement(By locator) {
        return webDriver.findElement(locator);
    }

    public boolean isElementDisplayed (final By locator) {
        return isElementPresented(locator) && findElement(locator).isDisplayed() &&
                findElement(locator).getSize().getHeight() > 0 &&
                findElement(locator).getSize().getWidth() > 0;
    }

}
