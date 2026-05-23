Feature:Contact us functionality

Background:
Given User navigates to the login page

Scenario Outline:Logged in user submits contact form with file
And User enters valid username and password
And User clicks the login button
And User logged in successfully
When Logged in user navigates to the contact us page 
Then Contact us page is displayed
And User fills the contact form "<name>" "<email>" "<subject>" "<message>"
And Attach file with message
When User submits the message
Then Message should be submitted successfully
And Click on home button
Examples:
|name|email|subject|message|
|tester|abc@mail.com|Issue in order|I have not received the order|

Scenario Outline:Submit contact form without file
When User navigates to the contact us page 
Then Contact us page is displayed
And User fills the contact form "<name>" "<email>" "<subject>" "<message>"
When User submits the message
Then Message should be submitted successfully
And Click on home button
Examples:
|name|email|subject|message|
|tester|abc@mail.com|Issue in order|I have not received the order|

