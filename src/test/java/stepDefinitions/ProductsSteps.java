package stepDefinitions;

import io.cucumber.java.en.When;
import modules.ProductsModule;
import pages.ProductsPage;

public class ProductsSteps {

    private final ProductsModule productsModule;

    public ProductsSteps() {
        this.productsModule = new ProductsModule(new ProductsPage());
    }

    @When("The user open product with name {string}")
    public void openSpecificProductFromPLP(String productName) {
        productsModule.openSpecificProductFromPLP(productName);
    }

    @When("Verify PDP is opened")
    public void verifyPDPIsLoaded() {
        productsModule.verifyPDPIsLoaded();
    }

    @When("Verify search page is loaded")
    public void verifySearchResultPageIsLoaded() {
        productsModule.verifySearchResultPageIsLoaded();
    }

}
