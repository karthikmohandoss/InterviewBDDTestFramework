package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.WebFormPage;
import utilities.BaseClass;

import java.io.IOException;
import java.util.Map;

public class SubmitDataStepDef {

    public WebFormPage webFormPage = new WebFormPage();

    @Given("I open the application form")
    public void i_open_the_application_form() throws IOException {
        BaseClass.launchApplication();
    }


    @And("I validate the page title as {string}")
    public void iValidateThePageTitleAs(String pageTitle) {
        webFormPage.assertPageTitle(pageTitle);
    }

    @When("I enter all the details as below in the Web form")
    public void i_enter_all_the_details_as_below(Map<String, String> data) throws InterruptedException {
        webFormPage.enterTextInput(data.get("Text Input"));
        webFormPage.enterPassword(data.get("Password"));
        webFormPage.enterTextArea(data.get("Text Area"));
        webFormPage.selectOptionFromDropDownList(data.get("Dropdown Select"));
        webFormPage.selecValueFromDataList(data.get("Dropdown Datalist"));
        webFormPage.uncheckTheCheckedCheckBox(data.get("Checked checkbox"));
        webFormPage.checkTheDefaultCheckBox(data.get("Default checkbox"));
        webFormPage.selectDefalutRadioButtonOption(data.get("Default radio Button"));
        webFormPage.uploadAFile(data.get("Upload File"));
        webFormPage.selectAColor(data.get("Color picker"));
        webFormPage.enterADate(data.get("Date picker"));
        webFormPage.selectRange(data.get("Example Range"));
    }

    @And("I assert the state of the input field is set to disabled")
    public void iAssertTheStateOfTheInputFieldIsSetToDisabled() {
        webFormPage.assertStateOfDisabledField();
    }

    @And("I assert the state of the read only field is set to read only")
    public void iAssertTheStateOfTheReadOnlyFieldIsSetToReadOnly() {
        webFormPage.assertStateOfReadOnlyField();
    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        webFormPage.clickSubmitButton();
    }
}