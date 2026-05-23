Feature:Download Invoice functionality

Background:
Given User navigates to the login page

Scenario Outline:Place the order and download invoice
And User enters valid username and password
When User clicks the login button
Then User logged in successfully
And User navigates to the products page
And User add the products
|Blue Top|
|Winter Top|
And User navigates to the cart page
And Click on Proceed to Checkout
And Verify Address details
And User clicks Place Order button
And User navigated to payment page
And User enter payment details "<name>""<number>""<cvc>""<month>""<year>"
When User clicks pay and confirm order
Then Order is placed successfully
When User clicks download invoice button
Then Verify invoice is downloaded
And Verify invoice contents
Examples:
|name|number|cvc|month|year|
|tester|4510987|391|05|2027|



