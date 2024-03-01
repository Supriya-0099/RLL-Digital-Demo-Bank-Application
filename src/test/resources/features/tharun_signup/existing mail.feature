Feature: User Signup

  Scenario: Signup with Existing Email
    Given I am on the signup page
    When I fill in the signup form with an existing email
    And I click the next button
    Then I should see an error message indicating An account is already registered with the email address provided