Feature: WebOrder Login Functionality
  @smoke
  Scenario: Happy Path Testing Login with correct email and correct password
    When User enters  'guest1@microworks.com', 'Guest1!' and clicks sign in button
    Then User validates 'ORDER DETAILS - Weborder'

@smoke
    Scenario: Negative path Testing Login with wrong email and correct password
      When User enters  'wrong@gmail.com', 'Guest1!' and clicks sign in button
      Then User validates the message 'Sign in Failed'

@apiregression
      Scenario: Negative path Testing Login with correct email and wrong password
        When User enters  'guest1@microworks.com', 'password' and clicks sign in button
        Then User validates the message 'Sign in Failed'

@apiregression
        Scenario: Negative path Testing login with empty email and empty password

          When User enters  '', '' and clicks sign in button
          Then User validates the message 'Sign in Failed'