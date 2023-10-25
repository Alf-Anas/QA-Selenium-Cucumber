Feature:    User Logout

  Scenario:    Verify user can login using valid username and password
    Given    The Saucedemo application is open
    When    The user enters the valid username "standard_user"
    And    The user enters the valid password "secret_sauce"
    And    Clicks the Login button
    And   Make Browser Stay Alive
    Then    The user should be logged in successfully

  Scenario:    Verify user can logout successfully
    Given    The user is on the All Items page
    When    The user clicks Menu Button in the sidebar
    And    The user clicks Logout Button in the sidebar
    And    The user get back to login page
    Then    Close Browser


