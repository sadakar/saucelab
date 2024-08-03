Feature: Reset Application and Complete Order on SauceDemo

  @Regression @Functionality
  Scenario Outline: Complete an order on SauceDemo after resetting application state
    Given User is logged into SauceDemo with valid credentials
    When User navigates to the product page
    And User resets the application state
    And User adds a product to the cart
    And User navigates to the cart
    And User proceeds to checkout
    And User enters first name "<first_name>", last name "<last_name>", and postal code "<postal_code>"
    And User completes the purchase
    Then User should be presented with a confirmation message "Thank you for your order!"

    Examples:
      | first_name | last_name | postal_code |
      | John       | Doe       | 90210       |