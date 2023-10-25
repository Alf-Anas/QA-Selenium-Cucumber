Feature:    User Login

  Scenario:    Verify user can login using valid username and password
    Given    The Saucedemo application is open
    When    The user enters the valid username "standard_user"
    And    The user enters the valid password "secret_sauce"
    And    Clicks the Login button
    Then    The user should be logged in successfully

  Scenario:    Verify user cannot login using invalid username and password
    Given    The Saucedemo application is open
    When    The user enters the invalid username "standard_user"
    And    The user enters the invalid password "random_password"
    And    Clicks the Login button
    Then    The user should not be able to log in


