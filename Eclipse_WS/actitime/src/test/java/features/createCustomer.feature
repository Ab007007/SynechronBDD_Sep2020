Feature: Create Customer Functionality

  Scenario: Customer should be successfully Created
    Given user is loggedin to the application
    When user clicks on task tab
    Then user is navitaged to tasks page
    When user click on Add new customer
    Then customer creation page should be displayed
    When user enter unique customer name and description
    And click on create cusotmer button
    Then customer should be created successfully
    And success message should be displayed
