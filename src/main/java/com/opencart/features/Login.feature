Feature: Login Flow Test Suite

  Background:
    Given The defined url + "index.php?route=account/login" end part is accessed

  @Smoke2
  Scenario Outline: Successful login with valid data
    And The Login Page is populated with the following data:
      | <email>    |
      | <password> |
    When The "loginBtn" from "LoginPage" is clicked
    Then The URL does not contain "login" keyword
    Examples:
      | email                       | password |
      | darren.vandervort@gmail.com | l670     |
