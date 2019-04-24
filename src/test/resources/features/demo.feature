Feature: Weather

  Scenario: Check weather
    When I retrieve current weather information
    Then I have 3 counties weather information

