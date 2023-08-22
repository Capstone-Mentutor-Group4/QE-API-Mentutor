Feature: Register user Mentutor API

  @RegisterUser @TokenAdmin
  Scenario: Post Register user Mentutor API
    Given Register user with valid json
    When Send request post register user
    Then Should return 201 Created

  @RegisterUser
  Scenario: Post Register user Without Token Mentutor API
    Given Register user with valid json and without Authorization
    When Send request post register user
    Then Should return 401 Unauthorized

  @RegisterUser  @TokenAdmin
  Scenario: Post Register user With one field empty Body Json Mentutor API
    Given Register user with empty one field body json
    When Send request post register user
    Then Should return 400 Bad Request

  @RegisterUser @TokenAdmin
  Scenario: Post Register user numeric name parameter Mentutor API
    Given Register numeric name parameter
    When Send request post register user
    Then Should return 400 Bad Request

  @RegisterUser @TokenAdmin
  Scenario: Post Register user Special Character name parameter Mentutor API
    Given Register user with Special Character on name parameter
    When Send request post register user
    Then Should return 400 Bad Request

  @RegisterUser @TokenAdmin
  Scenario: Post Register user numeric on password parameter Mentutor API
    Given Register user numeric on password parameter
    When Send request post register user
    Then Should return 400 Bad Request

  @RegisterUser @TokenAdmin
  Scenario: Post Register user Special Character on password parameter Mentutor API
    Given Register user Special Character on password parameter
    When Send request post register user
    Then Should return 400 Bad Request
