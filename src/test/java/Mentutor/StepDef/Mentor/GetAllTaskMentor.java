package Mentutor.StepDef.Mentor;

import Mentutor.Utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class GetAllTaskMentor {
    @Steps
    MentorAPI mentorAPI;
    @Given("Mentor get all task with valid id mentor")
    public void mentorGetAllTaskWithValidIdMentor() {
        mentorAPI.setGetAllTaskByMentor();
    }

    @When("Mentor send request get all task")
    public void mentorSendRequestGetAllTask() {
        SerenityRest.when().get(MentorAPI.GET_ALL_TASK_BY_ID_MENTOR);
    }

    @And("Validate json schema get all task by mentor")
    public void validateJsonSchemaGetAllTaskByMentor() {
        File json = new File (Constants.JSON_SCHEMA + "/Mentor/GetAllTaskMentorJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Mentor get all task without token mentor")
    public void mentorGetAllTaskWithoutTokenMentor() {
        mentorAPI.setGetAllWithoutToken();
    }

    @Given("Mentor set id task to {int}")
    public void mentorSetIdTaskTo(int id) {
        mentorAPI.setGetDetailTask(id);
    }

    @When("Mentor send request get detail task")
    public void mentorSendRequestGetDetailTask() {
        SerenityRest.when().get(MentorAPI.GET_DETAIL_TASK);
    }

    @And("Validate json schema get detail task by mentor")
    public void validateJsonSchemaGetDetailTaskByMentor() {
        File json = new File (Constants.JSON_SCHEMA + "/Mentor/GetDetailTaskMentorJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Mentor set id task to {string}")
    public void mentorSetIdTaskTo(String id) {
        mentorAPI.setGetDetailInvalid(id);
    }

    @Given("Mentor set id task to {int} without token mentor")
    public void mentorSetIdTaskToWithoutTokenMentor(int id) {
        mentorAPI.setGetDetailTaskWithoutToken(id);
    }

    //DELETE TASK FEATURE
    @Given("Mentor set id task empty")
    public void mentorSetIdTaskEmpty() {
        int id = 0;
        mentorAPI.setGetDetailTask(id);
    }

    @When("Mentor send request delete task")
    public void mentorSendRequestDeleteTask() {
        SerenityRest.when().delete(MentorAPI.GET_DETAIL_TASK);
    }
}
