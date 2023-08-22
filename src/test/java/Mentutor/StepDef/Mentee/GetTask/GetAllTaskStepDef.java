package Mentutor.StepDef.Mentee.GetTask;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GetAllTaskStepDef {

    @Steps
    GetTaskAPI getTaskAPI;

    @Given("Get All task Mentee with Authorization")
    public void getAllTaskMenteeWithAuthorization() {
    }

    @When("Send request get all task")
    public void sendRequestGetAllTask() {
    }
}
