Feature: the greeting works
  Scenario: client makes call to get /greting -with only one E-
    Given the client calls /greting
    Then the client receives status code of 404
  Scenario: client makes call to get /greeting and receives JSON
    When the client calls /greeting
    Then the client receives status code of 200
    And the client receives the response {"id":1,"content":"Hello, Trospid!"}
  Scenario: client makes call to get /greeting CoolGuy
    When the client calls /greeting?name=CoolGuy
    Then the client receives status code of 200
    And the client receives the response {"id":2,"content":"Hello, CoolGuy!"}
