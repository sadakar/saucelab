Feature: Reset Application and Complete Order

  @Regression @Functionality
  Scenario: Successful order reset and completion
    Given User is logged in to the application
    When User clicks on the Menu Button
    And User clicks on Reset app button in the Menu
    And User clicks on {{Add To Cart}} button
    Then the item number in the cart should increment
    When User clicks on {{Cart Button}}
    Then the cart should display the selected item
    When User clicks on {{Checkout Button}}
    And User enters the first name into {{Checkout First Name}}
    And User enters the last name into {{Checkout Last Name}}
    And User enters the zip code into {{Checkout Postal Code}}
    And User clicks on {{Continue Button}}
    Then the text of {{Summary Total}} should be {{Total: $29.99}}
    When User clicks on {{Finish Button}}
    Then the text of {{Complete Order Header}} should be {{Thank you for your order!}}