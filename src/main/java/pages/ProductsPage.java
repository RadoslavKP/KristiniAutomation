package pages;

import org.example.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.NoSuchElementException;
import static org.testng.Assert.*;

public class ProductsPage {

    private final WebDriverFactory webDriverFactory;
    private final WebDriver webDriver;

    private static final By PRODUCT_TILES_NAME = By.cssSelector(".woocommerce-loop-product__link ");
    private static final By PDP_PRODUCT_IMAGE = By.cssSelector(".product .woocommerce-product-gallery");
    private static final By SEARCH_RESULT_PAGE = By.cssSelector(".search-results");

    public ProductsPage() {
        this.webDriverFactory = new WebDriverFactory();
        this.webDriver = WebDriverFactory.getWebDriver();
    }

    public void openSpecificProductFromPLP(String productName) {
        List<WebElement> products = webDriver.findElements((PRODUCT_TILES_NAME));
        for (WebElement product : products) {
                if (product.getText().equalsIgnoreCase(productName)) {
                    product.click();
                    webDriverFactory.waitForElementToBeDisplayed(PDP_PRODUCT_IMAGE);
                    return;
                } else
                    throw new NoSuchElementException("Link with text '" + productName + "' not found in navigation menu.");
        }
    }

    public void verifyPDPIsLoaded() {
        assertTrue(webDriverFactory.isElementDisplayed(PDP_PRODUCT_IMAGE));
    }

    public void verifySearchResultPageIsLoaded() {
        assertTrue(webDriverFactory.isElementDisplayed(SEARCH_RESULT_PAGE));
    }

}
