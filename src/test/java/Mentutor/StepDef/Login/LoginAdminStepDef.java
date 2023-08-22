package Mentutor.StepDef.Login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import Mentutor.Utils.Constants;

import java.io.File;

public class LoginAdminStepDef {
    @Steps
    LoginAPI loginAPI;

    @Given("Post login Admin with valid json")
    public void postLoginWithValidJson() {
        File json = new File(Constants.REQ_BODY+"/Login/LoginAdmin.json");
        loginAPI.postLoginAdmin(json);
    }

    @When("Send request post login")
    public void sendRequestPostLogin() {
        SerenityRest.when().post(LoginAPI.LOGIN);
    }

    @And("Validate json schema login admin")
    public void validateJsonSchemaLoginAdmin() {
        File json = new File(Constants.JSON_SCHEMA+"/Login/LoginAdminSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Post login Admin with Invalid json")
    public void postLoginAdminWithInvalidJson() {
        File json = new File(Constants.REQ_BODY+"/Login/LoginAdminInvalid.json");
        loginAPI.postLoginAdmin(json);
    }

    @Given("Post login Admin with Empty Email")
    public void postLoginAdminWithEmptyEmail() {
        File json = new File(Constants.REQ_BODY+"/Login/LoginAdminEmptyEmail.json");
        loginAPI.postLoginAdmin(json);
    }

    @Given("Post login Admin with Empty Password")
    public void postLoginAdminWithEmptyPassword() {
        File json = new File(Constants.REQ_BODY+"/Login/LoginAdminEmptyPassword.json");
        loginAPI.postLoginAdmin(json);
    }
}
