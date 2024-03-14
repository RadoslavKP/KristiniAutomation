package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static org.testng.Assert.*;

public class KristiniPage {

    private WebDriver webDriver;

    public KristiniPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void navigateToStringFromNavigationMenu(String categoryTitle){
        List<WebElement> links = webDriver.findElements(By.cssSelector("div[style=\"float:right; width:770px; margin-top:65px;\"] ul.main > li a"));
        for (WebElement link : links) {
            try {
                if (link.getText().toLowerCase().equals(categoryTitle.toLowerCase())) {
                    link.click();
                    Thread.sleep(5000);
                    return;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        throw new NoSuchElementException("Link with text '" + categoryTitle + "' not found in navigation menu.");
    }

    public void verifySpecificPageIsLoaded(String pageName){
        String pageTitleText = webDriver.getTitle().replaceAll(" - kristini-bg.com", "");
        assertEquals(pageTitleText, pageName);
    }
}
