package pages;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.BaseClass;

import java.security.Key;

public class WebFormPage extends BaseClass {

    public static By headerText = By.xpath("//h1");
    public static By textInput = By.id("my-text-id");
    public static By password = By.name("my-password");
    public static By textarea = By.name("my-textarea");
    public static By disabledInput = By.name("my-disabled");
    public static By readOnlyInput = By.name("my-readonly");
    public static By dropDownSelect = By.name("my-select");
    public static By dropDownDataListInput = By.name("my-datalist");
    public static By dropDownDataList = By.id("my-options");
    public static By fileInput = By.name("my-file");
    public static By checkedCheckBox = By.id("my-check-1");
    public static By defaultCheckBox = By.id("my-check-2");
    public static By checkedRadioButton = By.id("my-radio-1");
    public static By defaultRadioButton = By.id("my-radio-2");
    public static By colorPicker = By.name("my-colors");
    public static By datePicker = By.name("my-date");
    public static By exampleRange = By.name("my-range");
    public static By submitButton = By.xpath("//button[@type='submit']");

    public void assertPageTitle(String pageTitle) {
        waitForElementToBeDisplayed(headerText);
        Assert.assertEquals(getDriver().getTitle(), pageTitle, "Page title is incorrect");
    }

    public void enterTextInput(String value) {
        sendKeys(textInput, value);
    }

    public void enterPassword(String value) {
        sendKeys(password, value);
    }

    public void enterTextArea(String value) {
        sendKeys(textarea, value);
    }

    public void selectOptionFromDropDownList(String value) {
        Select dropDownSelectElement = new Select(getDriver().findElement(dropDownSelect));
        dropDownSelectElement.selectByVisibleText(value);
    }

    public void selecValueFromDataList(String value) {
        getDriver().findElement(dropDownDataListInput).sendKeys(value);

        Actions action = new Actions(getDriver());
        WebElement element = getDriver().findElement(dropDownDataList);
        action.moveToElement(element).click();
    }

    public void uploadAFile(String filePath) {
        getDriver().findElement(fileInput).sendKeys(System.getProperty("user.dir")+"\\src\\test\\java\\testdata\\"+filePath);
    }

    public void uncheckTheCheckedCheckBox(String checkOrUnCheck) {
        clickOnElement(checkedCheckBox);
    }

    public void checkTheDefaultCheckBox(String checkOrUnCheck) {
        clickOnElement(defaultCheckBox);
    }

    public void selectDefalutRadioButtonOption(String checkOrUnCheck) {
        clickOnElement(defaultRadioButton);
    }

    public void selectAColor(String colorCode) {
        sendKeys(colorPicker, colorCode);
    }

    public void enterADate(String date) {
        sendKeys(datePicker, date);
    }

    public void selectRange(String rangeValue) throws InterruptedException {
         Actions action = new Actions(getDriver());
        WebElement element = getDriver().findElement(datePicker);
        action.moveToElement(element).sendKeys(Keys.TAB);

        element = getDriver().findElement(exampleRange);
        action.moveToElement(element).click();

        if (rangeValue.equals("Right"))
            action.sendKeys(Keys.ARROW_RIGHT);
        else if (rangeValue.equals("Left"))
            action.sendKeys(Keys.ARROW_LEFT);

        action.perform();
        Thread.sleep(5000);
    }

    public void assertStateOfDisabledField() {
        Assert.assertTrue(!getDriver().findElement(disabledInput).isEnabled(), "Field is enabled");
    }

    public void assertStateOfReadOnlyField() {
        Assert.assertNotNull(getDriver().findElement(readOnlyInput).getDomAttribute("readonly"), "Field state is not read only");
    }

    public void clickSubmitButton() {
        clickOnElement(submitButton);
    }
}
