Feature: Google Search

  Background: 
    Given user is on app page
      | http://www.google.co.in |
      | http://www.amazon.com   |
      | http://www.google.com   |

  @googleSearch @regression
  Scenario: User prints all search results
    #Given user is on Google page
    When user enters "synechron"
    And he click on search button
    Then user prints all the search results from first page
