Feature: Sign In Functionality

  Scenario: User signs in with empty password
    Given the user is on the sign-in page
    When the user enters a valid username and leaves the password field empty
    And clicks on the sign-in button
    Then the user should not be signed in