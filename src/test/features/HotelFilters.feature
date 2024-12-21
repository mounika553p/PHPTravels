Feature: Search for hotels using filters

  @Regression
  Scenario: Search for five star hotel
    Given booking site is open
    When enter city and date to book hotel
    And change adults to one
    And search for hotels
    Then check hotel results
    And filter for five star hotels
    Then verify five star hotels shown

  @Regression
  Scenario Outline: Search for hotels in Specific region
    Given booking site is open
    When enter specific "<city>" and date to book hotel
    And search for hotels
    Then check hotel results for specific "<city>"
    Examples:
      | city   |
      | Berlin |

  @Regression
  Scenario: Search for hotels with airport transit
    Given booking site is open
    When enter city and date to book hotel
    And change adults to one
    And search for hotels
    Then check results are shown for airport transit

  @Regression
  Scenario: Search for hotels with airport transit
    Given booking site is open
    When enter city and date to book hotel
    And change adults to one
    And search for hotels
    Then check results are shown for elevator


