Feature:Home page functionality

Background:
Given User navigates to the home page
@Smoke
Scenario Outline:Verify homepage links 
When User navigates to the Test Cases page 
Then Test Cases page is displayed
When User navigates to the API Testing page 
Then API Testing page is displayed
When User navigates to the Video Tutorials page 
Then Video Tutorials page is displayed
@Smoke
Scenario Outline:Verify homepage links after logging in
And User navigates to the login page
And User enters valid username and password
And User clicks the login button
And User logged in successfully
When Logged in user navigates to the Test Cases page 
Then Test Cases page is displayed
When Logged in user navigates to the API Testing page 
Then API Testing page is displayed
When Logged in user navigates to the Video Tutorials page 
Then Video Tutorials page is displayed


