package pages;

import org.example.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

import static org.testng.Assert.*;

public class KristiniPage {

    private final WebDriver webDriver;

    private static final By CATEGORY_LINKS = By.cssSelector(".header-bottom .menu-item");
    private static final By SUB_CATEGORY_LINKS = By.cssSelector(".category a");
    private static final By EXPAND_SUB_CATEGORY_LINKS = By.xpath("/html/body/div[1]/div/div/aside/section/div/ul/li/a/span");
    private static final By PRODUCT_TILES_NAME = By.cssSelector(".woocommerce-loop-product__link ");
    private static final By PDP_PRODUCT_IMAGE = By.cssSelector(".product .woocommerce-product-gallery");
    private static final By GALLERY_IMG_NUMBER = By.cssSelector(".modula-item-content");
    private static final By GALLERY_IMG_EXPANDED = By.cssSelector(".has-image.is-selected");
    private static final By GALLERY_ARROW_RIGHT_DIRECTION = By.cssSelector("button.f-button[title='Next'] path");
    private static final By GALLERY_ARROW_LEFT_DIRECTION = By.cssSelector("button.f-button[title='Previous'] path");
    private static final By GALLERY_IMAGE_FULL_SCREEN = By.cssSelector("div.fancybox__slide.has-image.is-selected.is-done div img");
    private static final By GALLERY_IMAGE_FULL_SCREEN_CLOSE_BTN = By.cssSelector(".f-button[title='Close'] svg");
    private static final By PAGE_TITLE = By.cssSelector(".section-title");

    public KristiniPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void navigateToStringFromNavigationMenu(String categoryTitle) {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        List<WebElement> links = webDriver.findElements((CATEGORY_LINKS));
        for (WebElement link : links) {
                if (link.getText().equalsIgnoreCase(categoryTitle)) {
                    link.click();
                    webDriverFactory.waitForElementToBeClickable(CATEGORY_LINKS);
                    return;
                }else
                    throw new NoSuchElementException("Link with text '" + categoryTitle + "' not found in navigation menu.");

        }
    }

    public void verifySpecificPageIsLoaded(String pageName) {
        String pageTitleText = webDriver.findElement(PAGE_TITLE).getText();
        assertTrue(pageTitleText.equalsIgnoreCase(pageName));
    }

    public void navigateToSubCategoryFromPLP(String subCategory) {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        List<WebElement> links = webDriver.findElements((SUB_CATEGORY_LINKS));
        WebElement expandOptions = webDriver.findElement(EXPAND_SUB_CATEGORY_LINKS);
        for (WebElement link : links) {
                if (link.getText().equalsIgnoreCase(subCategory)) {
                    expandOptions.click();
                    link.click();
                    webDriverFactory.waitForElementToBeClickable(SUB_CATEGORY_LINKS);
                    return;
                } else
                    throw new NoSuchElementException("Link with text '" + subCategory + "' not found in navigation menu.");
        }
    }

    public void openSpecificProductFromPLP(String productName) {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
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
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        assertTrue(webDriverFactory.isElementDisplayed(PDP_PRODUCT_IMAGE));
    }

    public void clickImageOnGalleryPage(int imageNumber) {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        List<WebElement> images = webDriver.findElements(GALLERY_IMG_NUMBER);
        if (imageNumber > 0 && imageNumber <= images.size()) {
            images.get(imageNumber - 1).click();
            assertTrue(webDriverFactory.isElementDisplayed(GALLERY_IMG_EXPANDED));
        } else {
            System.out.println("Invalid Number parameter: " + imageNumber);
        }
    }

    public void clickPhotoGalleryArrow(String arrowDirection) {
        WebElement displayedImage = webDriver.findElement(GALLERY_IMAGE_FULL_SCREEN);
        String beforeClick = displayedImage.getAttribute("src");
        if(arrowDirection.equalsIgnoreCase("Right")){
            WebElement rightArrow = webDriver.findElement(GALLERY_ARROW_RIGHT_DIRECTION);
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].setAttribute('tabindex', '0');", rightArrow);
            rightArrow.click();
            String afterRightClick = displayedImage.getAttribute("src");
            assert beforeClick != null;
            assertFalse(beforeClick.equalsIgnoreCase(afterRightClick));
        }else if (arrowDirection.equalsIgnoreCase("Left")){
            WebElement leftArrow = webDriver.findElement(GALLERY_ARROW_LEFT_DIRECTION);
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].setAttribute('tabindex', '0');", leftArrow);
            leftArrow.click();
            String afterLeftClick = displayedImage.getAttribute("src");
            assert beforeClick != null;
            assertFalse(beforeClick.equalsIgnoreCase(afterLeftClick));
        }else
            throw new IllegalArgumentException("Full screen gallery images arrows are not displayed!");
    }

    public void closeGalleryFullScreenImage() {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        WebElement closeButton = webDriver.findElement(GALLERY_IMAGE_FULL_SCREEN_CLOSE_BTN);
        closeButton.click();
        assertFalse(webDriverFactory.isElementDisplayed(GALLERY_IMG_EXPANDED));
    }

}
