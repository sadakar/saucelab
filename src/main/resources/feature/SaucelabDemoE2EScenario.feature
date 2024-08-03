Feature: Saucelab Demo E2E scenario
  As a user of Saucedemo, I want to reset the application and complete an order so that I can test the end-to-end purchase functionality.

  @E2E @Order
  Scenario: Complete an order after resetting the application
    Given The user is logged on to the Saucedemo application
    When The user clicks on the Menu Button
    And The user clicks on Reset app button in the Menu
    And The user clicks on Add To Cart button
    And The user verifies that the item number increments in the cart
    And The user clicks on Cart Button
    And The user verifies there is a selected item in the cart
    And The user clicks on Checkout Button
    And The user enters the first name into Checkout First Name
    And The user enters the last name into Checkout Last Name
    And The user enters the zip code into Checkout Postal Code
    And The user clicks on Continue Button
    Then The user verifies that the text of Summary Total equals Total: $29.99
    And The user clicks on Finish Button
    And The user verifies that the text of Complete Order Header is Thank you for your order!