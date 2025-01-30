package pages;

import org.example.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.NoSuchElementException;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class NavigationPage {

    private final WebDriverFactory webDriverFactory;
    private final WebDriver webDriver;

    private static final By CATEGORY_LINKS = By.cssSelector(".header-bottom .menu-item");
    private static final By PAGE_TITLE = By.cssSelector("div h3.section-title");
    private static final By SUB_CATEGORY_LINKS = By.cssSelector(".category a");
    private static final By EXPAND_SUB_CATEGORY_LINKS = By.xpath("/html/body/div[1]/div/div/aside/section/div/ul/li/a/span");

    private static final By SEARCH_BOX = By.cssSelector("[class = 'search-box active']");
    private static final By SEARCH_ICON = By.cssSelector(".search-icon .fa-search");
    private static final By SEARCH_FIELD = By.cssSelector(".search-box .search-field");
    private static final By SEARCH_SUBMIT = By.cssSelector(".search-box [type = 'submit']");


    public NavigationPage() {
        this.webDriverFactory = new WebDriverFactory();
        this.webDriver = WebDriverFactory.getWebDriver();
    }

    public void navigateToMenuCategory(String categoryTitle) {
        List<WebElement> links = webDriverFactory.findElements(CATEGORY_LINKS);
        for (WebElement link : links) {
            if (link.getText().equalsIgnoreCase(categoryTitle)) {
                link.click();
                webDriverFactory.waitForElementToBeClickable(CATEGORY_LINKS);
                return;
            }
        }
        throw new NoSuchElementException("Link with text '" + categoryTitle + "' not found in navigation menu.");
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

    public void verifySpecificPageIsLoaded(String pageName) {
        String pageTitleText = webDriver.findElement(PAGE_TITLE).getText();
        assertTrue(pageTitleText.equalsIgnoreCase(pageName));
    }

    public void openSearchBar() {
        webDriver.findElement(SEARCH_ICON).click();
        assertTrue(webDriverFactory.isElementDisplayed(SEARCH_BOX));
    }

    public void typeInSearchTermInSearchBar(String pageName) {
        webDriver.findElement(SEARCH_FIELD).sendKeys(pageName);
    }

    public void submitSearch() {
        webDriver.findElement(SEARCH_SUBMIT).click();
        assertFalse(webDriverFactory.isElementDisplayed(SEARCH_BOX));
    }

}
