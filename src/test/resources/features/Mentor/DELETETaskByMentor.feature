Feature: DELETE Task by Mentor
  Background: Login Mentor
    Given Post login user with valid json
    When Send request post login
    And Set token to Token Mentor

  @Test @Mentor @Delete @Positive-Case #MNTR-066
  Scenario: DELETE Task with valid id task
    Given Mentor set id task to 9
    When Mentor send request delete task
    Then Should return 201 Created
    And Validate response body should display message "Delete Success"

  @Test @Mentor @Delete @Negative-Case #MNTR-067
  Scenario: DELETE Task with invalid id task
    Given Mentor set id task to "cembilan!@"
    When Mentor send request delete task
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"

  @Test @Mentor @Delete @Negative-Case #MNTR-068
  Scenario: DELETE Task with unregistered id task
    Given Mentor set id task to 999
    When Mentor send request delete task
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"

  @Test @Mentor @Delete @Negative-Case #MNTR-069
  Scenario: DELETE Task with empty id task
    Given Mentor set id task empty
    When Mentor send request delete task
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"

  @Test @Mentor @Delete @Negative-Case #MNTR-070
  Scenario: DELETE Task without Mentor Token
    Given Mentor set id task to 10 without token mentor
    When Mentor send request delete task
    Then Should return 400 Bad Request
    And Validate response body should display message "missing or malformed jwt"

    #DELETE TASK-WAHID