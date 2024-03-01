Feature: User Signup

  Scenario: Signup with invalid DOB
    Given I am on the signup page
    When I fill in the signup form with a invalid date of birth
    And I click the next button
    Then I should see an error message indicating please match the requested format

  Scenario: Signup with Existing Email
    Given I am on the signup page
    When I fill in the signup form with an existing email
    And I click the next button
    Then I should see an error message indicating An account is already registered with the email address provided

  Scenario Outline: Signup with Invalid information
    Given I am on the signup page
    When I fill in the signup form with an invalid "<ssn>" or "<email>" or "<password>"
    And I click the next button
    Then I should see an error message for "<field>"

    Examples: 
      | ssn        | email          |    password   | field        |
      | 4865421657 | asfd@gmail.com |    Demo@123   | ssn          |
      |  486461678 | asgmail.com    |   Demo@123    | emailAddress |
      |  486461678 | asfd@gmail.com |   afgaDa12    | password		 |

  Scenario: Signup with mismatched passwords
    Given I am on the signup page
    When I fill in the signup form with an mismatched passwords
    And I click the next button
    Then I should see an error message indicating passwords do not match

  Scenario: Signup with Missing Information
    Given I am on the signup page
    When I fill in the signup form with missing information and click next
    And I click the next button
    Then I should see error messages indicating please fill out this field

  Scenario: Successful Signup
    Given I am on the signup page
    When I fill in the signup form with valid information
    And I click the next button
    Then I should be redirected to new form page
    And I fill address, tick terms checkbox
    And click on signup
    Then I should be redirected to signin page