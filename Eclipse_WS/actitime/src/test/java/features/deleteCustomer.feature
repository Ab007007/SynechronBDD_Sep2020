Feature: Create Customer Functionality

  Background: 
    Given user is loggedin to the actitime application using "admin" and "manager"
    When user clicks on task tab
    Then user is navitaged to tasks page

  Scenario: Customer should be successfully Deleted
    When user search for a customer Syn-BDD-Cust_22_12
    When user moves the cursor to setting icon displayed next to Syn-BDD-Cust_22_12 and click on it
    Then customer action page should be displayed
    And click on Action and delete permanently
    Then customer deletion success message should be displayed
    And user logout of application

  @deletecustomer
  Scenario Outline: Customer should be successfully Deleted
    When user search for a customer <customername>
    When user moves the cursor to setting icon displayed next to <customername> and click on it
    Then customer action page should be displayed
    And click on Action and delete permanently
    Then customer deletion success message should be displayed
    And user logout of application

    Examples: 
      | customername  |
      | Syn-BDD-Cust5 |
      | Syn-BDD-Cust6 |
      | Syn-BDD-Cust7 |
      | Syn-BDD-Cust8 |
      | Syn-BDD-Cust9 |
