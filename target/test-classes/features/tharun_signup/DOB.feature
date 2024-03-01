Feature: User Signup  

  Scenario: Signup with invalid DOB
    Given I am on the signup page
    When I fill in the signup form with a invalid date of birth
    And I click the next button
    Then I should see an error message indicating please match the requested format