Feature: Create Customer Functionality

  Scenario: Customer should be successfully Created
    Given user is loggedin to the actitime application using "admin" and "manager"
    When user clicks on task tab
    Then user is navitaged to tasks page
    When user enter all detals and click on create customer success msg should be displayed
      | Syn-BDD-Cust3 | Syn-BDD-Cust3-Desc |
      | Syn-BDD-Cust4 | Syn-BDD-Cust4-Desc |
      | Syn-BDD-Cust5 | Syn-BDD-Cust5-Desc |
      | Syn-BDD-Cust6 | Syn-BDD-Cust6-Desc |
    And user logout of application
