Feature: Search and place the order for products

@OffersPage
Scenario Outline: Search Experience for product search in both home and offers page

Given User is on GreenCart Landing Page
When  user searched with shortname <Name> and extracted actual name of product
Then User searched for <Name> shortname in offers page
And validate productname in home page mathches product name in offer page

Examples:
|Name|
|Tom|
|Rice|