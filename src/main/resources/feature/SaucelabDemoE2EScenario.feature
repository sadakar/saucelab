Feature: Reset and complete order on Saucelab Demo

  @KAN-1 @Regression @Functionality
  Scenario: Verify the ability to reset the application, add an item to the cart, and complete the order
    Given User is on the Saucelab Demo login page
    And User has logged in with valid credentials
    When User clicks on the Menu Button
    And User selects the Reset App state option
    And User adds an item to the cart
    Then User sees the cart item count incremented by 1
    When User navigates to the Cart page
    Then User verifies the added item is present in the cart
    When User initiates the checkout process
    And User enters "John" as the first name on the Checkout page
    And User enters "Doe" as the last name on the Checkout page
    And User enters "12345" as the zip/postal code on the Checkout page
    And User clicks on the Continue Button
    Then User confirms the order summary total is "$29.99"
    When User finalizes the order by clicking the Finish Button
    Then User is presented with a confirmation message "Thank you for your order!"