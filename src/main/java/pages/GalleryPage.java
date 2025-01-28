package pages;

import org.example.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class GalleryPage {

    private final WebDriverFactory webDriverFactory;
    private final WebDriver webDriver;

    private static final By GALLERY_IMG_NUMBER = By.cssSelector(".modula-item-content");
    private static final By GALLERY_IMG_EXPANDED = By.cssSelector(".has-image.is-selected");
    private static final By GALLERY_ARROW_RIGHT_DIRECTION = By.cssSelector(".is-next");
    private static final By GALLERY_ARROW_LEFT_DIRECTION = By.cssSelector(".is-prev");
    private static final By GALLERY_IMAGE_FULL_SCREEN = By.cssSelector("div.fancybox__slide.has-image.is-selected.is-done div img");
    private static final By GALLERY_IMAGE_FULL_SCREEN_CLOSE_BTN = By.cssSelector(".f-button[title='Close'] svg");

    public GalleryPage() {
        this.webDriverFactory = new WebDriverFactory();
        this.webDriver = WebDriverFactory.getWebDriver();
    }

    public void clickImageOnGalleryPage(int imageNumber) {
        List<WebElement> images = webDriver.findElements(GALLERY_IMG_NUMBER);
        if (imageNumber > 0 && imageNumber <= images.size()) {
            images.get(imageNumber - 1).click();
            assertTrue(webDriverFactory.isElementDisplayed(GALLERY_IMG_EXPANDED));
        } else {
            System.out.println("Invalid Number parameter: " + imageNumber);
        }
    }

    public void clickPhotoGalleryArrow(String arrowDirection) {
        if (arrowDirection.equalsIgnoreCase("Right")) {
            WebElement rightGalleryButton = webDriver.findElement(GALLERY_ARROW_RIGHT_DIRECTION);
            rightGalleryButton.click();
        } else if (arrowDirection.equalsIgnoreCase("Left")){
            WebElement rightGalleryButton = webDriver.findElement(GALLERY_ARROW_LEFT_DIRECTION);
            rightGalleryButton.click();
        } else {
            throw new IllegalArgumentException("Invalid Arrow Direction Requested,Expected Input (Right/Left) Actual Input " + arrowDirection);
        }
    }

    public void closeGalleryFullScreenImage() {
        WebElement closeButton = webDriver.findElement(GALLERY_IMAGE_FULL_SCREEN_CLOSE_BTN);
        closeButton.click();
        assertFalse(webDriverFactory.isElementDisplayed(GALLERY_IMG_EXPANDED));
    }

}
