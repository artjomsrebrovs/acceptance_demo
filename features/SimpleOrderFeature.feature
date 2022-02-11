Feature: test a placement of a single item simple order

  Scenario: the user should be able to search for an item,
  put found item in its cart and the checkout by providing personal information
  as well as information about delivery and payment terms

    Given user navigates to "https://opencart.abstracta.us/"
    Then user is on the main page
    When user searches for the product "iPhone"
    Then user gets search results for "iPhone"
    When user clicks on found product "iPhone"
    Then product "iPhone" details page opens
    When user inputs product quantity of 1
    And user clicks add to cart button
    Then user gets message saying product successfully added to cart
    And user clicks on cart link in success message
    Then cart page opens
    When user clicks on checkout button
    Then checkout page opens
    And first step account panel is expanded
    Then user selects guest account option
    And user clicks continue button on account panel
    Then second step guest information panel is expanded
    Then user enters its guest information in form
    And user clicks continue button on guest information panel
    Then forth step shipping panel is expanded
    Then user selects flat shipping method
    And user clicks continue on shipping panel
    Then fifth step payment panel is expanded
    Then user selects cod payment method
    Then user agrees with terms and conditions
    And user clicks continue on payment panel
    Then sixth step order confirmation panel is expanded
    And user clicks continue on confirmation panel
    Then order success page opens
    And user clicks continue on success page
    Then user is on the main page


