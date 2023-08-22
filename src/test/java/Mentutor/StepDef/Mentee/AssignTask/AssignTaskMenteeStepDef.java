package Mentutor.StepDef.Mentee.AssignTask;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;


public class AssignTaskMenteeStepDef {
    @Steps AssignAPI assignAPI;

    @Given("Assign Task with valid id {} and valid data {string}")
    public void assignTaskWithValidIdAndValidData(int id_task, String file) {
        assignAPI.postAssignTask(id_task,file);

    }

    @When("User send request post create task")
    public void userSendRequestPostCreateTask() {
        SerenityRest.when().post(AssignAPI.ASSIGN_TASK_MENTEE);
    }

    @Given("Assign Task with invalid id {string} and valid data {string}")
    public void assignTaskWithInvalidIdAndValidData(String id_task, String file) {
    assignAPI.postAssignTaskinvalidId(id_task,file);
    }

    @Given("Assign Task with unregisted id {} and valid data {string}")
    public void assignTaskWithUnregistedIdAndValidData(int id_task, String file) {
        assignAPI.postAssignTaskUnregistId(id_task, file);

    }

    @Given("Assign Task with unregisted id {} and invalid data {string}")
    public void assignTaskWithUnregistedIdAndInvalidData(int id_task, String file) {
        assignAPI.postAssignTaskInvalidData(id_task,file);

    }

    @Given("Assign Task with valid id {} and data {string} admin token")
    public void assignTaskWithValidIdAndDataAdminToken(int id_status, String file) {
        assignAPI.postAssignTaskAdminToken(id_status,file);
    }

    @Given("Assign Task with valid id {} and data {string} without Authorization")
    public void assignTaskWithValidIdAndDataWithoutAuthorization(int id_task, String file) {
        assignAPI.postAssignTaskWithoutToken(id_task,file);
    }
}
