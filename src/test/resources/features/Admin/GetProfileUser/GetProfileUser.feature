Feature: Get Profile User Mentutor API

  @TokenAdmin
  Scenario Outline: Get Profile User with valid id and Authorization
    Given Get Profile User with Valid id <id_user>
    When Send request get profile user
    Then Should return 200 OK
    Examples:
      | id_user |
      | 10      |

  Scenario Outline: Get Profile User without Authorization
    Given Get Profile User with Valid id <id_user> without Authorization
    When Send request get profile user
    Then Should return 400 Bad Request
    Examples:
      | id_user |
      | 10      |

  Scenario Outline: Get Profile User with unregisted id
    Given Get Profile User with unregisted id <id_user>
    When Send request get profile user
    Then Should return 404 Not Found
    Examples:
      | id_user |
      | 100     |