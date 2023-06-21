Feature:Testing the Google Search Functionality
  #general description
  Scenario: Happy Path(positive) Testing for Search
  #test case
    Given User navigates to Google
    When User searches for CodeFish
    Then User validates first page returns more than ten link

  Scenario: Happy Path(positive) Testing Result for Search
    Given User navigates to Google
    When User searches for Kyrgyz Food in USA
    Then User validates the result is less than 300000000

    Scenario: Happy Path(positive) Testing Result for Search
      Given User navigates to Google
      When User searches for Turkish baklava
      Then User validates the result was loaded in less than one second.
