Feature: Complete Order Process in Saucelab Demo

  @Regression @Functionality
  Scenario: Reset the application and complete an order
    Given User has logged into the application
    When User clicks on the "Menu" button
    And User clicks on "Reset App State" in the menu
    And User clicks on "Add to Cart" button for an item
    Then The item count in the cart should increment
    When User clicks on the "Cart" button
    Then The cart should display the added item
    When User clicks on the "Checkout" button
    And User enters first name in the "First Name" field
    And User enters last name in the "Last Name" field
    And User enters postal code in the "Postal Code" field
    And User clicks on the "Continue" button
    Then The "Summary Total" should display "Total: $29.99"
    When User clicks on the "Finish" button
    Then The "Order Confirmation" message should read "THANK YOU FOR YOUR ORDER"