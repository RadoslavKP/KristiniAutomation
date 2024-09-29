package pages;

import org.example.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

import static org.testng.Assert.*;

public class KristiniPage {

    private WebDriver webDriver;

    private static final By CATEGORY_LINKS = By.cssSelector(".header-bottom .menu-item");
    private static final By SUB_CATEGORY_LINKS = By.cssSelector(".category a");
    private static final By PRODUCT_TILES_NAME = By.cssSelector(".catalogItem strong");
    private static final By PDP_ITEM_DESCRIPTION = By.cssSelector(".itemDescription");
    private static final By GALLERY_IMG_NUMBER = By.cssSelector(".modula-item-content");
    private static final By GALLERY_IMG_EXPANDED = By.cssSelector(".has-image.is-selected");
    private static final By PAGE_TITLE = By.cssSelector(".section-title");

    public KristiniPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void navigateToStringFromNavigationMenu(String categoryTitle) {
        List<WebElement> links = webDriver.findElements((CATEGORY_LINKS));
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

    public void verifySpecificPageIsLoaded(String pageName) {
        String pageTitleText = webDriver.findElement(PAGE_TITLE).getText();
        assertTrue(pageTitleText.equalsIgnoreCase(pageName));
    }

    public void navigateToSubCategoryFromPLP(String subCategory) {
        List<WebElement> links = webDriver.findElements((SUB_CATEGORY_LINKS));
        for (WebElement link : links) {
            try {
                if (link.getText().toLowerCase().equals(subCategory.toLowerCase())) {
                    link.click();
                    Thread.sleep(5000);
                    return;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        throw new NoSuchElementException("Link with text '" + subCategory + "' not found in navigation menu.");
    }

    public void openSpecificProductFromPLP(String productName) {
        List<WebElement> products = webDriver.findElements((PRODUCT_TILES_NAME));
        for (WebElement product : products) {
            try {
                if (product.getText().toLowerCase().equals(productName.toLowerCase())) {
                    product.click();
                    Thread.sleep(5000);
                    return;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        throw new NoSuchElementException("Link with text '" + productName + "' not found in navigation menu.");
    }

    public void verifyPDPIsLoaded() {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        assertTrue(webDriverFactory.isElementDisplayed(PDP_ITEM_DESCRIPTION));
    }

    public void clickImageOnGalleryPage(int imageNumber) {
        List<WebElement> images = webDriver.findElements(GALLERY_IMG_NUMBER);
        WebDriverFactory webDriverFactory = new WebDriverFactory();

        if (imageNumber > 0 && imageNumber <= images.size()) {
            images.get(imageNumber - 1).click();
            assertTrue(webDriverFactory.isElementDisplayed(GALLERY_IMG_EXPANDED));
        } else {
            System.out.println("Invalid Number parameter: " + imageNumber);
        }

    }

}
