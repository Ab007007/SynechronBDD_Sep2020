Feature: Formy form filling
  Scenario: Enter Form for Registration
    Given User is on Formy Application
    When user is on Form page
    Then user enter all the details
      | Aravinda | HB | Trainer | Grad School | Male | 10+ | 09/18/2020 |
    And click on submit button
    Then registration success message should be displayed
