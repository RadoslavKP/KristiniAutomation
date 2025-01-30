package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modules.NavigationModule;

public class NavigationSteps {

    private final NavigationModule navigationModule;

    public NavigationSteps(NavigationModule navigationModule) {
        this.navigationModule = navigationModule;
    }

    @When("The user navigates to {string} from the Navigation Menu")
    public void navigateToMenuCategory(String categoryTitle) {
        navigationModule.navigateToMenuCategory(categoryTitle);
    }

    @When("The user navigate to Sub-Category {string}")
    public void navigateToSubCategoryFromPLP(String subCategory) {
        navigationModule.navigateToSubCategoryFromPLP(subCategory);
    }

    @Then("Verify {string} page is loaded")
    public void verifySpecificPageIsLoaded(String pageName) {
        navigationModule.verifySpecificPageIsLoaded(pageName);
    }

    @When("The user opens the Search bar")
    public void openSearchBar() {
        navigationModule.openSearchBar();
    }

    @When("The user types {string} in the Search bar and submits")
    public void searchTermAndSubmit(String searchTerm) {
        navigationModule.searchTermAndSubmit(searchTerm);
    }

}
