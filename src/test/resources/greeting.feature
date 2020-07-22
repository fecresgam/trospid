Feature: the greeting works
  Scenario: client makes call to get /thisURLnotExists
    Given the client calls /thisURLnotExists
    Then the client receives status code of 404