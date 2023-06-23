Feature: Put Order Functionality
  Scenario: Happy Path for Put Order

    Given User enters  'guest1@microworks.com', 'Guest1!' and clicks sign in button
    Then User clicks group order and next button and sends 'I LOVE SELENIUM' to invitees and add 'email@gmail.com' and 'email2@gmail.com'
    And User chooses the service method 'My House', validates '3137 Laguna' and clicks create group order button
    Then User validates 'View Group Order' and 'Your group order is now pending'

