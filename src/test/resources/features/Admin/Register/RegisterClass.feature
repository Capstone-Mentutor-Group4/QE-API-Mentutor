Feature: Register Class Mentutor API

  @RegisterClass @TokenAdmin
  Scenario: Post Register Class Mentutor API
    Given Register class with valid class name "Front End-11"
    When Send request post register class
    Then Should return 201 Created
    And Validate json schema register class

  @RegisterClass
  Scenario: Post Register Class without Authorization Metutor API
    Given Register class with classname "Front End-12" and Unauthorized
    When Send request post register class
    Then Should return 400 Bad Request
    And Validate json schema register class

  @RegisterClass @TokenAdmin
  Scenario: Post Register Class with empty class name parameter
    Given Register class with empty class name
    When Send request post register class
    Then Should return 400 Bad Request
    And Validate json schema register class

  @RegisterClass @TokenAdmin
  Scenario: Post Register Class with numeric class name parameter
    Given Register class with numeric class name 123456
    When Send request post register class
    Then Should return 400 Bad Request
    And Validate json schema register class

  @RegisterClass @TokenAdmin
  Scenario: Post Register Class with special character name parameter
    Given Register class with special character name parameter "@$%^#$$"
    When Send request post register class
    Then Should return 400 Bad Request
    And Validate json schema register class