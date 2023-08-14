package Mentutor.StepDef.Login;

import Mentutor.Utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class LoginMentor {
    @Steps
    LoginAPI loginAPI;
    @Given("Post login user with valid json")
    public void postLoginUserWithValidJson() {
        File json = new File(Constants.JSON_REQ_BODY +"/Login/LoginMentor.json");
        loginAPI.postLoginMentor(json);
    }

    @When("Send request post login")
    public void sendRequestPostLogin() {
        SerenityRest.when().post(LoginAPI.LOGIN);
    }

    @And("Validate json schema login users")
    public void validateJsonSchemaLoginMentor() {
        File json = new File(Constants.JSON_SCHEMA+"/Login/LoginJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Post login user with Invalid json")
    public void postLoginUserWithInvalidJson() {
        File json = new File(Constants.JSON_REQ_BODY +"/Login/LoginUserInvalidData.json");
        loginAPI.postLoginMentor(json);
    }

    @Given("Post login user with Empty Email")
    public void postLoginUserWithEmptyEmail() {
        File json = new File(Constants.JSON_REQ_BODY +"/Login/LoginUserEmptyEmail.json");
        loginAPI.postLoginMentor(json);
    }

    @Given("Post login user with Empty Password")
    public void postLoginUserWithEmptyPassword() {
        File json = new File(Constants.JSON_REQ_BODY +"/Login/LoginUserEmptyPassword.json");
        loginAPI.postLoginMentor(json);
    }
}
