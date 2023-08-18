Feature: POST Add Status by Mentee
  Background: Login As A Mentee
    Given Post login mentee with valid json
    When Send request post login
    And Set token to Token Mentee

  @Test @Mentor @Status @Positive-Case #PFM-001
  Scenario: POST Add status with valid data and Token Authorized
    Given Mentee post add status with set request body caption "Apakah bisa pecahkan kasus A?" and images "gambar1.jpg"
    When Mentee send request post status
    Then Should return 201 Created
    And Validate response body should display message "success add status"
    And Validate json schema post status by mentee

  @Test @Mentor @Status @Negative-Case #PFM-002
  Scenario: POST Add status with valid data and Without Token
    Given Mentee without token post add status with set request body caption "Apakah bisa pecahkan kasus A?" and images "gambar1.jpg"
    When Mentee send request post status
    Then Should return 400 Bad Request
    And Validate response body should display message "missing or malformed jwt"

  @Test @Mentor @Status @Negative-Case #PFM-003
  Scenario: POST Add status with valid data and With Token Admin
    Given Mentee with Token Admin post add status with set request body caption "Apakah bisa pecahkan kasus A?" and images "gambar1.jpg"
    When Mentee send request post status
    Then Should return 400 Bad Request
    And Validate response body should display message "missing or malformed jwt"

  @Test @Mentor @Status @Negative-Case #PFM-004
  Scenario: POST Add status with valid data and With Token Mentor
    Given Mentee with Token Mentor post add status with set request body caption "Apakah bisa pecahkan kasus A?" and images "gambar1.jpg"
    When Mentee send request post status
    Then Should return 400 Bad Request
    And Validate response body should display message "missing or malformed jwt"

  @Test @Mentor @Status @Positive-Case #PFM-005
  Scenario: POST Add status with Numeric on Caption
    Given Mentee post add status with set request body caption 1234567890 and images "gambar1.jpg"
    When Mentee send request post status
    Then Should return 201 Created
    And Validate response body should display message "success add status"
    And Validate json schema post status by mentee

  @Test @Mentor @Status @Positive-Case #PFM-006
  Scenario: POST Add status with Special Char. on Caption
    Given Mentee post add status with set request body caption "!@#$%^&*()_+" and images "gambar1.jpg"
    When Mentee send request post status
    Then Should return 201 Created
    And Validate response body should display message "success add status"
    And Validate json schema post status by mentee

  @Test @Mentor @Status @Negative-Case #PFM-007
  Scenario: POST Add status empty on Caption
    Given Mentee post add status with set request body caption " " and images "gambar1.jpg"
    When Mentee send request post status
    Then Should return 400 Bad Request
    And Validate response body should display message "Invalid Input From Client"

  @Test @Mentor @Status @Negative-Case #PFM-008
  Scenario: POST Add status with invalid Images Extension on Images
    Given Mentee post add status with set request body caption "Apakah bisa pecahkan kasus A?" and images "tes1.pdf"
    When Mentee send request post status
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"

  @Test @Mentor @Status @Positive-Case #PFM-009
  Scenario: POST Add status with empty Images
    Given Mentee post add status with set request body caption "Apakah bisa pecahkan kasus A?"
    When Mentee send request post status
    Then Should return 201 Created
    And Validate response body should display message "success add status"
    And Validate json schema post status by mentee

  @Test @Mentor @Status @Negative-Case #PFM-010
  Scenario: POST Add status empty
    Given Mentee post add status with empty data
    When Mentee send request post status
    Then Should return 400 Bad Request
    And Validate response body should display message "Invalid Input From Client"

    #POST STATUS MENTEE - WAHID


