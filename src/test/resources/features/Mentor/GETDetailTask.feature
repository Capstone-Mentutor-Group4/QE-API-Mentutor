Feature: Get Detail Task as Mentor
  Background: Login Mentor
    Given Post login user with valid json
    When Send request post login
    And Set token to Token Mentor

  @Test @Mentor @GET @Positive-Case #MNTR-035
  Scenario: GET Detail task with valid id task
    Given Mentor set id task to 3
    When Mentor send request get detail task
    Then Should return 201 Created
    And Validate response body should display message "success get single task"
    And Validate json schema get detail task by mentor

  @Test @Mentor @GET @Negative-Case #MNTR-036
  Scenario: GET Detail task with invalid id task
    Given Mentor set id task to "Tiga"
    When Mentor send request get detail task
    Then Should return 404 Not Found
    And Validate response body should display error message "Task not found"

  @Test @Mentor @GET @Positive-Case #MNTR-037
  Scenario: GET Detail task with unregisted id task
    Given Mentor set id task to 111
    When Mentor send request get detail task
    Then Should return 404 Not Found
    And Validate response body should display error message "Task not found"

  @Test @Mentor @GET @Positive-Case #MNTR-038
  Scenario: GET Detail task without Mentor Token
    Given Mentor set id task to 3 without token mentor
    When Mentor send request get detail task
    Then Should return 400 Bad Request
    And Validate response body should display message "missing or malformed jwt"