Feature:Logout functionality

Background:
Given User navigates to the login page
@Smoke
Scenario:Valid user Logout
And User enters valid username and password
When User clicks the login button
Then User logged in successfully
When User clicks the logout button
Then User logged out successfully