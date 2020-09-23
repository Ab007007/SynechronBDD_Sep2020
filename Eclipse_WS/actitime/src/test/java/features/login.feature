Feature: Check login Functionality

  Scenario: Validate successfull login on entering valid credentials
    Given user is on login Page
    When user enter valid username and password
    And click on login button
    Then user is navigated to dashboard page
