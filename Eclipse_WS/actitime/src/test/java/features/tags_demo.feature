Feature: Tags Demonstration

  @sanity @regression
  Scenario: Verify admin Login
    Given This is valid login scenario

  @sanity @regression
  Scenario: Verify logout
    Given This is logout scenario

  @end2end @regression @functional
  Scenario: Verify customer creation
    Given This is customer creation scenario

  @regression @functional
  Scenario: Verify project creation
    Given This is project creation scenario

  @regression @functional
  Scenario: Verify task creation
    Given This is task creation scenario

	@regression @end2end @production
  Scenario: Verify user creation
    Given This is user creation scenario
