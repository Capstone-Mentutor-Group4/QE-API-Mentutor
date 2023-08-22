Feature: Delete Existing Class Mentutor API

  @DeleteClass @TokenAdmin
  Scenario Outline: Delete Existing class with valid id class
    Given Delete existing class with valid id class <id_class>
    When Send request delete class
    Then Should return 200 OK
    Examples:
      | id_class |
      | 21        |

  @DeleteClass @TokenAdmin
  Scenario: Delete Existing class with invalid id class
    Given Delete existing class with invalid id class 100
    When Send request delete class
    Then Should return 404 Not Found

