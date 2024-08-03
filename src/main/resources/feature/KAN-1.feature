Feature: Saucelab Demo E2E Scenario - Order Completion

  @E2E @OrderCompletion
  Scenario: Reset application and complete an order process successfully
    Given User is on the Saucelab product page logged in
    When User clicks on the Menu Button
    And User selects the Reset app state option
    And User adds a product to the cart
    Then User verifies the cart badge number increments by 1
    When User navigates to the cart page
    Then User confirms that the previously added product is in the cart
    When User proceeds to checkout
    And User enters first name into the Checkout First Name field
    And User enters last name into the Checkout Last Name field
    And User enters zip code into the Checkout Postal Code field
    And User clicks on the Continue button
    Then User verifies the total amount is displayed as $29.99
    When User clicks on the Finish button
    Then User verifies the order completion message "Thank you for your order!" is displayed