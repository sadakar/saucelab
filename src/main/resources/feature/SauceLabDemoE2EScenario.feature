Feature: Complete Order Workflow on SauceLab Demo

  @Regression @Functionality
  Scenario: Complete an order in the SauceLab Demo application
    Given User is logged in and on the home page
    When User clicks on the "Menu" button
    And User clicks on "Reset app state" in the menu options
    And User clicks on "Add To Cart" button for a product
    Then The cart item count should increment appropriately
    When User clicks on the "Cart" button
    Then The cart should display the selected item
    When User clicks on the "Checkout" button
    And User enters "John" into the "First Name" field
    And User enters "Doe" into the "Last Name" field
    And User enters "12345" into the "Zip/Postal Code" field
    And User clicks on the "Continue" button
    Then The summary total should display "Total: $29.99"
    When User clicks on the "Finish" button
    Then The "Order Complete" header should display "Thank you for your order!"