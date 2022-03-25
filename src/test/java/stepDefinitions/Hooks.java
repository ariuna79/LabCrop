package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {



    @Before
    public void setUp() throws InterruptedException  {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @After
    public void tearDown(Scenario scenario) throws InterruptedException { 
        // only takes a screenshot if the scenario fails
        if (scenario.isFailed()) {
            // taking a screenshot
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            // adding the screenshot to the report
            scenario.embed(screenshot, "image/png");
        }
        Thread.sleep(5000);
        Driver.closeDriver();
    }
} 

