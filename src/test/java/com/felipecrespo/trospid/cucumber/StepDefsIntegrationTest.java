package com.felipecrespo.trospid.cucumber;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import cucumber.api.java.en.Given;
import org.springframework.http.HttpStatus;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefsIntegrationTest extends SpringIntegrationTest {

    @And("^the client receives the response (.+)$")
    public void the_client_receives_the_response_body(String version) throws Throwable {
        assertThat(latestResponse.getBody(), is(version));
    }

    @Given("^the client calls /greting$")
    public void the_client_issues_GET_greting() throws Throwable {
        executeGet("http://localhost:8080/greting");
    }

    @Given("^the client calls /greeting$")
    public void the_client_issues_GET_greeting() throws Throwable {
        executeGet("http://localhost:8080/greeting");
    }

    @Given("^the client calls /greeting\\?name=CoolGuy$")
    public void the_client_issues_GET_greetingCoolGuy() throws Throwable {
        executeGet("http://localhost:8080/greeting?name=CoolGuy");
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
    }


}