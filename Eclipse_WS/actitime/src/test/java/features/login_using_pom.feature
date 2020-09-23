Feature: Check login Functionality using POM

  Scenario: Validate successfull login using Page Object Model
    Given pomuser is on login Page
    When pomuser enter valid username and password
    And pomuser click on login button
    Then pomuser user is navigated to dashboard page and logout
