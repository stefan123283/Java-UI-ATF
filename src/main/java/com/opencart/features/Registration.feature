Feature: Register Flow Test Suite

  @Smoke1
  Scenario: Successful register with valid data
    Given Home Page is accessed
    And The register button from Home Page is clicked
    When Register Page is populated with valid random data
    Then The URL contains success keyword
