Feature: Search and place the order for products
  Scenario:Search experience for product search in both product and offer page
    Given user is on GreenCart Landing page
    When  user searched for Shortname "Tom" and Extracted actual name of the product
    Then  user searched "Tom" Shortname in offers page
     And  Validate product name in offer page matchs with landing page


