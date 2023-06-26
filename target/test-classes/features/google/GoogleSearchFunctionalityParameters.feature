@apiregression @regression
Feature:Testing Google Search Functionality Parameters
  #general description
  Scenario: Happy Path(positive) Testing for Search Parameters
  #test case
    Given User navigates to 'https://www.google.com/'
    When User searches for 'CodeFish'
    Then User validates first page returns more than 10 link
@smoke
  Scenario: Happy Path(positive) Testing Result for Search Parameters
    #test case
    Given User navigates to 'https://www.google.com/'
    When User searches for 'Kyrgyz Food in USA'
    Then User validates the result is less than 300000000

  Scenario: Happy Path(positive) Testing Result for Load Times Parameters
      #test case
    Given User navigates to 'https://www.google.com/'
    When User searches for 'Turkish baklava'
    Then User validates the result was loaded in less than 1.0 second.
