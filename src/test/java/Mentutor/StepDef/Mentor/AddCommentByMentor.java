package Mentutor.StepDef.Mentor;

import Mentutor.Utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class AddCommentByMentor {
    @Steps
    MentorAPI mentorAPI;

    @Given("Mentor set valid ID status {int} and comment with valid JSON {string}")
    public void mentorSetValidIDAndCommentWithValidJSON(int id_status, String jsonName) {
        File json = new File(MentorAPI.MENTOR_COMMENT + "" + jsonName + "");
        mentorAPI.setAddMentorCommentValid(id_status, json);
    }

    @When("Mentor send request post comment status")
    public void mentorSendRequestPostCommentStatus() {
        SerenityRest.when().post(MentorAPI.ADD_MENTOR_COMMENT);
    }

    @Given("Mentor set invalid ID {string} and comment with valid JSON {string}")
    public void mentorSetInvalidIDAndCommentWithValidJSON(String id_status, String jsonName) {
        File json = new File(MentorAPI.MENTOR_COMMENT + ""+jsonName+"");
        mentorAPI.setAddMentorCommentInvalid(id_status, json);
    }

    @And("Validate json schema add comment by mentor")
    public void validateJsonSchemaAddCommentByMentor() {
        File json = new File(Constants.JSON_SCHEMA + "/Mentor/AddCommentMentorJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

//    @Given("Mentor set id status to {int} and comment {string}")
//    public void mentorSetIdStatusToAndComment(int id_status, String jsonName) {
//        File json = new File(MentorAPI.MENTOR_COMMENT + "" + jsonName + "");
//        mentorAPI.setAddMentorCommentValid(id_status, json);
//    }
}
