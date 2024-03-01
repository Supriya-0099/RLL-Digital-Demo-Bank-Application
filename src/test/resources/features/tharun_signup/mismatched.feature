Feature: User Signup
	Scenario: Signup with mismatched passwords
    Given I am on the signup page
    When I fill in the signup form with an mismatched passwords
    And I click the next button
    Then I should see an error message indicating passwords do not match