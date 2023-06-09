Feature: Login with Valid Credentials

  @smoke
  Scenario: Successful Login with Valid Credentials
    Given User Launch browser
    And opens URL
    When User navigate to MyAccount menu
    And click on Login
    And Email and password
    And Click on Login button
    Then User navigates to MyAccount Page

  @Regression
  Scenario: Successful Login with Valid Credentials
    Given User Launch browser
    And opens URL
    When User navigate to MyAccount menu
    And click on Login
    And Email and password
    And Click on Login button
    Then User navigates to MyAccount Page
