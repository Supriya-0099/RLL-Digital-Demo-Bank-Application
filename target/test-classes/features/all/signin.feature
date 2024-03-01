Feature: Sign In Functionality

  Scenario: User signs in with empty password
    Given the user is on the sign-in page
    When the user enters a valid username and leaves the password field empty
    And clicks on the sign-in button
    Then the user should not be signed in
    
    
	  Scenario: User signs in with empty username
    Given the user is on the sign-in page
    When the user leaves the username field empty and enters a valid password
    And clicks on the sign-in button
    Then the user should not be signed in
    
	  Scenario: User signs in with invalid password
    Given the user is on the sign-in page
    When the user enters a valid username and invalid password
    And clicks on the sign-in button
    Then the user should not be signed in
    
    
      Scenario: User signs in with invalid username
    Given the user is on the sign-in page
    When the user enters an invalid username and valid password
    And clicks on the sign-in button
    Then the user should not be signed in
    
      Scenario: User signs in with Remember Me option checked
    Given the user is on the sign-in page
    When the user enters valid username and password
    And checks the Remember Me option
    And clicks on the sign-in button
    Then the user should be successfully signed in
    
      Scenario: User signs in with valid credentials
    Given the user is on the sign-in page
    When the user enters valid username and password
    And clicks on the sign-in button
    Then the user should be successfully signed in