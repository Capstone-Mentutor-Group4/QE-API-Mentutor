package Mentutor.StepDef.Mentor;

import Mentutor.Utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class SubmitScoreTaskByMentor {
    @Steps
    MentorAPI mentorAPI;
    @Given("Mentor set id task {int}, id submission {int}, and score {int}")
    public void mentorSetIdTaskIdSubmissionAndScore(int task, int sub, int score) {
        mentorAPI.setSubmitScore(task, sub, score);
    }

    @When("Mentor send request post add task score")
    public void mentorSendRequestPostAddTaskScore() {
        SerenityRest.when().post(MentorAPI.SUBMIT_SCORE);
    }

    @And("Validate json schema submit score task by mentor")
    public void validateJsonSchemaSubmitScoreTaskByMentor() {
        File json = new File(Constants.JSON_SCHEMA+"/Mentor/SubmitScoreMentorJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Mentor set id task {string}, id submission {}, and score {}")
    public void mentorSetIdTaskIdSubmissionAndScore(String task, int sub, int score) {
        mentorAPI.setSubmitScoreInvalid(task, sub, score);
    }

    @Given("Mentor set id task {int}, id submission {int}, and float score {float}")
    public void mentorSetIdTaskIdSubmissionAndFloatScore(int task, int sub, float score) {
        mentorAPI.setSubmitScoreFloat(task, sub, score);
    }

    @Given("Mentor set id task {int}, id submission {int}, and score {string}")
    public void mentorSetIdTaskIdSubmissionAndScore(int task, int sub, String score) {
        mentorAPI.setSubmitScoreString(task, sub, score);
    }

    @Given("Mentor set id task {int}, id submission {int} and empty score")
    public void mentorSetIdTaskIdSubmissionAndEmptyScore(int task, int sub) {
        mentorAPI.setSubmitScoreEmpty(task, sub);
    }
}
