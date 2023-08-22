package Mentutor.StepDef.Admin.Delete;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class AdminDeleteClassStepDef {
    @Steps
    AdminDeleteAPI adminDeleteAPI;

    @Given("Delete existing class with valid id class {}")
    public void deleteExistingClassWithValidIdClass(int id_class) {
        adminDeleteAPI.deleteClass(id_class);
    }

    @When("Send request delete class")
    public void sendRequestDeleteClass() {
        SerenityRest.when().delete(AdminDeleteAPI.DELETE_CLASS);
    }

    @Given("Delete existing class with invalid id class {int}")
    public void deleteExistingClassWithInvalidIdClass(int id_class) {
        adminDeleteAPI.deleteClasswithInvalidId(id_class);
    }


}
