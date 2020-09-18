Feature: Demonstrate optional Parameter in feature file

  Scenario: User prints all search results
    Given user is on Google page
    When user enters Synechron
    And he click on search button
    Then search result will have 0 result
    
    Scenario: User prints all search results
    Given user is on Google page
    When user enters Synechron
    And he click on search button
    Then search result will have 10 results
    