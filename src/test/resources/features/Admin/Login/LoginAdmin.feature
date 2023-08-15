Feature: Login User Mentutor API

  @Login
  Scenario:Post Login Admin with Valid Data
    Given Post login Admin with valid json
    When Send request post login
    Then Should return 200 OK
    And Validate json schema login admin

  Scenario:Post Login Admin with Invalid Data
    Given Post login Admin with Invalid json
    When Send request post login
    Then Should return 404 Not Found

  Scenario:Post Login Admin with Empty Email
    Given Post login Admin with Empty Email
    When Send request post login
    Then Should return 400 Bad Request

  Scenario:Post Login Admin with Empty Password
    Given Post login Admin with Empty Password
    When Send request post login
    Then Should return 400 Bad Request



