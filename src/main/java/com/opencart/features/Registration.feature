Feature: Register Flow Test Suite

  Background:
    Given The defined url + "index.php?route=account/register" end part is accessed

  @Smoke1
  Scenario Outline: Successful register with valid attributes
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