Feature: Login functionality

  @Login
  Scenario Outline: Verify user login behavior on Swag Labs system
    Given the User is on the Swag Labs login page
    When the User enters "<username>" into the username field
    And the User enters "<password>" into the password field
    And the User clicks on the Login button
    Then the User should see "<expected_result>"

    Examples:
      | username      | password     | expected_result                 |
      | standard_user | secret_sauce | redirected to the products page |