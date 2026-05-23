Feature:Signup functionality

Background:
Given User navigates to the signup page
And User enters name and email
When User clicks signup button

Scenario:New User Signup
And User enters account information
And User enters address information
When User clicks create acoount
Then User created account successfully

Scenario:Existing User Signup
But Error message displayed   
