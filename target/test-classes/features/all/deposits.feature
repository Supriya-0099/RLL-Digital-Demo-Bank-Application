Feature: Testing dbankdemo Deposit into Account feature

  Scenario: Testing Deposit into Account
    Given User is on Deposit page
    When Validating Reset button
    Then Validating Submit button with no data
    And Validating Submit button with Amount field as zero
    Then Validating succesful deposit transaction with valid credentials
    