
Feature: Sign In Functionality

  Scenario: User signs in with invalid password
    Given the user is on the sign-in page
    When the user enters a valid username and invalid password
    And clicks on the sign-in button
    Then the user should not be signed in