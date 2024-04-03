Feature: Register Flow Test Suite

  Background:
    Given The "https://demo-opencart.ru/" link is accessed

  @Test1
  Scenario: Successful register with valid data
    And The register button from Home Page is clicked
    When Register Page is populated with valid random data
    Then The URL contains "success" keyword

  @Test2
  Scenario Outline: Unsuccessful register with invalid <attribute>
    And The register button from Home Page is clicked
    When Register Page is populated with the following data:
      | firstName   | <firstName>      |
      | lastName    | <lastName>    |
      | email       | <email>       |
      | phoneNumber | <phoneNumber> |
      | password    | <password>    |
    Then The URL does not contain "success" keyword
    Examples:
      | attribute   | firstName | lastName | email  | phoneNumber | password |
      | phoneNumber | RANDOM    | RANDOM   | RANDOM | 00          | RANDOM   |
      | password    | RANDOM    | RANDOM   | RANDOM | RANDOM      | sss      |