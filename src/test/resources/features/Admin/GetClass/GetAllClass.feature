Feature: Get All Class Mentutor API

  @TokenAdmin
  Scenario: Get All Class with Authorization
    Given All Class with Authorization
    When Send request get all class
    Then Should return 200 OK

  Scenario: Get All Class without Authorization
    Given All Class without Authorization
    When Send request get all class
    Then Should return 400 Bad Request