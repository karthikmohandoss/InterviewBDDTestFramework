package utilities;

import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import pages.WebFormPage;

import java.time.Duration;
import java.util.Objects;
import java.util.Properties;

public class BaseClass {
    private static WebDriver driver;
    protected static Properties prop;
    public WebFormPage webFormPage;

    //Setup the driver and browser config
    @BeforeMethod(alwaysRun = true)
    public static void launchApplication() {
        loadConfig();
        driverSetUp();
        configBrowser();
    }

    public static void loadConfig() {
        try {
            prop = new Properties();
            prop.load(Objects.requireNonNull(BaseClass.class.getClassLoader().getResourceAsStream("config.properties")));
        } catch (Exception e){
            System.out.println("Loading properties file failed : "+ e.getMessage());
        }
    }

    private static WebDriver driverSetUp() {

        //This check is needed to run the test from TestRunner, else it will show null pointer exception
        String browser = Objects.requireNonNullElse(System.getProperty("browserName"), "chrome");
        String headless = Objects.requireNonNullElse(System.getProperty("headlessMode"), "false");

        if (headless.equals("true"))
            System.out.println("Ruuning tests against the "+browser+ " browser in headless mode.");
        else
            System.out.println("Ruuning tests against the "+browser+ " browser.");

        switch (browser.toLowerCase()) {
            case "chrome":
                if (headless.equals("true"))
                {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    driver = new ChromeDriver(options);
                }
                else
                    driver = new ChromeDriver();
                break;
            case "firefox":
                if (headless.equals("true"))
                {
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("--headless");
                    driver = new FirefoxDriver(options);
                }
                else
                    driver = new FirefoxDriver();
                break;
            case "edge":
                if (headless.equals("true"))
                {
                    EdgeOptions options = new EdgeOptions();
                    options.addArguments("headless");
                    driver = new EdgeDriver(options);
                }
                else
                    driver = new EdgeDriver();
                break;
        }
        return driver;
    }

    public static void configBrowser() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitwait"))));
        getDriver().manage().window().maximize();
        getDriver().get(prop.getProperty("url"));
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.out.println("Not intialised");
            throw new IllegalStateException("ActionDriver is not intialized");
        } else
            return driver;
    }

    public static WebElement SetAttribute(WebElement element, String attributeName, String attributeValue) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, attributeValue);
        return element;
    }

    protected static void sendKeys(By element, String text) {
        try {
            driver.findElement(element).clear();
            driver.findElement(element).sendKeys(text);
        } catch (Exception e) {
            System.out.println("Element not present: "+ e.getMessage());
        }
    }

    protected static void clickOnElement(By element) {
        try {
            driver.findElement(element).click();
        } catch (Exception e) {
            System.out.println("Element not present: "+ e.getMessage());
        }
    }

    protected static void waitForElementToBeDisplayed(By element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e) {
            System.out.println("Element not present: "+ e.getMessage());
        }
    }

    protected static void waitForElementToBeDisplayed(By element, int waitTime) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e) {
           System.out.println("Element not present: "+ e.getMessage());
        }
    }

    @After
    public void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}