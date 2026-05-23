Feature:Subscription functionality
Background:
Given User navigates to the login page
And User enters valid username and password
And User clicks the login button
And User logged in successfully
@Smoke
Scenario:Enroll for subscription from Home page
And User navigates to the home page
And User enters email under subscription
When User clicks on subscription button
Then Successful subscription message displayed
@Smoke
Scenario:Enroll for subscription from Products page
And User navigates to the products page
And User enters email under subscription
When User clicks on subscription button
Then Successful subscription message displayed
@Smoke
Scenario:Enroll for subscription from Products Details page
And User navigates to the products page
When User clicks the view product of "<product>"
Then Product "<product>" details is displayed
And User enters email under subscription
When User clicks on subscription button
Then Successful subscription message displayed
Examples:
|product |quantity|
|Men Tshirt|1|
@Smoke
Scenario:Enroll for subscription from Cart page
And User navigates to the cart page
And User enters email under subscription
When User clicks on subscription button
Then Successful subscription message displayed
@Smoke
Scenario:Enroll for subscription from Contact Us page
And Logged in user navigates to the contact us page
And User enters email under subscription
When User clicks on subscription button
Then Successful subscription message displayed
@Smoke
Scenario:Enroll for subscription from Test Cases page
And Logged in user navigates to the Test Cases page
And User enters email under subscription
When User clicks on subscription button
Then Successful subscription message displayed
@Smoke
Scenario:Enroll for subscription from API Testing page
And Logged in user navigates to the API Testing page
And User enters email under subscription
When User clicks on subscription button
Then Successful subscription message displayed
@Smoke
Scenario:Enroll for subscription from Checkout page
And User navigates to the products page
And User add the products
|Blue Top|
|Winter Top|
And User navigates to the cart page
And Click on Proceed to Checkout
And User enters email under subscription
When User clicks on subscription button
Then Successful subscription message displayed
@Smoke
Scenario:Enroll for subscription from Payment page
And User navigates to the products page
And User add the products
|Blue Top|
|Winter Top|
And User navigates to the cart page
And Click on Proceed to Checkout
And User clicks Place Order button
And User navigated to payment page
And User enters email under subscription
When User clicks on subscription button
Then Successful subscription message displayed
@Smoke
Scenario Outline:Enroll for subscription from final order page
And User navigates to the products page
And User add the products
|Blue Top|
|Winter Top|
And User navigates to the cart page
And Click on Proceed to Checkout
And User clicks Place Order button
And User navigated to payment page
And User enter payment details "<name>""<number>""<cvc>""<month>""<year>"
When User clicks pay and confirm order
Then Order is placed successfully
And User enters email under subscription
When User clicks on subscription button
Then Successful subscription message displayed
And User clicks continue button
Examples:
|name|number|cvc|month|year|
|tester|4510987|391|05|2027|

