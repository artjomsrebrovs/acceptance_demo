Feature: test a placement of a single item simple order

  Scenario: the user should be able to search for an item,
  put found item in its cart and the checkout by providing personal information
  as well as information about delivery and payment terms

    Given user is on the main page
    When user searches for the product "iPhone"
    Then user gets search results for "iPhone"
