Feature: Sign In Functionality

  Scenario: User signs in with empty username
    Given the user is on the sign-in page
    When the user leaves the username field empty and enters a valid password
    And clicks on the sign-in button
    Then the user should not be signed in