package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.BaseClass;

public class FormSubmittedResultPage extends BaseClass {

    public static By textInput = By.xpath("//h1");
    public static By successMessage = By.id("message");

    public void validateSuccessMessage(String expectedMessage) {
        String actualMessage = getDriver().findElement(successMessage).getText();

        //Added explicit wait to make sure element visible before validating the message
        BaseClass.waitForElementToBeDisplayed(textInput, 45);
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
