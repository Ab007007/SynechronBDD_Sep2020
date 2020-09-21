Feature: Google Search

  Background: 
    Given user is on Google page

  @googleSearch @regression
  Scenario: User prints all search results
    #Given user is on Google page
    When user enters "synechron"
    And he click on search button
    Then user prints all the search results from first page

  @googleSearch
  Scenario: User prints all search results
    #Given user is on Google page
    When user enters "wipro"
    And he click on search button
    Then user prints all the search results from first page

  @googleSearch
  Scenario: User prints all search results
    #Given user is on Google page
    When user enters "IBM"
    And he click on search button
    Then user prints all the search results from first page

  @autoSuggestion
  Scenario: User prints all autosuggestions
    #Given user is on Google page
    When user enters "IBM"
    Then application displayes auto suggestion
    And user prints all the suggestions displayed

  @autoSuggestion @regression
  Scenario: User prints all autosuggestions
    #Given user is on Google page
    When user enters "Synechron"
    Then application displayes auto suggestion
    And user prints all the suggestions displayed

  @developementTest
  Scenario: User prints all autosuggestions
    #Given user is on Google page
    When user enters "Wipro"
    Then application displayes auto suggestion
    And user prints all the suggestions displayed
#Scenario: User print the tooltip on the icons 
