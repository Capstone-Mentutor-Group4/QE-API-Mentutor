Feature: POST Submit Score by Mentor
  Background: Login Mentor
    Given Post login user with valid json
    When Send request post login
    And Set token to Token Mentor

  @Test @Mentor @Score-Mentor @Positive-Case #MNTR-052
  Scenario Outline: POST Add task score with valid id task and valid score data
    Given Mentor set id task <id_task>, id submission <id_submission>, and score <score>
    When Mentor send request post add task score
    Then Should return 201 Created
    And Validate response body should display message "success insert score"
    And Validate json schema submit score task by mentor
    Examples:
      | id_task | id_submission | score |
      | 34      | 12            | 95    |

  @Test @Mentor @Score-Mentor @Negative-Case #MNTR-053
  Scenario Outline: POST Add task score with invalid id task and valid score data
    Given Mentor set id task "<id_task>", id submission <id_submission>, and score <score>
    When Mentor send request post add task score
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"
    Examples:
      | id_task | id_submission | score |
      | test    | 12            | 95    |

  @Test @Mentor @Score-Mentor @Negative-Case #MNTR-054
  Scenario Outline: POST Add task score with unregisted id task and valid score data
    Given Mentor set id task <id_task>, id submission <id_submission>, and score <score>
    When Mentor send request post add task score
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"
    Examples:
      | id_task | id_submission | score |
      | 11111   | 12            | 95    |

  @Test @Mentor @Score-Mentor @Negative-Case #MNTR-055
  Scenario Outline: POST Add task score with valid id task and decimal score data
    Given Mentor set id task <id_task>, id submission <id_submission>, and float score <score>
    When Mentor send request post add task score
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"
    Examples:
      | id_task | id_submission | score |
      | 34      | 12            | 80.5  |

  @Test @Mentor @Score-Mentor @Negative-Case #MNTR-056
  Scenario Outline: POST Add task score with valid id task and string score data
    Given Mentor set id task <id_task>, id submission <id_submission>, and score "<score>"
    When Mentor send request post add task score
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"
    Examples:
      | id_task | id_submission | score   |
      | 34      | 12            | seratus |

  @Test @Mentor @Score-Mentor @Negative-Case #MNTR-057
  Scenario Outline: POST Add task score with valid id task and special char. score data
    Given Mentor set id task <id_task>, id submission <id_submission>, and score "<score>"
    When Mentor send request post add task score
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"
    Examples:
      | id_task | id_submission | score |
      | 34      | 12            | !@#$% |

  @Test @Mentor @Score-Mentor @Negative-Case #MNTR-058
  Scenario Outline: POST Add task score with valid id task and empty score data
    Given Mentor set id task <id_task>, id submission <id_submission> and empty score
    When Mentor send request post add task score
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"
    Examples:
      | id_task | id_submission |
      | 34      | 12            |

  @Test @Mentor @Score-Mentor @Negative-Case #MNTR-059
  Scenario Outline: POST Add task score when User Mentee is deleted
    Given Mentor set id task <id_task>, id submission <id_submission>, and score <score>
    When Mentor send request post add task score
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"
    Examples:
      | id_task | id_submission | score |
      | 34      | 25            | 95    |

    #SUBMIT SCORE-WAHID