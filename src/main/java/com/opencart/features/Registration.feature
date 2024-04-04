Feature: Register Flow Test Suite

  Background:
    Given The defined web address is accessed

  @Smoke1
  Scenario Outline: Successful register with valid attributes
    And The "registerBtn" from "HomePage" is clicked
    When Register Page is populated with the following data:
      | firstName   | <firstName>   |
      | lastName    | <lastName>    |
      | email       | <email>       |
      | phoneNumber | <phoneNumber> |
      | password    | <password>    |
    Then The URL contains "success" keyword
    Examples:
      | firstName | lastName | email  | phoneNumber | password |
      | RANDOM    | RANDOM   | RANDOM | RANDOM      | RANDOM   |
      | RANDOM    | RANDOM   | RANDOM | RANDOM      | RANDOM   |

  @Test1
  Scenario Outline: Unsuccessful register with invalid <attribute>
    And The "registerBtn" from "HomePage" is clicked
    When Register Page is populated with the following data:
      | firstName   | <firstName>   |
      | lastName    | <lastName>    |
      | email       | <email>       |
      | phoneNumber | <phoneNumber> |
      | password    | <password>    |
    Then The URL does not contain "success" keyword
    Examples:
      | attribute   | firstName | lastName | email  | phoneNumber | password |
      | phoneNumber | RANDOM    | RANDOM   | RANDOM | 00          | RANDOM   |
      | password    | RANDOM    | RANDOM   | RANDOM | RANDOM      | sss      |