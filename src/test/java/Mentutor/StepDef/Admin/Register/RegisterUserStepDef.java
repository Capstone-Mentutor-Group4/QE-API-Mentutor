package Mentutor.StepDef.Admin.Register;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import Mentutor.Utils.Constants;

import java.io.File;

public class RegisterUserStepDef {
    @Steps
    AdminRegistAPI adminRegistAPI;

    @Given("Register user with valid json")
    public void registerUserWithValidJson() {
        File json = new File(Constants.REQ_BODY+"/RegisterUser/RegisterUser.json");
        adminRegistAPI.postRegisterUser(json);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(AdminRegistAPI.REGISTER_USER);
    }

    @And("Validate json schema register user")
    public void validateJsonSchemaRegisterUser() {
        File json = new File(Constants.JSON_SCHEMA+"/Register/RegisterUserSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Register user with valid json and without Authorization")
    public void registerUserValidWithoutToken() {
        File json = new File(Constants.REQ_BODY+"/RegisterUser/RegisterWithoutToken.json");
        adminRegistAPI.postRegisterUser(json);
    }

    @Given("Register user with empty one field body json")
    public void registerUserWithEmptyOneFieldBodyJson() {
        File json = new File(Constants.REQ_BODY+"/RegisterUser/RegisterEmptyOneField.json");
        adminRegistAPI.postRegisterUser(json);
    }



    @Given("Register user with Special Character on name parameter")
    public void registerUserWithSpecialCharacterOnNameParameter() {
        File json = new File(Constants.REQ_BODY+"/RegisterUser/RegisterEmptyName.json");
        adminRegistAPI.postRegisterUser(json);
    }
//    UserNumericName
    @Given("Register numeric name parameter")
    public void registerUserWithNumericOnNameParameter() {
        File json = new File(Constants.REQ_BODY+"/RegisterUser/RegisterUserNumericName.json");
        adminRegistAPI.postRegisterUser(json);
    }

    @Given("Register user numeric on password parameter")
    public void registerUserNumericOnPasswordParameter() {
        File json = new File(Constants.REQ_BODY+"/RegisterUser/RegisterNumericPassword.json");
        adminRegistAPI.postRegisterUser(json);
    }

    @Given("Register user Special Character on password parameter")
    public void registerUserSpecialCharacterOnPasswordParameter() {
        File json = new File(Constants.REQ_BODY+"/RegisterUser/RegisterSpecialCharacterPassword.json");
        adminRegistAPI.postRegisterUser(json);
    }

}
