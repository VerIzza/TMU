@tag 
Feature: Login Page 
	As a user I should be able to login to the store and buy a phone

@testPhone
Scenario: As a normal user I should be able to buy a phone from the store site
	Given The user is in store
	When User click on phones category
	And User should be able to select a phone from the list
	And User should be able to click on Add to cart button
	And confirm the alert with ok
	When User click on cart section should be able to see his shopping list
	When User click on place order he should send his data "Name" "Country" "City" number "Month" year
	When User click on purchase button he should be able to see an alert with purchase data 
	And click OK button
	Then User should be redirected to main page
	