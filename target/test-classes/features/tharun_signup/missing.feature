Feature: User Signup

  Scenario: Signup with Missing Information
    Given I am on the signup page
    When I fill in the signup form with missing information and click next
    And I click the next button
    Then I should see error messages indicating please fill out this field
