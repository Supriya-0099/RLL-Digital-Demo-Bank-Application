 Feature: Sign In Functionality

  Scenario: User signs in with Remember Me option checked
    Given the user is on the sign-in page
    When the user enters valid username and password
    And checks the Remember Me option
    And clicks on the sign-in button
    Then the user should be successfully signed in