package stepDefinitions;

import io.cucumber.java.en.Then;
import modules.AxeAccessibilityModule;

public class AxeAccessibilitySteps {
    private final AxeAccessibilityModule axeAccessibilityModule;

    public AxeAccessibilitySteps(AxeAccessibilityModule axeAccessibilityModule) {
        this.axeAccessibilityModule = axeAccessibilityModule;
    }

    @Then("The user scans the current page for accessibility violations using Axe")
    public void scanCurrentPageForViolationsWithAxe() {
        axeAccessibilityModule.scanCurrentPageForViolationsWithAxe();
    }

}
