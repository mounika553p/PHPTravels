Feature:Signup to phptravels

  @Regression
  Scenario: signup to php travels with existing account details
    Given booking site is open
    When click on sign up
    And enter user details and new password
    |testphptravel+1@gmail.com|12345678|
    And click signup button
    Then show email already exists message

  @Regression
  Scenario: signup to php travels with new account details
    Given booking site is open
    When click on sign up
    And enter user details and new password
      |testphptravel+2@gmail.com|12345678|
    And click signup button
    Then redirected to user account page