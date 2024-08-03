Feature: Saucelab Demo E2E scenario
  Reset the application and complete the order

  @KAN-1
  Scenario: Complete an order after resetting the application
    Given The user is logged in
    When The user clicks on the Menu Button
    And The user clicks on Reset app button in the Menu
    And The user clicks on Add To Cart button
    Then The item number increment in the cart is verified
    When The user clicks on Cart Button
    Then The selected item in the cart is verified
    When The user clicks on Checkout Button
    And The user enters first name into Checkout First Name
    And The user enters last name into Checkout Last Name
    And The user enters the zip code into Checkout Postal Code
    And The user clicks on Continue Button
    Then The text of Summary Total equals Total: $29.99 is verified
    When The user clicks on Finish Button
    Then The text of Complete Order Header is Thank you for your order is verified