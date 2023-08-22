Feature: Update user Mentutor API

  @UpdateUser @TokenAdmin
  Scenario Outline: Put Update user Mentutor API
    Given Update user with valid id <id_user> set request body name "<name>", email "<email>", password "<password>", images "<images>" and id_class <id_class>
    When Send request put update user
    Then Should return 201 Created
    Examples:
      | id_user | name          | email                | password  | images     | id_class |
      | 10      | Tigor Rolando | tigorrr123@gmail.com | Tigor123$ | /gambar3.png | 1        |

  @UpdateUser
  Scenario Outline: Put Update user without Authorization Mentutor API
    Given Update user without Authorization and valid id <id_user> set request body name "<name>", email "<email>", password "<password>", images "<images>" and id_class <id_class>
    When Send request put update user
    Then Should return 400 Bad Request
    Examples:
      | id_user | name          | email                | password  | images       | id_class |
      | 10      | Tigor Rolando | tigorrr123@gmail.com | Tigor123$ | /gambar2.jpg | 1        |

  @UpdateUser @TokenAdmin
  Scenario Outline: Put Update user with Unregisted Data Mentutor API
    Given Update user with unregisted id <id_user> set request body name "<name>", email "<email>", password "<password>", images "<images>" and id_class <id_class>
    When Send request put update user
    Then Should return 404 Not Found
    Examples:
      | id_user | name            | email                | password   | images       | id_class |
      | 150     | Jajang Nurjaman | jajang123$@gmail.com | Jajang123$ | /gambar3.PNG | 1        |

  @UpdateUser @TokenAdmin
  Scenario Outline: Put Update user with numeric name parameter Mentutor API
    Given Update user with  id <id_user> set request body numeric name <name>, email "<email>", password "<password>", images "<images>" and id_class <id_class>
    When Send request put update user
    Then Should return 400 Bad Request
    Examples:
      | id_user | name     | email                | password  | images       | id_class |
      | 10      | 12345678 | tigorrr123@gmail.com | Tigor123$ | /gambar2.jpg | 1        |

  @UpdateUser @TokenAdmin
  Scenario Outline: Put Update user with Special Character name parameter Mentutor API
    Given Update user with  id <id_user> set request body Special Character name "<name>", email "<email>", password "<password>", images "<images>" and id_class <id_class>
    When Send request put update user
    Then Should return 400 Bad Request
    Examples:
      | id_user | name    | email                | password  | images       | id_class |
      | 10      | @#$%$#@ | tigorrr123@gmail.com | Tigor123$ | /gambar2.jpg | 1        |

#    BUG
  @UpdateUser @TokenAdmin
  Scenario Outline: Put Update user with empty name parameter Mentutor API
    Given Update user with  id <id_user> set request body empty name "<name>", email "<email>", password "<password>", images "<images>" and id_class <id_class>
    When Send request put update user
    Then Should return 400 Bad Request
    Examples:
      | id_user | name | email                | password  | images       | id_class |
      | 10      |      | tigorrr123@gmail.com | Tigor123$ | /gambar2.jpg | 1        |

  @UpdateUser @TokenAdmin
  Scenario Outline: Put Update user with numeric password parameter Mentutor API
    Given Update user with  id <id_user> set request body name "<name>", email "<email>", numeric password <password>, images "<images>" and id_class <id_class>
    When Send request put update user
    Then Should return 400 Bad Request
    Examples:
      | id_user | name          | email                | password | images       | id_class |
      | 10      | Tigor Rolando | tigorrr123@gmail.com | 12345678 | /gambar2.jpg | 1        |

  @UpdateUser @TokenAdmin
  Scenario Outline: Put Update user with Special Character password parameter Mentutor API
    Given Update user with  id <id_user> set request body name "<name>", email "<email>", Special Character password "<password>", images "<images>" and id_class <id_class>
    When Send request put update user
    Then Should return 400 Bad Request
    Examples:
      | id_user | name          | email                | password | images       | id_class |
      | 10      | Tigor Rolando | tigorrr123@gmail.com | @#$%$#@  | /gambar2.jpg | 1        |