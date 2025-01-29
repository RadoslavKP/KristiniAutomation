package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modules.ContactUsModule;

public class ContactUsSteps {

    private final ContactUsModule contactUsModule;

    public ContactUsSteps(ContactUsModule contactUsModule) {
        this.contactUsModule = contactUsModule;
    }

    @Then("Verify that the Contact Us form is loaded")
    public void theUserVerifiesThatTheContactUsFormIsLoaded() {
        contactUsModule.theUserVerifiesThatTheContactUsFormIsLoaded();
    }

    @When("The user submits the Contact Us Form")
    public void submitContactUsForm() {
        contactUsModule.submitContactUsForm();
    }

    @Then("Verify Contact Us validation is triggered for mandatory fields")
    public void verifyContactUsFieldValidation() {
        contactUsModule.verifyContactUsFieldValidation();
    }

    @When("The user populates the Contact Us form")
    public void populateContactUsForm() {
        contactUsModule.populateContactUsForm();
    }

    @Then("Verify Contact Us form is submitted")
    public void verifyContactUsIsSubmitted() {
        contactUsModule.verifyContactUsIsSubmitted();
    }

}
