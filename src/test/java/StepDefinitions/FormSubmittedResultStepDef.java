package StepDefinitions;

import io.cucumber.java.en.Then;
import pages.FormSubmittedResultPage;

public class FormSubmittedResultStepDef {

    public FormSubmittedResultPage formSubmittedResultPage = new FormSubmittedResultPage();

    @Then("a message {string} will be displayed")
    public void a_message_will_be_displayed(String expectedMessage) {
        formSubmittedResultPage.validateSuccessMessage(expectedMessage);
    }
}
