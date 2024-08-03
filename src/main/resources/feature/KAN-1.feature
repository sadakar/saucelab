@Regression @OrderProcess
Feature: Reset and Complete Order Workflow in Saucelab Demo

  In order to ensure a smooth purchase experience
  As a customer using the Saucelab Demo app
  I want to be able to reset the application, add items to my cart, and complete an order

  @KAN-1
  Scenario: Complete an order after resetting the application
    Given User is on the Saucelab product page
    When User clicks on the 'Reset App State' button
    And User adds a product to the cart
    Then User should see the cart badge indicating '1' item added
    When User navigates to the shopping cart
    Then User should see the added item listed in the cart
    When User clicks on the 'Checkout' button
    And User fills in the checkout information with the following details:
      | firstName | lastName | postalCode |
      | John      | Doe      | 12345      |
    And User clicks on the 'Continue' button
    And User clicks on the 'Finish' button
    Then User should see a confirmation message 'THANK YOU FOR YOUR ORDER'