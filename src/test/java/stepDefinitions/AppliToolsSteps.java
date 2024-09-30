package stepDefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import modules.AppliToolsModule;
import org.example.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import pages.AppliToolsPage;

public class AppliToolsSteps {

    private final AppliToolsModule appliToolsModule;

    public AppliToolsSteps() {
        WebDriver webDriver = WebDriverFactory.getWebDriver();
        AppliToolsPage appliToolsPage = new AppliToolsPage(webDriver);
        this.appliToolsModule = new AppliToolsModule(appliToolsPage);
    }

    @When("The user enables AppliTools Eyes connection")
    public void connectToAppliTools() {
        appliToolsModule.connectToAppliTools();
    }

    @Then("The user ends the AppliTools Eyes connection")
    public void dissconectFromAppliTools() {
        appliToolsModule.dissconectFromAppliTools();
    }

    @When("The user starts Visual Test with config - {string} {string} {int} {int}")
    public void startVisualTest(String appName, String testName,int width, int height) {
        appliToolsModule.startVisualTest(appName, testName, width, height);
    }

}
