@apiregression @regression
Feature:Testing Google Search Functionality
  #general description
  Background:
    Given User navigates to Google

  Scenario: Happy Path(positive) Testing for Search
  #test case
    When User searches for CodeFish
    Then User validates first page returns more than ten link

  Scenario: Happy Path(positive) Testing Result for Search
    #test case
    When User searches for Kyrgyz Food in USA
    Then User validates the result is less than three hundred million

    Scenario: Happy Path(positive) Testing Result for Load Times
      #test case
      When User searches for Turkish baklava
      Then User validates the result was loaded in less than one second.
