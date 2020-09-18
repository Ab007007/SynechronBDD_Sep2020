Feature: Demonstrate alternativeText in Parameter in feature file
  Scenario: User prints all search results
    Given user is on Google page
    When user enters Synechron
    And he click on search button
    Then search results will have hyperlinks
   
    Scenario: User prints all search results
    Given user is on Google page
    When user enters Synechron
    And he click on search button
    Then search result will have serachdetails
 #   And user prints all \\{hyperlink}
    