package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.WebDriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.sql.Timestamp;

public class Hooks {
    @Before
    public void setup() {
        WebDriverFactory.getWebDriver();
    }

    @AfterStep
    public void captureExceptionImage (Scenario scenario) {
        if (scenario.isFailed()){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeMilliSeconds = Long.toString(timestamp.getTime());

            byte[] screenshot = ((TakesScreenshot) WebDriverFactory.getWebDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",timeMilliSeconds);
        }
    }

    @After
    public void tearDown() {
        WebDriverFactory.quitWebDriver();
    }
}
