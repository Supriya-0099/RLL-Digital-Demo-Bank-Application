Feature: Search by TRN no. on the View Savings Accounts
Scenario: Successful search by TRN no. on the View Savings Accounts
    Given I am on the sign in page-
    When I enter Username and password-
    Then I click on sign in button-
    When I click on Savings
    When Select View Savings
    Then Validate Search box with Amount
    And Validate Search box with negative TRN
    Then Validate Search box with category
    And Validate Search box with date