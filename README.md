Trospid Initiative
==================
 

- Run with mvn spring-boot:run

-You can see the result in 
 [http://localhost:8082/greeting?name=User](http://localhost:8082/greeting?name=User)
 
 Tests
 _____
 - Unit tests runs on _test_ phase
 - Cucumber Integration test runs on _verify_ phase
   - They can be executed with mvn -Dtest=CucumberIntegrationTest test
