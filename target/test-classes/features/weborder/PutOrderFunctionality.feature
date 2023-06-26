@apiregression
Feature: Put Order Functionality

  Background:
    Given User enters username and password
    Then User clicks group order and next button
    And User sends 'I LOVE SELENIUM' to invitees and add 'email@gmail.com' and 'email2@gmail.com'

  Scenario: Happy Path for Put Order
    And User chooses the service method 'My House', validates '3137 Laguna' and clicks create group order button
    Then User validates 'View Group Order' and 'Your group order is now pending'

  Scenario: Happy Path for Put Order My Office
    And User chooses the service method 'Office', validates '2012 EMPIRE BLVD' and clicks create group order button
    Then User validates 'View Group Order' and 'Your group order is now pending'

