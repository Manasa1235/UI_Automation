
package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Utility class that encapsulates commonly used WebDriver actions.
 * Provides reusable methods for element interaction like click, input,
 * dropdown selection, and basic element state checks.
 */
public class CommonFunctions {

    WebDriver driver;

    /*--Initializes CommonFunctions with the provided WebDriver.--*/
    public CommonFunctions(WebDriver driver) {
        this.driver = driver;
    }

    /*--Clicks on the element specified by the locator.--*/
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    /*--Clears and types the given text into the specified input field.--*/
    public void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    /*--Selects an option from a dropdown using visible text.--*/
    public void selectByVisibleText(By locator, String text) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(text);
    }

    /*--Selects an option from a dropdown using the option value.--*/
    public void selectByValue(By locator, String value) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByValue(value);
    }

    /*--Selects an option from a dropdown using index.--*/
    public void selectByIndex(By locator, int index) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByIndex(index);
    }

    /*--Retrieves the visible text of the element.--*/
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    /*--Checks if the element is displayed on the page.--*/
    public boolean isElementDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

}
