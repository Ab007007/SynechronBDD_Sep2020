Feature: Google Search With Examples

  Scenario Outline: User prints all search results
    Given user is on Google page
    When user enters <companyname>
    And he click on search button
    Then user prints all the search results from first page

    Examples: 
      | companyname |
      | Synechron   |
      | Wipro       |
      | IBM         |

	@googleSearch
  Scenario Outline: User prints all autosuggestions
    Given user is on Google page
    When user enters <companyname>
    Then application displayes auto suggestion
    And user prints all the suggestions displayed

    Examples: 
      | companyname |
      | Synechron   |
      | Wipro       |
      | IBM         |
