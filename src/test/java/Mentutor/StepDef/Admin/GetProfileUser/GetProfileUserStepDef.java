package Mentutor.StepDef.Admin.GetProfileUser;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class GetProfileUserStepDef {
    @Steps
    GetProfileAPI getProfileAPI;

    @Given("Get Profile User with Valid id {int}")
    public void getProfileUserWithValidId(int id_user) {
        getProfileAPI.getProfileUser(id_user);
    }

    @When("Send request get profile user")
    public void sendRequestGetProfileUser() {
        SerenityRest.when().get(GetProfileAPI.GET_PROFILE_USER);
    }

    @Given("Get Profile User with Valid id {int} without Authorization")
    public void getProfileUserWithValidIdWithout(int id_user) {
        getProfileAPI.getProfileUserWithoutAuth(id_user);
    }

    @Given("Get Profile User with unregisted id {int}")
    public void getProfileUserWithUnregistedId(int id_user) {
        getProfileAPI.getProfileUserUnregist(id_user);
    }
}
