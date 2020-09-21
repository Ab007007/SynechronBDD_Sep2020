Feature: Create Customer Functionality

  Scenario: Customer should be successfully Created
    Given user is loggedin to the actitime application using "admin" and "manager"
    When user clicks on task tab
    Then user is navitaged to tasks page
    When user enter all detals and click on create customer and success msg should be displayed
      | Syn-BDD-Cust14 | Syn-BDD-Cust14-Desc |
      | Syn-BDD-Cust5  | Syn-BDD-Cust5-Desc  |
      | Syn-BDD-Cust6  | Syn-BDD-Cust6-Desc  |
      | Syn-BDD-Cust7  | Syn-BDD-Cust7-Desc  |
    And user logout of application

  Scenario: Multiple Customer should be successfully Created
    Given user is loggedin to the actitime application using "admin" and "manager"
    When user clicks on task tab
    Then user is navitaged to tasks page
    When user enter all detals from map and click on create customer and success msg should be displayed
      | customerName   | customerDesc        |
      | Syn-BDD-Cust8  | Syn-BDD-Cust14-Desc |
      | Syn-BDD-Cust9  | Syn-BDD-Cust5-Desc  |
      | Syn-BDD-Cust10 | Syn-BDD-Cust6-Desc  |
      | Syn-BDD-Cust11 | Syn-BDD-Cust7-Desc  |
    And user logout of application
    
    
     Scenario: Multiple Customer should be successfully Created
    Given user is loggedin to the actitime application using "admin" and "manager"
    When user clicks on task tab
    Then user is navitaged to tasks page
    When user enter all detals from single map and click on create customer and success msg should be displayed
      | customerName   | customerDesc        |
      | Syn-BDD-Cust8,Syn-BDD-Cust9,Syn-BDD-Cust10,Syn-BDD-Cust11 | Syn-BDD-Cust8-Desc,Syn-BDD-Cust9-Desc,Syn-BDD-Cust10-Desc,Syn-BDD-Cust11-Desc |
    And user logout of application
    
