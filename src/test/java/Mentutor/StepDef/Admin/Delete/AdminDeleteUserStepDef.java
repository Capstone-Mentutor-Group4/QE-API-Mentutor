package Mentutor.StepDef.Admin.Delete;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class AdminDeleteUserStepDef {
    @Steps
    AdminDeleteAPI adminDeleteAPI;
    @Given("Delete user with valid id {}")
    public void deleteUserWithValidId(int id_user) {
        adminDeleteAPI.deleteUser(id_user);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(AdminDeleteAPI.DELETE_USER);
    }

    @Given("Delete user with invalid id {}")
    public void deleteUserWithInvalidId(int id_user) {
        adminDeleteAPI.deleteInvalidUser(id_user);
    }

    @Given("Delete user without Authorization and valid id {}")
    public void deleteUserWithoutAuthorizationAndValidId(int id_user) {
        adminDeleteAPI.deleteUserWithoutAuth(id_user);
    }
}
