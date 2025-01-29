package modules;

import pages.ContactUsPage;

public class ContactUsModule {
    private final ContactUsPage contactUsPage;

    public ContactUsModule(ContactUsPage contactUsPage) {
        this.contactUsPage = contactUsPage;
    }

    public void theUserVerifiesThatTheContactUsFormIsLoaded() {
        contactUsPage.theUserVerifiesThatTheContactUsFormIsLoaded();
    }

    public void submitContactUsForm() {
        contactUsPage.submitContactUsForm();
    }

    public void verifyContactUsFieldValidation() {
        contactUsPage.verifyContactUsFieldValidation();
    }

    public void populateContactUsForm() {
        contactUsPage.populateContactUsForm();
        contactUsPage.checkTermsAndConditionsCheckbox();
    }

    public void verifyContactUsIsSubmitted() {
        contactUsPage.verifyContactUsIsSubmitted();
    }

}
