
Feature: Sign In Functionality

  Scenario: User signs in with invalid username
    Given the user is on the sign-in page
    When the user enters an invalid username and valid password
    And clicks on the sign-in button
    Then the user should not be signed in