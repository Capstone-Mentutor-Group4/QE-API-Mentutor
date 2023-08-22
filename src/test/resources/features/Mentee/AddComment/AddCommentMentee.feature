Feature: Add Comment by Mentee Mentutor API

  @CommentMentee @TokenMentee
  Scenario Outline: Post Add Comment by Mentee Mentutor API
    Given Add Comment with valid id <id> and caption "<caption>"
    When Send request post add comment
    Then Should return 201 Created
    Examples:
      | id | caption   |
      | 1  | Saya agak bingung|

  @CommentMentee  @TokenMentee
  Scenario Outline: Post Add Comment with unregisted id Mentutor API
    Given Add Comment with unregisted id <id> and caption "<caption>"
    When Send request post add comment
    Then Should return 400 Bad Request
    Examples:
      | id  | caption       |
      | 100 | Saya Mengerti |


  @CommentMentee @TokenMentee
  Scenario Outline: Post Add Comment without id status Mentutor API
    Given Add Comment without id <id> and caption "<caption>"
    When Send request post add comment
    Then Should return 400 Bad Request
    Examples:
      | id | caption       |
      | 0  | Saya Mengerti |

  @CommentMentee @TokenMentee
  Scenario Outline: Post Add Comment with Special Character caption Mentutor API
    Given Add Comment with id <id> and Special Character caption "<caption>"
    When Send request post add comment
    Then Should return 400 Bad Request
    Examples:
      | id | caption |
      | 1  | @#$%$#@ |

  @CommentMentee @TokenMentee
  Scenario Outline: Post Add Comment with empty caption Mentutor API
    Given Add Comment with id <id> and empty caption "<caption>"
    When Send request post add comment
    Then Should return 400 Bad Request
    Examples:
      | id | caption |
      | 1  |         |

  @CommentMentee @TokenMentee
  Scenario Outline: Post Add Comment with integer caption Mentutor API
    Given Add Comment with id <id> and integer caption <caption>
    When Send request post add comment
    Then Should return 400 Bad Request
    Examples:
      | id | caption   |
      | 1  | 123456789 |

  @CommentMentee @TokenMentee
  Scenario Outline: Post Add Comment with float caption Mentutor API
    Given Add Comment with id <id> and float caption <caption>
    When Send request post add comment
    Then Should return 400 Bad Request
    Examples:
      | id | caption |
      | 1  | 123.5   |

