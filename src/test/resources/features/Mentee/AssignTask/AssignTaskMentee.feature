Feature: Assign Task by Mentee Mentutor API

  @Assign @TokenMentee
  Scenario Outline: Post Assign task mentee with valid id and valid data
    Given Assign Task with valid id <id_task> and valid data "<file>"
    When User send request post create task
    Then Should return 201 Created
    Examples:
      | id_task | file                       |
      | 12      | /tugas_bilangan_cacah2.pdf |

  @Assign @TokenMentee
  Scenario Outline: Post Assign task mentee with invalid id and valid data
    Given Assign Task with invalid id "<id_task>" and valid data "<file>"
    When User send request post create task
    Then Should return 400 Bad Request
    Examples:
      | id_task | file                       |
      | dualima | /tugas_bilangan_cacah2.pdf |

  @Assign @TokenMentee
  Scenario Outline: Post Assign task mentee with unregisted id and valid data
    Given Assign Task with unregisted id <id_task> and valid data "<file>"
    When User send request post create task
    Then Should return 400 Bad Request
    Examples:
      | id_task | file                       |
      | 100     | /tugas_bilangan_cacah2.pdf |

  @Assign @TokenMentee
  Scenario Outline: Post Assign task mentee with invalid data
    Given Assign Task with unregisted id <id_task> and invalid data "<file>"
    When User send request post create task
    Then Should return 400 Bad Request
    Examples:
      | id_task | file                      |
      | 13       | /tugas_bilangan_cacah.mp4 |

  @Assign @TokenAdmin
  Scenario Outline: Post Assign task mentee with Admin Token
    Given Assign Task with valid id <id_task> and data "<file>" admin token
    When User send request post create task
    Then Should return 400 Bad Request
    Examples:
      | id_task | file                       |
      | 10      | /tugas_bilangan_cacah2.pdf |

  @Assign
  Scenario Outline: Post Assign task mentee without Authorization
    Given Assign Task with valid id <id_task> and data "<file>" without Authorization
    When User send request post create task
    Then Should return 400 Bad Request
    Examples:
      | id_task | file                       |
      | 10      | /tugas_bilangan_cacah2.pdf |
