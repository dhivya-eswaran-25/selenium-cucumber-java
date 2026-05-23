Feature:Subscription functionality
@Smoke
Scenario:Enroll for subscription from Home page
Given User navigates to the home page
And User enters email under subscription
When User clicks on subscription button
Then Successful subscription message displayed
@Smoke
Scenario:Enroll for subscription from Signup page
Given User navigates to the signup page
And User enters name and email
When User clicks signup button
And User enters email under subscription
When User clicks on subscription button
Then Successful subscription message displayed
@Smoke
Scenario:Enroll for subscription from Products page
Given User navigates to the products page
And User enters email under subscription
When User clicks on subscription button
Then Successful subscription message displayed
@Smoke
Scenario:Enroll for subscription from Products Details page
Given User navigates to the products page
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
Given User navigates to the cart page
And User enters email under subscription
When User clicks on subscription button
Then Successful subscription message displayed
@Smoke
Scenario:Enroll for subscription from Contact Us page
Given User navigates to the contact us page
And User enters email under subscription
When User clicks on subscription button
Then Successful subscription message displayed
@Smoke
Scenario:Enroll for subscription from Test Cases page
Given User navigates to the Test Cases page
And User enters email under subscription
When User clicks on subscription button
Then Successful subscription message displayed
@Smoke
Scenario:Enroll for subscription from API Testing page
Given User navigates to the API Testing page
And User enters email under subscription
When User clicks on subscription button
Then Successful subscription message displayed