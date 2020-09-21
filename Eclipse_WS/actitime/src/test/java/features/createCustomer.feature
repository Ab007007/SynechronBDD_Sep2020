Feature: Create Customer Functionality

  Scenario: Customer should be successfully Created
    Given user is loggedin to the actitime application using "admin" and "manager"
    When user clicks on task tab
    Then user is navitaged to tasks page
    When user click on Add new customer
    Then customer creation page should be displayed
    When user enter "Syn-BDD-Cust2" and "Syn-BDD-Cust2-Desc" and click on create customer
    And success message should be displayed
    Then customer "Syn-BDD-Cust2" should be created successfully
    And user logout of application

  @developmentCC
  Scenario Outline: Customer should be successfully Created
    Given user is loggedin to the actitime application using "admin" and "manager"
    When user clicks on task tab
    Then user is navitaged to tasks page
    When user click on Add new customer
    Then customer creation page should be displayed
    When user enter <customername> and <customerdesc> and click on create customer
    And success message should be displayed
    Then customer <customername> should be created successfully
    And user logout of application

    Examples: 
      | customername   | customerdesc       |
      | Syn-BDD-Cust12 | Syn-BDD-Cust12Desc |
      | Syn-BDD-Cust13 | Syn-BDD-Cust13Desc |
