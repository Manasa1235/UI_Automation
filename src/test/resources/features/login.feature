# Author : Manasa
# Contains scenarios related to login Page

Feature: Login

  #Positive
  Scenario Outline: Valid login
    Given user is on SauceDemo login page
    When user enters valid username "<username>" and password "<password>"
    And clicks on login button
    Then user should be navigated to homepage
  Examples:
    |username     |password    |
    |standard_user|secret_sauce|

  #Negative
  Scenario Outline: Invalid login
    Given user is on SauceDemo login page
    When user enters invalid username "<username>" and password "<password>"
    And clicks on login button
    Then login should fail and remain on login page
    Examples:
      |username     |password    |
      |standard|secret_sauce|

  #Negative
  Scenario Outline: Validate Locked out User
    Given user is on SauceDemo login page
    When user enters invalid username "<username>" and password "<password>"
    And clicks on login button
    Then login should fail and "<error_message>" should be displayed
    Examples:
      |username       |password    |error_message|
      |locked_out_user|secret_sauce|Epic sadface: Sorry, this user has been locked out.|
