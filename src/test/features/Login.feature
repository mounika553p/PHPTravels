Feature:Login to phptravels

  @Sanity
  @Regression
  Scenario: Login to php travels with valid credentials
  Given booking site is open
  When click on login
  And enter username and password
  |testphptravel+2@gmail.com|12345678|
  Then user account displayed

  @Regression
  Scenario: Login to php travels with invalid credentials
    Given booking site is open
    When click on login
    And enter username and password
      |teswrongemail@gmail.com|12345678|
    Then show invlid email message in login page