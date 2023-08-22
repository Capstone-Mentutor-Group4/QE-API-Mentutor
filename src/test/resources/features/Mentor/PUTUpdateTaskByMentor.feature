Feature: PUT Update Task as Mentor
  Background: Login Mentor
    Given Post login user with valid json
    When Send request post login
    And Set token to Token Mentor

  @Test @Mentor @UpdateTask @Positive-Case #MNTR-039
  Scenario Outline: PUT Update task with valid id task and valid data
    Given Mentor set request update task with valid ID <id> and valid JSON "UpdateTaskWithValidData.json"
    When Mentor send request put update task
    Then Should return 201 Created
    And Validate response body should display message "success get single task"
    And Validate json schema update task by mentor
    Examples:
      | id |
      | 7  |

  @Test @Mentor @UpdateTask @Negative-Case #MNTR-040
  Scenario Outline: PUT Update task with invalid id task and valid data
    Given Mentor set request update task with invalid ID "<id>" and valid JSON "UpdateTaskWithValidData.json"
    When Mentor send request put update task
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"
    Examples:
      | id    |
      | Tujuh |

  @Test @Mentor @UpdateTask @Negative-Case #MNTR-041
  Scenario: PUT Update task without id task and valid data
    Given Mentor set request update task without ID Task and valid JSON "UpdateTaskWithValidData.json"
    When Mentor send request put update task
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"

  @Test @Mentor @UpdateTask @Negative-Case #MNTR-042
  Scenario Outline: PUT Update task with unregisted id task and valid data
    Given Mentor set request update task with valid ID <id> and valid JSON "UpdateTaskWithValidData.json"
    When Mentor send request put update task
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"
    Examples:
      | id  |
      | 111 |

  @Test @Mentor @UpdateTask @Positive-Case #MNTR-043
  Scenario Outline: PUT Update task with valid id task and numeric on title
    Given Mentor set request update task with valid ID <id> and valid JSON "UpdateTaskWithNumericTitle.json"
    When Mentor send request put update task
    Then Should return 201 Created
    And Validate response body should display message "success get single task"
    And Validate json schema update task by mentor
    Examples:
      | id |
      | 7  |

  @Test @Mentor @UpdateTask @Positive-Case #MNTR-044
  Scenario Outline: PUT Update task with valid id task and special char. on title
    Given Mentor set request update task with valid ID <id> and valid JSON "UpdateTaskWithSpecialCharTitle.json"
    When Mentor send request put update task
    Then Should return 201 Created
    And Validate response body should display message "success get single task"
    And Validate json schema update task by mentor
    Examples:
      | id |
      | 7  |

  @Test @Mentor @UpdateTask @Negative-Case #MNTR-045
  Scenario Outline: PUT Update task with valid id task and more than max char. on title
    Given Mentor set request update task with valid ID <id> and valid JSON "UpdateTaskWithMaxCharTitle.json"
    When Mentor send request put update task
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"
    Examples:
      | id |
      | 7  |

  @Test @Mentor @UpdateTask @Positive-Case #MNTR-046
  Scenario Outline: PUT Update task with valid id task and numeric on description
    Given Mentor set request update task with valid ID <id> and valid JSON "UpdateTaskWithNumericDesc.json"
    When Mentor send request put update task
    Then Should return 201 Created
    And Validate response body should display message "success get single task"
    And Validate json schema update task by mentor
    Examples:
      | id |
      | 7  |

  @Test @Mentor @UpdateTask @Positive-Case #MNTR-047
  Scenario Outline: PUT Update task with valid id task and special char. on description
    Given Mentor set request update task with valid ID <id> and valid JSON "UpdateTaskWithSpecialCharDesc.json"
    When Mentor send request put update task
    Then Should return 201 Created
    And Validate response body should display message "success get single task"
    And Validate json schema update task by mentor
    Examples:
      | id |
      | 7  |

  @Test @Mentor @UpdateTask @Negative-Case #MNTR-048
  Scenario Outline: PUT Update task with valid id task and more than max char. on description
    Given Mentor set request update task with valid ID <id> and valid JSON "UpdateTaskWithMaxCharDesc.json"
    When Mentor send request put update task
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"
    Examples:
      | id |
      | 7  |

  @Test @Mentor @UpdateTask @Negative-Case #MNTR-049
  Scenario Outline: PUT Update task with valid id task and invalid Image extension
    Given Mentor set request update task with valid ID <id>, Title "<Title>", Description "<Description>", Images "<Images>", File "<File>", Time "<Time>"
    When Mentor send request put update task
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"
    Examples:
      | id | Title   | Description        | Images   | File     | Time       |
      | 7  | API OKE | API Automation WOW | tes3.pdf | tes3.pdf | 2023-08-21 |

  @Test @Mentor @UpdateTask @Negative-Case #MNTR-050
  Scenario Outline: PUT Update task with valid id task and invalid File extension
    Given Mentor set request update task with valid ID <id>, Title "<Title>", Description "<Description>", Images "<Images>", File "<File>", Time "<Time>"
    When Mentor send request put update task
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"
    Examples:
      | id | Title   | Description        | Images    | File      | Time       |
      | 7  | API OKE | API Automation WOW | test3.PNG | test3.PNG | 2023-08-21 |

  @Test @Mentor @UpdateTask @Negative-Case #MNTR-051 #Manual-Fail #Automate-Success
  Scenario Outline: PUT Update task with valid id task and invalid date time format
    Given Mentor set request update task with valid ID <id>, Title "<Title>", Description "<Description>", Images "<Images>", File "<File>", Time "<Time>"
    When Mentor send request put update task
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"
    Examples:
      | id | Title   | Description        | Images   | File     | Time            |
      | 7  | API OKE | API Automation WOW | tes3.pdf | tes3.pdf | 08-2023-25      |
      | 7  | API OKE | API Automation WOW | tes3.pdf | tes3.pdf | 2023/08/25      |
      | 7  | API OKE | API Automation WOW | tes3.pdf | tes3.pdf | 25-Agustus-2023 |

    #UPDATE TASK-WAHID