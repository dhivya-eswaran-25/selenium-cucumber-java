Feature:Add To cart functionality

Scenario Outline:Add product to cart from product page
Given User navigates to the login page
And User enters valid username and password
When User clicks the login button
Then User logged in successfully
And User navigates to the products page
When User clicks the Add To Cart of "<product>"
Then Product is added to cart
When User clicks continue shopping
Then User remains in the product page
Examples:
| product |
|Winter Top|

Scenario Outline:Add product to cart from product details page
Given User navigates to the products page
And User clicks the view product of "<product>"
And Product "<product>" details is displayed
When User clicks the Add To Cart
Then Product is added to cart
When User clicks continue shopping
Then User remains in the product details page
Examples:
| product |
|Lace Top For Women|
|Sleeveless Dress|

Scenario Outline:View cart from product page
Given User navigates to the products page
And User clicks the Add To Cart of "<product>"
And Product is added to cart
When User clicks view cart link
Then User navigates to view cart page
Examples:
| product |
|Sleeveless Dress|

Scenario Outline:View cart from product details page
Given User navigates to the login page
And User enters valid username and password
When User clicks the login button
Then User logged in successfully
And User navigates to the products page
And User clicks the view product of "<product>"
And Product "<product>" details is displayed
And User clicks the Add To Cart
And Product is added to cart
When User clicks view cart link
Then User navigates to view cart page
Examples:
| product |
|Lace Top For Women|









