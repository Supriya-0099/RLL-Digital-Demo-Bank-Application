Feature: User Signup  
	Scenario: Successful Signup 
    Given I am on the signup page 
    When I fill in the signup form with valid information 
    And I click the next button		
    Then I should be redirected to new form page	
    And I fill address, tick terms checkbox		
    And click on signup			
    Then I should be redirected to signin page