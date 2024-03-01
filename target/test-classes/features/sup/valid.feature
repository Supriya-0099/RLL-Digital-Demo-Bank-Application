
Feature: Sign In Functionality

  Scenario: User signs in with valid credentials
    Given the user is on the sign-in page
    When the user enters valid username and password
    And clicks on the sign-in button
    Then the user should be successfully signed in