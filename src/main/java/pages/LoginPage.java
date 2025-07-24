
package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.CommonFunctions;
import utility.TestLogger;

/**
 * Page Object for SauceDemo Login Page.
 * This class contains all element locators and logic
 * related to logging into the application.
 */
public class LoginPage {
    Logger log = Logger.getLogger(LoginPage.class);
    WebDriver driver;
    CommonFunctions functions;


    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    By error_message_path = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.functions = new CommonFunctions(driver);
    }

    public void enterUsername(String username) {
        functions.enterText(usernameField, username);
    }

    public void enterPassword(String password) {
        functions.enterText(passwordField, password);
    }

    public void clickLogin() {
        functions.click(loginButton);
    }

    public boolean validateErrorMessage(String error_message) {
        boolean flag = false;
        if (functions.isElementDisplayed(error_message_path)) {
            if (functions.getText(error_message_path).equals(error_message)) {
                TestLogger.log(error_message + " is displayed");
                log.info(error_message + " is displayed");
                flag = true;
            } else {
                TestLogger.log(error_message + " is not displayed");
                log.info(error_message + " is not displayed");
            }
        } else {
            TestLogger.log("Error message element is not displayed in path " + error_message_path);
            log.info("Error message element is not displayed in path " + error_message_path);
        }
        return flag;
    }
}
