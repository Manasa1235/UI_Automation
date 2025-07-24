#author : Manasa
Feature: End to End Testing

  Background:
    Given user is on SauceDemo login page
    When user enters valid username "standard_user" and password "secret_sauce"
    And clicks on login button
    Then user should be navigated to homepage


  Scenario: Place an order with all valid details
#    Given user is on SauceDemo login page
#    When user enters valid username "<username>" and password "<password>"
    When User adds product to cart and place order

#    Examples:
#      |username     |password    |
#      |standard_user|secret_sauce|

  Scenario: Place an order without adding product to cart
    When User do not add product to cart and place order
