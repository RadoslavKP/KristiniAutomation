package stepDefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import modules.KristiniModule;
import org.example.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import pages.KristiniPage;

public class KristiniSteps {

    private final KristiniModule kristiniModule;

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

    @When("The user navigate to Sub-Category {string}")
    public void navigateToSubCategoryFromPLP(String subCategory) {
        kristiniModule.navigateToSubCategoryFromPLP(subCategory);
    }

    @When("The user open product with name {string}")
    public void openSpecificProductFromPLP(String productName) {
        kristiniModule.openSpecificProductFromPLP(productName);
    }

    @When("Verify PDP is opened")
    public void verifyPDPIsLoaded() {
        kristiniModule.verifyPDPIsLoaded();
    }

    @When("The user clicks on the {int} image on Gallery page")
    public void clickImageOnGalleryPage(int imageNumber) {
        kristiniModule.clickImageOnGalleryPage(imageNumber);
    }

    @When("The user clicks on {string} photo slider arrow and verify new image is displayed")
    public void clickPhotoGalleryArrow(String arrowDirection) {
        kristiniModule.clickPhotoGalleryArrow(arrowDirection);
    }

    @Then("The user closes the Gallery full screen image")
    public void closeGalleryFullScreenImage() {
        kristiniModule.closeGalleryFullScreenImage();
    }
}
