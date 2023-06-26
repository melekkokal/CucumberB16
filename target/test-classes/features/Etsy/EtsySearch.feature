@apiregression
Feature: Testing the Search Functionality of Etsy Website
  Scenario: Happy Path for Search Functionality for Etsy Hat
    When User searches for 'Hat' on Etsy
    Then User validates the title 'Hat - Etsy' on Etsy

  Scenario: Happy Path for Search Functionality for Etsy Hat
    When User searches for 'Key' on Etsy
    Then User validates the title 'Key - Etsy' on Etsy

  Scenario: Happy Path for Search Functionality for Etsy Hat
    When User searches for 'Pin' on Etsy
    Then User validates the title 'Pin - Etsy' on Etsy

