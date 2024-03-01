Feature: User Signup

Scenario Outline: Signup with Invalid information
#Given I am on the signup page
When I fill in the signup form with an invalid "<ssn>" or "<email>" or "<password>"
And I click the next button
Then I should see an error message for "<field>"
Examples:
      | ssn        | email          |    password   | field							 |
      | 4865421657 | asfd@gmail.com |    Demo@123   | ssn        			   |
      |  486461678 | asgmail.com    |   Demo@123    | emailAddress 			 |
      |  486461678 | asfd@gmail.com |   afgaDabx    | confirmPassword		 |
