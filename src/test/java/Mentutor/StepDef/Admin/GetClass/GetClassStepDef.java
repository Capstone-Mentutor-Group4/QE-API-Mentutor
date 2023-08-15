package Mentutor.StepDef.Admin.GetClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class GetClassStepDef {
    @Steps
    GetClassAPI getClassAPI;
    @Given("All Class with Authorization")
    public void allClassWithAuthorization() {
        getClassAPI.getAllClass();
    }

    @When("Send request get all class")
    public void sendRequestGetAllClass() {
        SerenityRest.when().get(GetClassAPI.GET_ALL_CLASS);
    }

    @Given("All Class without Authorization")
    public void allClassWithoutAuthorization() {
        getClassAPI.getAllClassWithoutAuth();
    }
}
