Feature: Create Customer Functionality

  # Below steps are take care by hooks
  #Given user is loggedin to the actitime application using "admin" and "manager"
  #When user clicks on task tab
  #Then user is navitaged to tasks page
  
  # logout is taken care in hook
  
  @actitime @end2end
  Scenario: Customer should be successfully Created
    When user click on Add new customer
    Then customer creation page should be displayed
    When user enter Syn-BDD-Cust16 and Syn-BDD-Cust16-Desc and click on create customer
    And success message should be displayed
    Then customer Syn-BDD-Cust16 should be created successfully
  

  @actitime
  Scenario Outline: Customer should be successfully Created
    When user click on Add new customer
    Then customer creation page should be displayed
    When user enter <customername> and <customerdesc> and click on create customer
    And success message should be displayed
    Then customer <customername> should be created successfully
   

    Examples: 
      | customername       | customerdesc       |
      | Syn-BDD-Cust_22_14 | Syn-BDD-Cust_22_14 |
      | Syn-BDD-Cust_22_15 | Syn-BDD-Cust_22_15 |
