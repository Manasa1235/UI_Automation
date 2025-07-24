# author : Manasa
# Contains end to end testing scenarios

Feature: End to End Testing

  Background:
    Given user is on SauceDemo login page
    When user enters valid username "standard_user" and password "secret_sauce"
    And clicks on login button
    Then user should be navigated to homepage

  #Positive
  Scenario: Place an order with all valid details
    When User adds product to cart and place order

  #Negative
  Scenario: Place an order without adding product to cart
    When User do not add product to cart and place order
