Feature: Search and place the order for products

@PlaceOrder
Scenario Outline: Search Experience for product search in both home and offers page

Given User is on GreenCart Landing Page
When  user searched with shortname <Name> and extracted actual name of product
And Added "3" items of the selected product to cart
Then user proceeds to checkout ad validate the <Name> of items int he checkout page
And verify user has the ability to enter the promocode and place the order

Examples:
|Name|
|Tom|

