package Mentutor.StepDef.Forum;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class GetAllStatusForum {
    @Steps
    ForumAPI forumAPI;
    @Given("Mentee get all status using valid path with authorization")
    public void menteeGetAllStatusUsingValidPathWithAuthorization() {
        forumAPI.getAllStatus();
    }

    @When("User send request get all status")
    public void userSendRequestGetAllStatus() {
        SerenityRest.when().get(ForumAPI.GET_ALL_STATUS);
    }

    @Given("Mentee get all status using valid path without authorization")
    public void menteeGetAllStatusUsingValidPathWithoutAuthorization() {
        forumAPI.getAllStatusWithoutAuth();
    }

    @Given("User get all status using valid path with Token Mentor")
    public void userGetAllStatusUsingValidPathWithTokenMentor() {
        forumAPI.getAllStatusWithMentor();
    }

    @Given("User get all status using valid path with Token Admin")
    public void userGetAllStatusUsingValidPathWithTokenAdmin() {
        forumAPI.getAllStatusWithAdmin();
    }
}
