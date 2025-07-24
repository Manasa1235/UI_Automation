package util;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import stepDefinitions.LoginSteps;
import utility.TestLogger;

import static stepDefinitions.LoginSteps.driver;

public class Hooks {
    public static Scenario currentScenario;

    @Before
    public void beforeScenario(Scenario scenario) {
        currentScenario = scenario;
        TestLogger.initScenario(scenario);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // This closes the browser after each scenario
        }
    }
}
