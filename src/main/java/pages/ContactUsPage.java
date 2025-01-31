package pages;

import org.example.RandomGenerators;
import org.example.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Arrays;
import java.util.List;
import static org.testng.Assert.assertTrue;

public class ContactUsPage {

    private final WebDriverFactory webDriverFactory;
    private final WebDriver webDriver;
    //Contact Us Selectors
    private static final By CONTACT_US_FORM = By.className("everest-forms");
    private static final By CONTACT_US_FORM_SUBMIT = By.cssSelector(".everest-forms-submit-button");
    private static final By CONTACT_US_NAME_FIELD = By.xpath("//label[span[text()='Име']]/following-sibling::input");
    private static final By CONTACT_US_EMAIL_FIELD = By.cssSelector(".evf-field-email [type = 'email']");
    private static final By CONTACT_US_TOPIC_FIELD = By.xpath("//label[span[text()='Тема']]/following-sibling::input");
    private static final By CONTACT_US_CHECKBOX = By.cssSelector(".choice-1 [type = 'checkbox']");
    private static final By CONTACT_US_SUCCESS_MESSAGE= By.className("everest-forms-notice");
    //Validation Selectors
    private static final By CONTACT_US_NAME_VALIDATION = By.xpath("//label[@id='evf-472-field_lVizlNhYus-1-error']");
    private static final By CONTACT_US_EMAIL_VALIDATION = By.cssSelector("[type = 'email'].evf-error");
    private static final By CONTACT_US_TOPIC_VALIDATION = By.xpath("//label[@id='evf-472-field_xJivsqAS2c-2-error']");
    //GDPR Popup Selectors
    private static final By CONTACT_US_GDPR_ACCEPT = By.className("moove-gdpr-infobar-allow-all");
    private static final By GDPR_BAR = By.className("moove-gdpr-info-bar-container");

    public ContactUsPage() {
        this.webDriverFactory = new WebDriverFactory();
        this.webDriver = WebDriverFactory.getWebDriver();
    }

    public void theUserVerifiesThatTheContactUsFormIsLoaded() {
        assertTrue(webDriverFactory.isElementDisplayed(CONTACT_US_FORM));
    }

    public void submitContactUsForm() {
        webDriverFactory.waitForElementToBeClickable(CONTACT_US_FORM_SUBMIT);
        webDriver.findElement(CONTACT_US_FORM_SUBMIT).click();
    }

    public void verifyContactUsFieldValidation() {
        List<By> validationFields = Arrays.asList(
                CONTACT_US_NAME_VALIDATION,
                CONTACT_US_EMAIL_VALIDATION,
                CONTACT_US_TOPIC_VALIDATION
        );
        for (By field : validationFields) {
            assertTrue(webDriverFactory.isElementDisplayed(field), "Validation field not displayed: " + field);
        }
    }

    public void populateContactUsForm() {
        webDriver.findElement(CONTACT_US_NAME_FIELD).sendKeys("Test Test");
        webDriver.findElement(CONTACT_US_EMAIL_FIELD).sendKeys(RandomGenerators.generateRandomEmail());
        webDriver.findElement(CONTACT_US_TOPIC_FIELD).sendKeys("Tested Topic 1");
    }

    public void checkTermsAndConditionsCheckbox() {
        closeGDPRBar();
        WebElement locator = webDriver.findElement(CONTACT_US_CHECKBOX);
        webDriverFactory.waitForElementToBeClickable(locator);
        locator.click();
        assertTrue(webDriverFactory.isElementSelected(locator));
    }

    public void verifyContactUsIsSubmitted() {
        webDriverFactory.waitForElementToNotBeDisplayed(CONTACT_US_FORM_SUBMIT);
        assertTrue(webDriverFactory.isElementDisplayed(CONTACT_US_SUCCESS_MESSAGE));
    }

    public void closeGDPRBar() {
        webDriverFactory.waitForElementToBeDisplayed(GDPR_BAR);
        webDriver.findElement(CONTACT_US_GDPR_ACCEPT).click();
    }

}
