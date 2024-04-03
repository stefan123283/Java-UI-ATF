Feature: Login Flow Test Suite

  Background:
    Given The "https://demo-opencart.ru/" link is accessed

  @Smoke2
  Scenario Outline: Successful login with valid data
    And The Login Page is accessed
    When The Login Page is populated with the following data:
      | <email>    |
      | <password> |
    Then The URL does not contain "login" keyword
    Examples:
      | email                       | password |
      | darren.vandervort@gmail.com | l670     |
