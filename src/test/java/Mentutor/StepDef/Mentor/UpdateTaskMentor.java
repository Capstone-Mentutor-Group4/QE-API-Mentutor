package Mentutor.StepDef.Mentor;

import Mentutor.Utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class UpdateTaskMentor {
    @Steps
    MentorAPI mentorAPI;
    @Given("Mentor set request update task with valid ID {int} and valid JSON {string}")
    public void mentorSetRequestUpdateTakWithValidIDAndValidDataJSON(int id, String jsonName) {
        File json = new File(MentorAPI.UPDATE_MENTOR_TASK + ""+jsonName+"");
        mentorAPI.setUpdateTaskMentor(id, json);
    }

    @When("Mentor send request put update task")
    public void mentorSendRequestPutUpdateTask() {
        SerenityRest.when().put(MentorAPI.UPDATE_TASK);
    }

    @And("Validate json schema update task by mentor")
    public void validateJsonSchemaUpdateTaskByMentor() {
        File json = new File(Constants.JSON_SCHEMA+"/Mentor/UpdateTaskMentorJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Mentor set request update task with invalid ID {string} and valid JSON {string}")
    public void mentorSetRequestUpdateTaskWithInvalidIDAndValidJSON(String id, String jsonName) {
        File json = new File(MentorAPI.UPDATE_MENTOR_TASK + ""+jsonName+"");
        mentorAPI.setUpdateTaskInvalid(id, json);
    }

    @Given("Mentor set request update task without ID Task and valid JSON {string}")
    public void mentorSetRequestUpdateTaskWithoutIDTaskAndValidJSON(String jsonName) {
        File json = new File(MentorAPI.UPDATE_MENTOR_TASK + ""+jsonName+"");
        mentorAPI.setUpdateTaskWithoutID(json);
    }

    @Given("Mentor set request update task with valid ID {}, Title {string}, Description {string}, Images {string}, File {string}, Time {string}")
    public void mentorSetRequestUpdateTaskWithValidIDTitleDescriptionImagesFileTime(int id, String title, String description, String images, String file, String time) {
        mentorAPI.setUpdateTaskValid(id, title, description, images, file, time);
    }
}
