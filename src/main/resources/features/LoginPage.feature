Feature: Login functionality

  @Login
  Scenario: Verify user login behavior on Swag Labs system
    Given the User is on the Swag Labs login page
    When the User enters "standard_user" into the username field
    And the User enters "secret_sauce" into the password field
    And the User clicks on the Login button
    Then the User should see "redirected to the products page"