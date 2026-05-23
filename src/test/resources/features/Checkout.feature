Feature:Checkout functionality

Scenario:Place the order without review
And User navigates to the cart page
And User clicks add product link
And User add the products
|Blue Top|
|Winter Top|
And User navigates to the cart page
And Click on Proceed to Checkout
And Checkout modal is displayed
When User Clicks Register Login link
Then User navigated to login page
And User enters valid username and password
When User clicks the login button
Then User logged in successfully
And User navigates to the cart page
And Click on Proceed to Checkout
And Verify Address details
And User clicks Place Order button
And User navigated to payment page

Scenario Outline:Place the order with review comment
Given User navigates to the login page
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
And User adds review comment "<comment>"
And User clicks Place Order button
And User navigated to payment page
Examples:
| comment |
|Product is good|

Scenario:New user place the order with review
And User navigates to the cart page
And User clicks add product link
And User add the products
|Blue Top|
|Winter Top|
And User navigates to the cart page
And Click on Proceed to Checkout
And Checkout modal is displayed
When User Clicks Register Login link
Then User navigates to the signup page
And User enters name and email
When User clicks signup button
And User enters account information
And User enters address information
When User clicks create acoount
Then User created account successfully
And User navigates to the cart page
And Click on Proceed to Checkout
And Verify Address details
And User clicks Place Order button
And User navigated to payment page


