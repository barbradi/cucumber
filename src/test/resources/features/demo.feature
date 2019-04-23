Feature: Weather

  Scenario: Check weather
    When I retrieve current weather information
    Then I have 3 counties weather information


  Scenario: Check weather test 2
    When I retrieve current weather information
    Then I have 3 counties weather information