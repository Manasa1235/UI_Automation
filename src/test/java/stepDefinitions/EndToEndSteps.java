package stepDefinitions;

import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import utility.TestLogger;

/**
 * Step Definitions for End-To-End functionality.
 * Each method is mapped to a Gherkin step from the feature file.
 */
public class EndToEndSteps {

    public static WebDriver driver;
    HomePage homePage= new HomePage(LoginSteps.driver);
    Logger log = Logger.getLogger(LoginSteps.class);

    @When("User adds product to cart and place order")
    public void userAddsProductToCartAndPlaceOrder() {
        homePage.placeValidOrder();
        TestLogger.screenshot("Screenshot");
    }

    @When("User do not add product to cart and place order")
    public void userDoNotAddProductToCartAndPlaceOrder() {
        Assert.assertTrue(homePage.invalidOrder(), "Navigated to checkout without adding any items");
        TestLogger.screenshot("Navigated to checkout without adding any items");
    }
}
