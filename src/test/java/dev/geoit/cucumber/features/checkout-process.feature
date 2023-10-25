Feature:    Checkout Process

  #  Using Login Scenario
  Scenario: Verify user can login using valid username and password
    Given The Saucedemo application is open
    When The user enters the valid username "standard_user"
    And The user enters the valid password "secret_sauce"
    And Clicks the Login button
    And Make Browser Stay Alive
    Then The user should be logged in successfully

  #  Using ProductCart Scenario
  Scenario:    User adds items to the cart and views them in the cart page
    Given    The user is on the All Items page
    When    The user clicks Add to Cart Button for the first item
    And    The user clicks Add to Cart Button for the second item
    And    The user opens the cart page by clicking the cart icon
    Then    The user should be able to see the added items in the cart page

  Scenario:    User checks out the item with valid name and valid postal code
    Given    The user is on the cart page
    When    The user clicks the Checkout button
    And    The user is on the checkout page
    And    The user inputs the valid First Name "Alfa"
    And    The user inputs the valid Last Name "Beta"
    And    The user inputs the valid ZIP Code number "12345"
    And    The user clicks Continue
    Then    The user should be able to proceed to the checkout overview

  Scenario:    User cannot check out the item with invalid name or postal code
    Given    The user is on the cart page
    When    The user clicks the Checkout button
    And    The user is on the checkout page
    And    The user inputs the valid First Name "Alfa"
    And    The user inputs the valid Last Name "Beta"
    And    The user inputs the invalid ZIP Code using the string value "ABCDE"
    And    The user clicks Continue
    Then    The user should not be able to proceed to the checkout overview
    Then    Close Browser
