Feature: Login User Mentor in API
  @Test @Login @Mentor @Positive-Case #MNTR-001
  Scenario:Post Login Mentor with Valid Data
    Given Post login user with valid json
    When Send request post login
    Then Should return 200 OK
    And Validate json schema login users

  @Test @Login @Mentor @Negative-Case #MNTR-002
  Scenario:Post Login Mentor with Invalid Data
    Given Post login user with Invalid json
    When Send request post login
    Then Should return 404 Not Found

  @Test @Login @Mentor @Negative-Case #MNTR-003
  Scenario:Post Login Mentor with Empty Email
    Given Post login user with Empty Email
    When Send request post login
    Then Should return 400 Bad Request

  @Test @Login @Mentor @Negative-Case #MNTR-004
  Scenario:Post Login Mentor with Empty Password
    Given Post login user with Empty Password
    When Send request post login
    Then Should return 400 Bad Request