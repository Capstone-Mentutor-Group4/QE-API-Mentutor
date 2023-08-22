Feature: Update Profile Mentee Mentutor API

#  2 Bug
  @UpdateProfMentee @TokenMentee
  Scenario Outline: Update Profile Mentee with valid data
    Given Update user with valid request body name "<name>", email "<email>", password "<password>", images "<images>"
    When Send request update mentee
    Then Should return 201 Created
    Examples:
      | name          | email                | password  | images       |
      | Tigor Ronaldo | tigorrr123@gmail.com | Tigor123$ | /gambar2.jpg |

  @UpdateProfMentee @TokenMentee
  Scenario Outline: Update Profile Mentee with numeric on name parameter
    Given Update user with valid set request body name <name>, email "<email>", password "<password>", images "<images>"
    When Send request update mentee
    Then Should return 400 Bad Request
    Examples:
      | name     | email                | password  | images       |
      | 12345678 | tigorrr123@gmail.com | Tigor123$ | /gambar2.jpg |

  @UpdateProfMentee @TokenMentee
  Scenario Outline: Update Profile Mentee with Special Character on name parameter
    Given Update user with Special Charater on name "<name>", email "<email>", password "<password>", images "<images>"
    When Send request update mentee
    Then Should return 400 Bad Request
    Examples:
      | name     | email                | password  | images       |
      | @#$%^$#@ | tigorrr123@gmail.com | Tigor123$ | /gambar2.jpg |

#    BUG
  @UpdateProfMentee @TokenMentee
  Scenario Outline: Update Profile Mentee with Empty name parameter
    Given Update user with empty on name "<name>",and valid email "<email>", password "<password>", images "<images>"
    When Send request update mentee
    Then Should return 400 Bad Request
    Examples:
      | name | email                | password  | images       |
      |      | tigorrr123@gmail.com | Tigor123$ | /gambar2.jpg |

  @UpdateProfMentee @TokenMentee
  Scenario Outline: Update Profile Mentee with numeric email parameter
    Given Update user with valid name "<name>",and numeric email <email>, password "<password>", images "<images>"
    When Send request update mentee
    Then Should return 400 Bad Request
    Examples:
      | name      | email    | password  | images       |
      | Tigor Ronaldo | 12345678 | Tigor123$ | /gambar2.jpg |

  @UpdateProfMentee @TokenMentee
  Scenario Outline: Update Profile Mentee with Special Character email parameter
    Given Update user with valid name "<name>",and Special Character email "<email>", password "<password>", images "<images>"
    When Send request update mentee
    Then Should return 400 Bad Request
    Examples:
      | name       | email    | password  | images       |
      | Tigor Rolex | @#$%$@#$ | Tigor123$ | /gambar2.jpg |

#Bug
  @UpdateProfMentee
  Scenario Outline: Update Profile Mentee without Authorization
    Given Update user with valid name "<name>",and email "<email>", password "<password>", images "<images>"
    When Send request update mentee
    Then Should return 401 Unauthorized
    Examples:
      | name      | email    | password  | images       |
      | Tigor Ronaldo | @#$%$@#$ | Tigor123$ | /gambar2.jpg |

  @UpdateProfMentee  @TokenMentee
  Scenario Outline: Update Profile Mentee with numeric password parameter
    Given Update user with valid name "<name>",email "<email>", and numeric password <password>, images "<images>"
    When Send request update mentee
    Then Should return 400 Bad Request
    Examples:
      | name    | email    | password | images       |
      | Tigor Ronaldo | @#$%$@#$ | 12345678 | /gambar2.jpg |

  @UpdateProfMentee @TokenMentee
  Scenario Outline: Update Profile Mentee with Special Character password parameter
    Given Update user with valid name "<name>",email "<email>", and Special Character password "<password>", images "<images>"
    When Send request update mentee
    Then Should return 400 Bad Request
    Examples:
      | name      | email    | password | images       |
      | Tigor Ronaldo | @#$%$@#$ | @#$%$#@$ | /gambar2.jpg |

  @UpdateProfMentee @TokenMentee
  Scenario Outline: Update Profile Mentee with empty password parameter
    Given Update user with valid name "<name>",email "<email>", and empty password "<password>", images "<images>"
    When Send request update mentee
    Then Should return 400 Bad Request
    Examples:
      | name          | email    | password | images       |
      | Tigor Ronaldo | @#$%$@#$ |          | /gambar2.jpg |

