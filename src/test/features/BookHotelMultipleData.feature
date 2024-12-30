#Feature: Book Hotel from phptravels using data
#
#  @Regression
#  Scenario Outline: End to End flow to make hotel booking in different cities
#    Given booking site is open
#    When enter "<City>" and date to book hotel
#    And change adults to one
#    And search for hotels
#    Then check hotel results
#    And choose first hotel
#    And choose room and submit
#    And enter user details
#    And submit booking
#    Then Hotel booking confirmation shown
#    Examples:
#      | City |
#      |Hamburg|
#      |Berlin |
#      |Stuttgart|
#
