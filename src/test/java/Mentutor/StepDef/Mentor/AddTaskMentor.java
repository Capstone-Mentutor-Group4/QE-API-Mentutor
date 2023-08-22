package Mentutor.StepDef.Mentor;

import Mentutor.Utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class AddTaskMentor {
    @Steps
    MentorAPI mentorAPI;
    @Given("Mentor set create task will valid JSON {string}")
    public void mentorCreateTaskWillAllValidData(String jsonName) {
        File json = new File(MentorAPI.MENTOR_TASK + ""+jsonName+"");
        mentorAPI.setCreateTaskMentor(json);
    }
    @Given("Mentor set create task with Title {string}, Description {string},Images {string},File {string}, Time {string}")
    public void mentorCreateTaskWillAllValidData(String title, String description, String images, String file, String time) {
    mentorAPI.setCreateNewTaskValid(title, description,images,file, time);
    }

    @Given("Mentor set create task incomplete data with Title {string}, Description {string},Images {string},File {string}, Time {string}")
    public void mentorCreateTaskWithIncompleteData(String title, String description, String images, String file, String time) {
        mentorAPI.setCreateTaskMentorIncomplete(title, description,images,file, time);
    }

    @When("User send request post create task")
    public void userSendRequestCreateTask() {
        SerenityRest.when().post(MentorAPI.CREATE_NEW_TASK);
    }

    @And("Validate json schema create task by mentor")
    public void validateJsonSchemaCreateTaskByMentor() {
        File json = new File (Constants.JSON_SCHEMA+"/Mentor/AddTaskMentorJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
