Feature:    Product Cart Functionality

#  Using Login Scenario
  Scenario: Verify user can login using valid username and password
    Given The Saucedemo application is open
    When The user enters the valid username "standard_user"
    And The user enters the valid password "secret_sauce"
    And Clicks the Login button
    And Make Browser Stay Alive
    Then The user should be logged in successfully

  Scenario:    User adds items to the cart and views them in the cart page
    Given    The user is on the All Items page
    When    The user clicks Add to Cart Button for the first item
    And    The user clicks Add to Cart Button for the second item
    And    The user opens the cart page by clicking the cart icon
    Then    The user should be able to see the added items in the cart page

  Scenario:    User removes items from the cart and cannot see it in the cart page
    Given    The user is on the All Items page
    When    The user clicks Add to Cart Button for the first item
    And    The user clicks Remove Button for the first item
    And    The user clicks Add to Cart Button for the second item
    And    The user clicks Remove Button for the second item
    And    The user opens the cart page by clicking the cart icon
    And    The removed items cannot be seen in the cart page
    Then    Close Browser

