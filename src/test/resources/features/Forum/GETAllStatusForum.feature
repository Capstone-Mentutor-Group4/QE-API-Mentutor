Feature: Get All Status by mentor & mentee
  Background: Login As A Mentee
    Given Post login mentee with valid json
    Given Post login user with valid json
    When Send request post login
    And Set token to Token Mentee
    And Set token to Token Mentor

  @Test @Mentor @GETStatus @Positive-Case #GFM-001
  Scenario: GET All Status by mentor & mentee with Token Mentee
    Given Mentee get all status using valid path with authorization
    When User send request get all status
    Then Should return 200 OK
    And Validate response body should display message "success get all status"

  @Test @Mentor @GETStatus @Negative-Case #GFM-004
  Scenario: GET All Status by mentor & mentee without Token
    Given Mentee get all status using valid path without authorization
    When User send request get all status
    Then Should return 400 Bad Request
    And Validate response body should display message "missing or malformed jwt"

  @Test @Mentor @GETStatus @Positive-Case #GFM-005
  Scenario: GET Check Status by mentor & mentee when the status comment User is deleted
    Given Mentee get all status using valid path with authorization
    When User send request get all status
    Then Should return 200 OK
    And Validate response body should display message "success get all status"

  @Test @Mentor @GETStatus @Positive-Case #GFM-002
  Scenario: GET All Status by mentor & mentee with Token Mentor
    Given User get all status using valid path with Token Mentor
    When User send request get all status
    Then Should return 200 OK
    And Validate response body should display message "success get all status"

  @Test @Mentor @Status @Positive-Case #GFM-003
  Scenario: GET All Status by mentor & mentee with Token Admin
    Given User get all status using valid path with Token Admin
    When User send request get all status
    Then Should return 200 OK
    And Validate response body should display message "success get all status"

    #GET-ALL-STATUS -WAHID
