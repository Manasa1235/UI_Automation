
package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import org.apache.log4j.Logger;
import util.Hooks;
import utility.TestLogger;
import utility.WebDriverManager;

import java.util.HashMap;
import java.util.Map;

public class LoginSteps {
    public static WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    Logger log = Logger.getLogger(LoginSteps.class);

    @Given("user is on SauceDemo login page")
    public void user_is_on_login_page() {
        driver = WebDriverManager.getDriver();
        TestLogger.setDriver(driver);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        log.info("Navigated to SauceDemo login page");
    }

    @When("user enters valid username {string} and password {string}")
    public void user_enters_valid_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
//        log.info("Entered valid username and password");
        TestLogger.screenshot("Entered valid username and password");
    }

    @When("clicks on login button")
    public void clicks_login() {
        loginPage.clickLogin();
        log.info("Clicked on login button");
    }

    @Then("user should be navigated to homepage")
    public void user_should_be_navigated_to_homepage() {
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isProductsPageDisplayed());
//        log.info("Successfully landed on homepage");
    }

    @When("user enters invalid username {string} and password {string}")
    public void user_enters_invalid_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @Then("login should fail and remain on login page")
    public void login_should_fail() {

        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"));
//        log.info("Login failed as expected");
        TestLogger.screenshot("Entered invalid username and password");
        driver.quit();
    }

    @Then("login should fail and {string} should be displayed")
    public void loginShouldFailAndShouldBeDisplayed(String error_message) {
        Assert.assertTrue(loginPage.validateErrorMessage(error_message));
        TestLogger.screenshot("Screenshot:");
        driver.quit();
    }

    @When("User adds product to cart and place order")
    public void userAddsProductToCartAndPlaceOrder() {
        homePage.placeValidOrder();
        TestLogger.screenshot("Screenshot");
        driver.quit();
    }

    @When("User do not add product to cart and place order")
    public void userDoNotAddProductToCartAndPlaceOrder() {
        Assert.assertTrue(homePage.invalidOrder(),"Navigated to checkout without adding any items");
        TestLogger.screenshot("Navigated to checkout without adding any items");
    }
}
