Feature: Get All Task as Mentor
  Background: Login Mentor
    Given Post login user with valid json
    When Send request post login
    And Set token to Token Mentor

  @Test @Mentor @GET @Positive-Case #MNTR-033
  Scenario: GET All task with valid id mentor
    Given Mentor get all task with valid id mentor
    When Mentor send request get all task
    Then Should return 201 Created
    And Validate response body should display message "Success get all task"
    And Validate json schema get all task by mentor

  @Test @Mentor @GET @Negative-Case #MNTR-034
  Scenario: GET All task without Token Mentor
    Given Mentor get all task without token mentor
    When Mentor send request get all task
    Then Should return 400 Bad Request
    And Validate response body should display message "missing or malformed jwt"

