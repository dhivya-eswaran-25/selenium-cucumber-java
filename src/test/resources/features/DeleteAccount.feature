Feature:Delete Account functionality

Background:
Given User navigates to the login page

Scenario:Valid account deletion
And User enters valid username and password
When User clicks the login button
Then User logged in successfully
When User clicks the delete account button
Then Account deleted successfully
And User clicks the continue button
