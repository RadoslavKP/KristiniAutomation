package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.example.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GeneralSteps {
    private WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = WebDriverFactory.getWebDriver();
    }

    @After
    public void tearDown() {
        WebDriverFactory.quitWebDriver();
    }

    @Given("The user navigates to {string} URL")
    public void the_user_navigates_to_url(String url) {
        webDriver.get(url);
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body.home")));
    }
}
