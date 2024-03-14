package stepDefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import modules.KristiniModule;
import org.example.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import pages.KristiniPage;

public class KristiniSteps {

    private KristiniModule kristiniModule;

    public KristiniSteps() {
        WebDriver webDriver = WebDriverFactory.getWebDriver();
        KristiniPage kristiniPage = new KristiniPage(webDriver);
        this.kristiniModule = new KristiniModule(kristiniPage);
    }

    @When("The user navigates to {string} from the Navigation Menu")
    public void navigateToStringFromNavigationMenu(String categoryTitle) {
        kristiniModule.navigateToStringFromNavigationMenu(categoryTitle);
    }

    @Then("Verify {string} page is loaded")
    public void verifySpecificPageIsLoaded(String pageName) {
        kristiniModule.verifySpecificPageIsLoaded(pageName);
    }
}
