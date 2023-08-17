Feature: POST Add Task by Mentor
  Background: Login Mentor
    Given Post login user with valid json
    When Send request post login
    And Set token to Token Mentor

  @Test @Mentor @AddTask @Positive-Case #MNTR-021
  Scenario: POST Create task with all valid data
    Given Mentor set create task will valid JSON "AddTaskWithValidData.json"
    When User send request post create task
    Then Should return 201 Created
    And Validate response body should display message "Success insert task"
    And Validate json schema create task by mentor

  @Test @Mentor @AddTask @Positive-Case #MNTR-022
  Scenario: POST Create task with input numeric on title
    Given Mentor set create task will valid JSON "AddTaskWithNumericTitle.json"
    When User send request post create task
    Then Should return 201 Created
    And Validate response body should display message "Success insert task"
    And Validate json schema create task by mentor

  @Test @Mentor @AddTask @Positive-Case #MNTR-023
  Scenario: POST Create task with input special char. on title
    Given Mentor set create task will valid JSON "AddTaskWithSpecialCharTitle.json"
    When User send request post create task
    Then Should return 201 Created
    And Validate response body should display message "Success insert task"
    And Validate json schema create task by mentor

  @Test @Mentor @AddTask @Negative-Case #MNTR-024
  Scenario: POST Create task with input more than max char on title
    Given Mentor set create task will valid JSON "AddTaskWithMaxCharTitle.json"
    When User send request post create task
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"

  @Test @Mentor @AddTask @Positive-Case #MNTR-025
  Scenario: POST Create task with input numeric on description
    Given Mentor set create task will valid JSON "AddTaskWithNumericDesc.json"
    When User send request post create task
    Then Should return 201 Created
    And Validate response body should display message "Success insert task"
    And Validate json schema create task by mentor

  @Test @Mentor @AddTask @Positive-Case #MNTR-026
  Scenario: POST Create task with input special char. on description
    Given Mentor set create task will valid JSON "AddTaskWithSpecialCharDesc.json"
    When User send request post create task
    Then Should return 201 Created
    And Validate response body should display message "Success insert task"
    And Validate json schema create task by mentor

  @Test @Mentor @AddTask @Negative-Case #MNTR-027
  Scenario: POST Create task with input more than max char on description
    Given Mentor set create task will valid JSON "AddTaskWithMaxCharDesc.json"
    When User send request post create task
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"

  @Test @Mentor @AddTask @Negative-Case #MNTR-028
  Scenario Outline: POST Create task with invalid Images extension
    Given Mentor set create task with Title "<Title>", Description "<Description>",Images "<Images>",File "<File>", Time "<Time>"
    When User send request post create task
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"
    Examples:
      | Title          | Description            | Images   | File     | Time       |
      | API Automation | Membuat API Automation | tes1.pdf | tes1.pdf | 2023-08-25 |

  @Test @Mentor @AddTask @Negative-Case #MNTR-029
  Scenario Outline: POST Create task with invalid File extension
    Given Mentor set create task with Title "<Title>", Description "<Description>",Images "<Images>",File "<File>", Time "<Time>"
    When User send request post create task
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"
    Examples:
      | Title          | Description            | Images    | File      | Time       |
      | API Automation | Membuat API Automation | test1.PNG | test1.PNG | 2023-08-25 |

  @Test @Mentor @AddTask @Negative-Case #MNTR-030
  Scenario Outline: POST Create task with input invalid time format
    Given Mentor set create task with Title "<Title>", Description "<Description>",Images "<Images>",File "<File>", Time "<Time>"
    When User send request post create task
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"
    Examples:
      | Title          | Description            | Images    | File     | Time            |
      | API Automation | Membuat API Automation | test1.PNG | tes1.pdf | 08-2023-25      |
      | API Automation | Membuat API Automation | test1.PNG | tes1.pdf | 2023/08/25      |
      | API Automation | Membuat API Automation | test1.PNG | tes1.pdf | 25-Agustus-2023 |

  @Test @Mentor @AddTask @Negative-Case #MNTR-031
  Scenario Outline: POST Create task with input incomplete data
    Given Mentor set create task incomplete data with Title "<Title>", Description "<Description>",Images "<Images>",File "<File>", Time "<Time>"
    When User send request post create task
    Then Should return 400 Bad Request
    Examples:
      | Title          | Description            | Images    | File     | Time       |
      |                | Membuat API Automation | test1.PNG | tes1.pdf | 2023-08-25 |
      | API Automation |                        | test1.PNG | tes1.pdf | 2023-08-25 |
      | API Automation | Membuat API Automation |           | tes1.pdf | 2023-08-25 |
      | API Automation | Membuat API Automation | test1.PNG |          | 2023-08-25 |
      | API Automation | Membuat API Automation | test1.PNG | tes1.pdf |            |

  @Test @Mentor @AddTask @Negative-Case #MNTR-032
  Scenario: POST Create task with empty data
    Given Mentor set create task will valid JSON "AddTaskWithEmptyData.json"
    When User send request post create task
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"

#  Scenario Outline: POST Create task with all valid data
#    Given Mentor set create task with Title "<Title>", Description "<Description>",Images "<Images>",File "<File>", Time "<Time>"
#    When User send request post create task
#    Then Should return 201 Created
#    And Validate response body should display message "Success insert task"
#    And Validate json schema create task by mentor
#    Examples:
#      | Title          | Description            | Images    | File     | Time       |
#      | API Automation | Membuat API Automation | test1.PNG | tes1.pdf | 2023-08-25 |