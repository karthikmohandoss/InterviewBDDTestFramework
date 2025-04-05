package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = ("@regression"),
        features = "src/test/java/features",
        glue = {"StepDefinitions", "utilities"},
        plugin = {
                   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                 })

public class TestRunner extends AbstractTestNGCucumberTests {


}
