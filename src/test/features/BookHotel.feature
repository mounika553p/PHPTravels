Feature: Book Hotel from phptravels

  @Regression
  @Sanity
  Scenario: End to End flow to make a booking
    Given booking site is open
    When enter city and date to book hotel
    And change adults to one
    And search for hotels
    Then check hotel results
    And choose first hotel
    And choose room and submit
    And enter user details
    And verify booking summary
    And submit booking
    Then Hotel booking confirmation shown
    When choose pay later
    Then verify invoice

  @Regression
  Scenario Outline: Modify traveler count in hotel details page
    Given booking site is open
    When enter city and date to book hotel
    And change adults to one
    And search for hotels
    Then check hotel results
    And choose first hotel
    And Modify traveler count"<travelercount>"
    Then check available rooms after modify
    And choose room and submit
    Then verify booking summary with new traveler count "<travelercount>"
    And enter user details
    And submit booking
    Then Hotel booking confirmation shown
    Examples:
      | travelercount |
      | 4         |

  @Regression
  Scenario Outline: Modify room count in hotel details page
    Given booking site is open
    When enter city and date to book hotel
    And change adults to one
    And search for hotels
    Then check hotel results
    And choose first hotel
    And Modify room count "<roomcount>"
    And choose room and submit
    Then verify booking summary with new room count "<roomcount>"
    And enter user details
    And submit booking
    Then Hotel booking confirmation shown
    Examples:
      | roomcount |
      | 2         |





