Feature: Delete User by Admin Mentutor API

  @DeleteUser @TokenAdmin
  Scenario Outline: Delete User with valid id user
    Given Delete user with valid id <id_user>
    When Send request delete user
    Then Should return 200 OK
    Examples:
      | id_user |
      | 44      |

  @DeleteUser @TokenAdmin
  Scenario Outline: Delete User with invalid id user
    Given Delete user with invalid id <id_user>
    When Send request delete user
    Then Should return 400 Bad Request
    Examples:
      | id_user |
      | 150     |

  @DeleteUser
  Scenario Outline: Delete User with valid id user without Authorization
    Given Delete user without Authorization and valid id <id_user>
    When Send request delete user
    Then Should return 401 Unauthorized
    Examples:
      | id_user |
      | 21      |