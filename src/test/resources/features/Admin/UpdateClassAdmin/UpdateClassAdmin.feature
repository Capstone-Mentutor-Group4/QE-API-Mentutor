Feature: Update Class Admin

  @UpdateClass @TokenAdmin
  Scenario Outline: Put update class with valid class_name
    Given Put update class with id <id> and set class_name "<class_name>" and status "<status>"
    When Send request put update class
    Then Should return 201 Created
    Examples:
      | id | class_name       | status |
      | 21 | Quality Engineer | active |

#    Bug response seharusnya 400 tetapi 201
  @UpdateClass @TokenAdmin
  Scenario Outline: Put update class with valid status
    Given Put update class with id <id> and set class name "<class_name>" and set status to "<status>"
    When Send request put update class
    Then Should return 201 Created
    Examples:
      | id | class_name       | status     |
      | 21 | Quality Engineer | non_active |

  @UpdateClass @TokenAdmin
  Scenario Outline: Put update class with empty class name parameter
    Given Put update class with id <id>, set class_name "<class_name>"  set status "<status>"
    When Send request put update class
    Then Should return 400 Bad Request
    Examples:
      | id | class_name | status |
      | 21  |            | active |

 #BUG bisa pdate tanpa status
  @UpdateClass @TokenAdmin
  Scenario Outline: Put update class with empty status parameter
    Given Put update class with id <id>, set class_name "<class_name>" and set empty status "<status>"
    When Send request put update class
    Then Should return 400 Bad Request
    Examples:
      | id | class_name        | status |
      | 21 | Quality Assurance |        |


