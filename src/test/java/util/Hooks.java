package util;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utility.TestLogger;

import java.util.logging.Level;
import java.util.logging.Logger;

import static stepDefinitions.LoginSteps.driver;

public class Hooks {
    public static Scenario currentScenario;

    @Before
    public void beforeScenario(Scenario scenario) {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
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
