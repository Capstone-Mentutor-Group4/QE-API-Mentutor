package Mentutor.StepDef.Admin.GetUser;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class GetUserStepDef {
    @Steps
    GetUserAPI getUserAPI;
    @Given("All User with Authorization")
    public void allUserWithAuthorization() {
        getUserAPI.getAllUser();
    }

    @When("Send request get all user")
    public void snedRequestGetAllUser() {
        SerenityRest.when().get(GetUserAPI.GET_ALL_USERS);
    }

    @Given("All User without Authorization")
    public void allUserWithoutAuthorization() {
        getUserAPI.getAllUserWithoutAuth();
    }
}
