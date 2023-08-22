package Mentutor.StepDef.Forum;

import Mentutor.Utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class AddStatusForum {
    @Steps
    ForumAPI forumAPI;
    @Given("Mentee post add status with set request body caption {string} and images {string}")
    public void menteePostAddStatusWithSetRequestBodyCaptionAndImages(String caption, String images) {
        forumAPI.addStatusValidData(caption, images);
    }

    @When("Mentee send request post status")
    public void menteeSendRequestPostStatus() {
        SerenityRest.when().post(ForumAPI.FORUM_STATUS);
    }

    @And("Validate json schema post status by mentee")
    public void validateJsonSchemaPostStatusByMentee() {
        File json = new File(Constants.JSON_SCHEMA+"/Forum/AddStatusJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Mentee without token post add status with set request body caption {string} and images {string}")
    public void menteeWithoutTokenPostAddStatusWithSetRequestBodyCaptionAndImages(String caption, String images) {
        forumAPI.addStatusValidDataWithoutAuth(caption, images);
    }

    @Given("Mentee with Token Admin post add status with set request body caption {string} and images {string}")
    public void menteeWithTokenAdminPostAddStatusWithSetRequestBodyCaptionAndImages(String caption, String images) {
        forumAPI.addStatusValidDataWithAdmin(caption, images);
    }

    @Given("Mentee with Token Mentor post add status with set request body caption {string} and images {string}")
    public void menteeWithTokenMentorPostAddStatusWithSetRequestBodyCaptionAndImages(String caption, String images) {
        forumAPI.addStatusValidDataWithMentor(caption, images);
    }

    @Given("Mentee post add status with set request body caption {int} and images {string}")
    public void menteePostAddStatusWithSetRequestBodyCaptionAndImages(int caption, String images) {
        forumAPI.addStatusValidDataWithNumeric(caption, images);
    }

    @Given("Mentee post add status with set request body caption {string}")
    public void menteePostAddStatusWithoutImages(String caption) {
        forumAPI.addStatusValidDataWithoutImages(caption);
    }

    @Given("Mentee post add status with empty data")
    public void menteePostAddStatusWithEmptyData() {
        forumAPI.addStatusEmpty();
    }
}
