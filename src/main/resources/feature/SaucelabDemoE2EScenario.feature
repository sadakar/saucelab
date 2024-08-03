Feature: Reset and Complete Order on Saucelab Demo App

  @Regression @Functionality
  Scenario: Reset the application state and successfully complete an order
    Given User is on the Saucelab Demo login page
    When User logs in with valid credentials
    And User navigates to the product page
    Then User should see the available products

    When User clicks on the Menu Button
    And User selects Reset App State option
    Then User should see that the application has been reset
    And User should see that the cart is empty

    When User adds a product to the cart
    Then User should see that the cart item count increments

    When User clicks on the Cart Button
    Then User should see the selected item in the cart

    When User clicks on the Checkout Button
    And User fills in the Checkout First Name with "John"
    And User fills in the Checkout Last Name with "Doe"
    And User fills in the Checkout Postal Code with "12345"
    And User clicks on the Continue Button
    Then User should see the order summary with a total of $29.99

    When User clicks on the Finish Button
    Then User should see the "Thank you for your order!" confirmation message