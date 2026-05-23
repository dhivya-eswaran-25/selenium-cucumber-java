Feature:View and Update cart functionality

Scenario:Update cart by deleting product
Given User navigates to the login page
And User enters valid username and password
When User clicks the login button
Then User logged in successfully
And User navigates to the products page
And User add the products
|Blue Top|
|Winter Top|
And User navigates to the cart page
When User clicks the delete product
|Blue Top|
Then Verify product is deleted
|Blue Top|
And Click on Proceed to Checkout

Scenario Outline:Update cart by updating quantity
Given User navigates to the cart page
And User clicks add product link
And User add the products
|Blue Top|
|Winter Top|
And User navigates to the cart page
When User clicks the description link of "<product>"
Then Product "<product>" details is displayed
And Updates product quantity "<quantity>"
And User clicks the Add To Cart
And Product is added to cart
When User clicks view cart link
Then User navigates to view cart page
And Click on Proceed to Checkout
And Checkout modal is displayed
When User Clicks Register Login link
Then User navigated to login page
Examples:
| product |quantity|
|Blue Top|3|



