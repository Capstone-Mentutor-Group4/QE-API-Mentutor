Feature: PUT Update Profile User as Mentor
  Background: Login Mentor
    Given Post login user with valid json
    When Send request post login
    And Set token to Token Mentor

  @Test @Mentor @UpdateProfile @Positive-Case
  Scenario: PUT Update profile mentor with all valid data
    Given Mentor set request update profile with valid JSON "UpdateProfileWithValidData.json"
    When User send request put update data
    Then Should return 201 Created
    And Validate response body should display message "success update profile"
    And Validate json schema update profile mentor

  @Test @Mentor @UpdateProfile @Negative-Case
  Scenario: PUT Update profile Mentor with valid data and without authorization
    Given Mentor set request update profile with valid JSON "UpdateProfileWithValidData.json" and without authorization
    When User send request put update data
    Then Should return 400 Bad Request
    And Validate response body should display message "missing or malformed jwt"

  @Test @Mentor @UpdateProfile @Negative-Case
  Scenario: PUT Update profile Mentor with input Numeric on key name
    Given Mentor set request update profile with valid JSON "UpdateProfileNameNumeric.json"
    When User send request put update data
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"

  @Test @Mentor @UpdateProfile @Negative-Case
  Scenario: PUT Update profile Mentor with input Special Char. on key name
    Given Mentor set request update profile with valid JSON "UpdateProfileNameSpecialChar.json"
    When User send request put update data
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"

  @Test @Mentor @UpdateProfile @Negative-Case
  Scenario: PUT Update profile Mentor with input more than max. char on key name
    Given Mentor set request update profile with valid JSON "UpdateProfileNameMaxChar.json"
    When User send request put update data
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"

  @Test @Mentor @UpdateProfile @Negative-Case
  Scenario: PUT Update profile Mentor without input "@" char. on key email
    Given Mentor set request update profile with valid JSON "UpdateProfileEmailWithout@.json"
    When User send request put update data
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"

  @Test @Mentor @UpdateProfile @Positive-Case
  Scenario: PUT Update profile Mentor with input capital alphabet on key email
    Given Mentor set request update profile with valid JSON "UpdateProfileEmailWithCapital.json"
    When User send request put update data
    Then Should return 201 Created
    And Validate response body should display message "success update profile"
    And Validate json schema update profile mentor

  @Test @Mentor @UpdateProfile @Negative-Case
  Scenario: PUT Update profile Mentor with input more than max. char. on key email
    Given Mentor set request update profile with valid JSON "UpdateProfileEmailMaxChar.json"
    When User send request put update data
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"

  @Test @Mentor @UpdateProfile @Negative-Case
  Scenario: PUT Update profile Mentor with input space ( ) char. on key email
    Given Mentor set request update profile with valid JSON "UpdateProfileEmailWithSpace.json"
    When User send request put update data
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"

  @Test @Mentor @UpdateProfile @Negative-Case
  Scenario: PUT Update profile Mentor with input alphabet only on key password
    Given Mentor set request update profile with valid JSON "UpdateProfilePasswordAlphabetOnly.json"
    When User send request put update data
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"

  @Test @Mentor @UpdateProfile @Negative-Case
  Scenario: PUT Update profile Mentor with input numeric only on key password
    Given Mentor set request update profile with valid JSON "UpdateProfilePasswordNumericOnly.json"
    When User send request put update data
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"

  @Test @Mentor @UpdateProfile @Negative-Case
  Scenario: PUT Update profile Mentor with input special char only on key password
    Given Mentor set request update profile with valid JSON "UpdateProfilePasswordSpecialChar.json"
    When User send request put update data
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"

  @Test @Mentor @UpdateProfile @Negative-Case
  Scenario: PUT Update profile Mentor with input more than max. char. on key password
    Given Mentor set request update profile with valid JSON "UpdateProfilePasswordMaxChar.json"
    When User send request put update data
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"

  @Test @Mentor @UpdateProfile @Negative-Case
  Scenario: PUT Update profile Mentor with input less than min. char. on key password
    Given Mentor set request update profile with valid JSON "UpdateProfilePasswordMinChar.json"
    When User send request put update data
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"

  @Test @Mentor @UpdateProfile @Negative-Case
  Scenario: PUT Update profile Images Mentor with invalid Images extention
    Given Mentor set request update profile with invalid Images extention valid on JSON "UpdateProfileWithValidData.json"
    When User send request put update data
    Then Should return 400 Bad Request
    And Validate response body should display error message "Invalid Input From Client"

  @Test @Mentor @UpdateProfile @Negative-Case
  Scenario: PUT Update profile Mentor with empty data
    Given Mentor set request update profile with valid JSON "UpdateProfleWithEmpty.json"
    When User send request put update data
    Then Should return 400 Bad Request
