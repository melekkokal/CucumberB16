Feature: Testing WebOrder Login functionality with Scenario Outline
  Scenario Outline: Testing negative login functionality with different inputs.
    When User enters  '<userEmail>', '<password>' and clicks sign in button
    Then User validates the message '<message>'
    Examples:
    |userEmail                   |password     |message              |
    |wrong@gmail.com             |Guest1!      |Sign in Failed       |
    |guest1@microworks.com       |password     |Sign in Failed       |
    |                            |             |Sign in Failed       |
