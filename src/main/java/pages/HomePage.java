
package pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.CommonFunctions;
import utility.TestLogger;

public class HomePage {
    WebDriver driver;
    CommonFunctions functions;

    By productsTitle = By.className("title");
    By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.xpath("//*[@data-test='shopping-cart-link']");
    By productInCart = By.xpath("//*[text()='Sauce Labs Backpack']");
    By cartItem = By.xpath("//*[@data-test='inventory-item']");
    By checkoutButton = By.id("checkout");
    By checkoutInfo = By.xpath("//*[@data-test='title' and text()='Checkout: Your Information']");
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By zipCode = By.id("postal-code");
    By continueButton = By.id("continue");
    By finishButton = By.id("finish");
    By completeOrder = By.xpath("//*[@data-test='complete-header']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.functions = new CommonFunctions(driver);
    }

    public boolean isProductsPageDisplayed() {
        return functions.isElementDisplayed(productsTitle);
    }

    public void clickOnAddToCartButton(){
        functions.click(addToCartButton);
    }

    public void addUserDetials(){
        functions.enterText(firstName,"Manasa");
        functions.enterText(lastName,"Subramanyam");
        functions.enterText(zipCode,"303");
        functions.click(continueButton);
    }

    public void placeValidOrder(){
        this.clickOnAddToCartButton();
        functions.click(cartIcon);
        if(functions.getText(productInCart).equals("Sauce Labs Backpack")){
            TestLogger.screenshot("Product is added to cart");
            functions.click(checkoutButton);
            this.addUserDetials();
            functions.click(finishButton);
            if(functions.getText(completeOrder).equals("Thank you for your order!")){
                TestLogger.log("Order is placed and received a message - Thank you for your order!");
            }else{
                TestLogger.log("Error - Order is not placed!");
            }
        }
        else{
            TestLogger.log("Product not added to cart..!!!");
        }
    }

    public boolean invalidOrder(){
        boolean flag= true;
        functions.click(cartIcon);
        TestLogger.screenshot("Cart Page");
        functions.click(checkoutButton);
        if(functions.isElementDisplayed(checkoutInfo)){
            TestLogger.screenshot("Navigated to checkout without adding any items");
            flag = false;
        }
        return flag;
    }

    public String verifyItemsInCart(){
        if (functions.isElementDisplayed(cartItem)) {
            TestLogger.log("No items in cart ");
            return "Yes";
        }else{
            return "No";
        }
    }
}
