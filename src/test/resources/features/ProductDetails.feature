Feature:Product details functionality

Scenario Outline:Display product details
Given User navigates to the login page
And User enters valid username and password
When User clicks the login button
Then User logged in successfully
And User navigates to the products page
When User clicks the view product of "<product>"
Then Product "<product>" details is displayed
And Updates product quantity "<quantity>"
Examples:
| product |quantity|
|Men Tshirt|1|
|Blue Top|2|

Scenario Outline:Add review to a product
Given User navigates to the products page
When User clicks the view product of "<product>"
Then Product "<product>" details is displayed
And User writes review for that product "<name>" "<email>" "<review>"
When User clicks submit button
Then Success message should be displayed
Examples:
| product |name|email|review|
|Men Tshirt|test1|email1@test.com|tshirt is good|
|Blue Top|test2|email2@test.com|tops is not good|




