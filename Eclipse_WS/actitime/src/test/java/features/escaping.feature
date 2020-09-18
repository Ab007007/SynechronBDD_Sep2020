Feature: Demonstrate escaping string in feature file

  Scenario: User prints all search results
    Given user is on Google page
    When user enters Synechron
    And he click on search button
    Then search results will have {hyperlinks}
