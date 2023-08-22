package Mentutor.StepDef.Admin.Register;

import Mentutor.Utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class RegisterClassStepDef {
    @Steps
    AdminRegistAPI adminRegistAPI;
    @Given("Register class with valid class name {string}")
    public void registerClassWithValidJson(String className) {
        adminRegistAPI.postRegisterClass(className);
    }
    @When("Send request post register class")
    public void sendRequestPostRegisterClass() {
        SerenityRest.when().post(AdminRegistAPI.REGISTER_CLASS);
    }
    @And("Validate json schema register class")
    public void validateJsonSchemaRegisterClass() {
        File json = new File(Constants.JSON_SCHEMA+"/Register/RegisterClassSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));

    }
    @Given("Register class with classname {string} and Unauthorized")
    public void registerClassWithClassnameAndUnauthorized(String className) {
        adminRegistAPI.postRegisterClassWithoutToken(className);
    }



    @Given("Register class with empty class name")
    public void registerClassWithEmptyClassName() {
        File json = new File(Constants.REQ_BODY+"/RegisterClass/RegisterClassEmptyName.json");
        adminRegistAPI.postRegistemptyName(json);

    }


    @Given("Register class with numeric class name {int}")
    public void registerClassWithNumericClassName(int className) {
        adminRegistAPI.postRegistNumericName(className);
    }

    @Given("Register class with special character name parameter {string}")
    public void registerClassWithSpecialCharacterNameParameter(String className) {
        adminRegistAPI.postRegisterSpecCharName(className);
    }
}
