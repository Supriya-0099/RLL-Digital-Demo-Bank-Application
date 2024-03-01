Feature: Testing dbankdemo Transfer between Accounts feature

Scenario: Testing Transfer between Accounts
    			Given User is on Transfer between Accounts page
   			 	When Validating Reset button of Transfer between Accounts page
    			Then Validating Submit button without any data
    			And Validating Submit button with amount as zero
    			Then Validating succesful Transfer between Accounts transaction with valid credentials