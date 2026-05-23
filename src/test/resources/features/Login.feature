Feature:Login functionality


Background:
Given User navigates to the login page
@Smoke
Scenario Outline:Valid user Login
And User enters valid username and password
When User clicks the login button
Then User logged in successfully
 @Smoke
Scenario:Invalid user Login
And User enters invalid username and password
When User clicks login button
But Login failed