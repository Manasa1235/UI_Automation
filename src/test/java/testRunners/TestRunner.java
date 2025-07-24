
package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * This runner integrates Cucumber with TestNG and uses the CucumberOptions
 * annotation to specify feature file locations, step definition packages,
 * and reporting plugins.
 */

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "util"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
