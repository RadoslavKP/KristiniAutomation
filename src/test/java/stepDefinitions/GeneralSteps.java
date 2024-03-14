package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.example.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class GeneralSteps {
    private WebDriver webDriver;
    private KristiniSteps kristiniSteps;

    @Before
    public void setUp(){
        webDriver = WebDriverFactory.getWebDriver();
        kristiniSteps = new KristiniSteps();
    }

    @After
    public void tearDown (){
        WebDriverFactory.quitWebDriver();
    }

    @Given("The user navigates to {string} URL")
    public void the_user_navigates_to_url(String url) {
        webDriver.navigate().to(url);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
}
