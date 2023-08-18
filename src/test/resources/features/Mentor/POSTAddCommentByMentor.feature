Feature: POST Add Comments on forum by Mentor
  Background: Login Mentor
    Given Post login user with valid json
    When Send request post login
    And Set token to Token Mentor

  Scenario: POST Add mentor comment with valid id forum and valid caption data
    Given Mentor set id status to 3 and comment "SEMANGAT SEMUANYA"
    When Mentor send request post comment status
    Then Should return 201 Created
    And Validate response body should display message "success insert comment"
    And Validate json schema add comment by mentor


#  Scenario Outline: POST Add mentor comment with valid id forum and valid caption data
#    Given Mentor set valid ID status <id_status> and comment with valid JSON "AddCommentMentorWithValidData.json"
#    When Mentor send request post comment status
#    Then Should return 201 Created
#    And Validate response body should display message "success insert comment"
#    And Validate json schema add comment by mentor
#    Examples:
#      | id_status |
#      | 64        |

#  Scenario Outline: POST Add mentor comment with invalid id forum and valid caption data
#    Given Mentor set invalid ID <id_status> and comment with valid JSON "AddCommentMentorWithValidData.json"
#  Scenario Outline: POST Add mentor comment with unregistered id forum and valid caption data
#  Scenario Outline: POST Add mentor comment with valid id forum and numeric caption data
#  Scenario Outline: POST Add mentor comment with valid id forum and special char. caption data
#  Scenario Outline: POST Add mentor comment with valid id forum and empty caption data