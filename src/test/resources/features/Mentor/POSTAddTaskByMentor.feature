Feature: POST Add Task by Mentor
  Background: Login Mentor
    Given Post login user with valid json
    When Send request post login
    And Set token to Token Mentor

#  Scenario: POST Create task with all valid data
#    Given Mentor set create task will valid JSON "AddTaskWithValidData.json"
#    When User send request post create task
#    Then Should return 201 Created
#    And Validate response body should display message "Success insert task"
#    And Validate json schema create task by mentor

  Scenario Outline: POST Create task with all valid data
    Given Mentor set create task with Title "<Title>", Description "<Description>",Images "<Images>",File "<File>", Time "<Time>"
    When User send request post create task
    Then Should return 201 Created
    And Validate response body should display message "Success insert task"
    And Validate json schema create task by mentor
    Examples:
      | Title          | Description            | Images    | File      | Time       |
      | API Automation | Membuat API Automation | test1.PNG | test1.pdf | 2023-08-25 |

