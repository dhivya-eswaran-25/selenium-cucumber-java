Feature:Products functionality

Background:
Given User navigates to the products page

Scenario:View product list
And User view all products

Scenario Outline:Search product
And User enters "<text>" in the search box
When User clicks the search button
Then Search results are displayed
Examples:
| text |
| tops |
| jeans |
| tshirt |
| dress |
| saree |
| watch |
@UAT
Scenario:Display products by category
When User clicks the women dress category
Then Women dresses are displayed
When User clicks the women tops category
Then Women tops are displayed
When User clicks the women saree category
Then Women sarees are displayed
When User clicks the men jeans category
Then Men jeans are displayed
When User clicks the men tshirt category
Then Men tshirts are displayed
When User clicks the kids dress category
Then Kids dress are displayed
When User clicks the kids tops category
Then Kids tops are displayed

Scenario Outline:Display products by brand
And User list products by brand
When User clicks on the "<brandname>" brand
Then Products for that brand is displayed
Examples:
|brandname|
|H&M|
|POLO|
|BABYHUG|
