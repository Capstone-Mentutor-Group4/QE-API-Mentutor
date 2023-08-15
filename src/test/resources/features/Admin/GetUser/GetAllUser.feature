Feature: Get All User Mentutor API

  @TokenAdmin
  Scenario: Get All User with Authorization
    Given All User with Authorization
    When Send request get all user
    Then Should return 200 OK

  Scenario: Get All Users without Authorization
    Given All User without Authorization
    When Send request get all user
    Then Should return 400 Bad Request