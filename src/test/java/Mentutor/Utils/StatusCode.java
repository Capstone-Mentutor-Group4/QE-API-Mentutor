package Mentutor.Utils;

import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;

public class StatusCode {
    @Then("Should return {int} OK")
    public void shouldReturnOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }
    @Then("Should return {int} Created")
    public void shouldReturnCreated(int created) {
        SerenityRest.then().statusCode(created);
    }
    @Then("Should return {int} Not Found")
    public void shouldReturnNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }
    @Then("Should return {int} Bad Request")
    public void shouldReturnBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }
    @Then("Should return {int} Unauthorized")
    public void shouldReturnUnauthorized(int unAuthorized) {
        SerenityRest.then().statusCode(unAuthorized);
    }
    @Then("Should return {int} Method Not Allowed")
    public void shouldReturnMethodNotAllowed(int notAllowed){
        SerenityRest.then().statusCode(notAllowed);
    }
}
