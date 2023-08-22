Feature: POST Add Comments on forum by Mentor
  Background: Login Mentor
    Given Post login user with valid json
    When Send request post login
    And Set token to Token Mentor

#  Scenario: POST Add mentor comment with valid id forum and valid caption data
#    Given Mentor set id status to 3 and comment "SEMANGAT SEMUANYA"
#    When Mentor send request post comment status
#    Then Should return 201 Created
#    And Validate response body should display message "success insert comment"
#    And Validate json schema add comment by mentor

  @Test @Mentor @Status-Mentor @Positive-Case #MNTR-060
  Scenario Outline: POST Add mentor comment with valid id forum and valid caption data
    Given Mentor set valid ID status <id_status> and comment with valid JSON "AddCommentMentorWithValidData.json"
    When Mentor send request post comment status
    Then Should return 201 Created
    And Validate response body should display message "success insert comment"
    And Validate json schema add comment by mentor
    Examples:
      | id_status |
      | 3         |

  @Test @Mentor @Status-Mentor @Negative-Case #MNTR-061
  Scenario Outline: POST Add mentor comment with invalid id forum and valid caption data
    Given Mentor set invalid ID "<id_status>" and comment with valid JSON "AddCommentMentorWithValidData.json"
    When Mentor send request post comment status
    Then Should return 400 Bad Request
    And Validate response body should display message "Not Found"
    Examples:
      | id_status |
      | !@#$%     |

  @Test @Mentor @Status-Mentor @Negative-Case #MNTR-062
  Scenario Outline: POST Add mentor comment with unregistered id forum and valid caption data
    Given Mentor set valid ID status <id_status> and comment with valid JSON "AddCommentMentorWithValidData.json"
    When Mentor send request post comment status
    Then Should return 400 Bad Request
    And Validate response body should display message "Not Found"
    Examples:
      | id_status |
      | 999       |

  @Test @Mentor @Status-Mentor @Positive-Case #MNTR-063
  Scenario Outline: POST Add mentor comment with valid id forum and numeric caption data
    Given Mentor set valid ID status <id_status> and comment with valid JSON "AddCommentMentorWithNumericData.json"
    When Mentor send request post comment status
    Then Should return 201 Created
    And Validate response body should display message "success insert comment"
    And Validate json schema add comment by mentor
    Examples:
      | id_status |
      | 3         |

  @Test @Mentor @Status-Mentor @Positive-Case #MNTR-064
  Scenario Outline: POST Add mentor comment with valid id forum and special char. caption data
    Given Mentor set valid ID status <id_status> and comment with valid JSON "AddCommentMentorWithSpecialChar.json"
    When Mentor send request post comment status
    Then Should return 201 Created
    And Validate response body should display message "success insert comment"
    And Validate json schema add comment by mentor
    Examples:
      | id_status |
      | 3         |

  @Test @Mentor @Status-Mentor @Negative-Case #MNTR-065
  Scenario Outline: POST Add mentor comment with valid id forum and empty caption data
    Given Mentor set valid ID status <id_status> and comment with valid JSON "AddCommentMentorWithEmpty.json"
    When Mentor send request post comment status
    Then Should return 400 Bad Request
    And Validate response body should display message "Not Found"
    Examples:
      | id_status |
      | 3         |

    #AddStatusByMentor -WAHID