@endtoend
Feature: The Login Page
	As a returning customer
	I want to login to the application
	So that I can view my account balance

Background:
	Given the user is on the login page

@goodlogin @ignore
Scenario: the user should be able to login with valid credentials	
	When the user enters valid credentials
	Then the user should be able to view their account balance
	
@badlogin @ignore
Scenario: the user should not be able to login with bad credentials	
	When the user enters bad credentials
	Then the user should not be able to login
	And the user should get an invalid login message
 
@ignore
Scenario: the user should be able to login
	When the user enters username as "tim@testemail.com"
	And the user enters password as "trpass"
	And user clicks login
	Then the user should be able to view their account balance
	
Scenario Outline: the user should be able to login
	When the user enters "<username>" and "<password>"
	Then the user should be able to view account balance
	
Examples:
| username | password |
|