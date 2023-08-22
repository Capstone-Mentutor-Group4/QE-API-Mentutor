package Mentutor.StepDef.Mentee.AddComments;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class AddCommentMenteeStepDef {
    @Steps
    AddCommentAPI addCommentAPI;

    @Given("Add Comment with valid id {int} and caption {string}")
    public void addCommentWithValidIdAndCaption(int id_status, String caption) {
        addCommentAPI.postAddCommentMentee(id_status,caption);
    }

    @When("Send request post add comment")
    public void sendRequestPostAddComment() {
        SerenityRest.when().post(AddCommentAPI.ADD_COMMENT_MENTEE);
    }

    @Given("Add Comment with unregisted id {int} and caption {string}")
    public void addCommentWithUnregistedIdAndCaption(int id_status, String caption) {
        addCommentAPI.postAddCommenUnregistId(id_status,caption);
    }

    @Given("Add Comment without id {int} and caption {string}")
    public void addCommentWithoutIdAndCaption(int id_status, String caption) {
    addCommentAPI.postAddCommenWithoutId(id_status,caption);
    }

    @Given("Add Comment with id {} and Special Character caption {string}")
    public void addCommentWithIdAndSpecialCharacterCaption(int id_status, String caption) {
        addCommentAPI.postAddCommenWithIdSpecChar(id_status,caption);
    }

    @Given("Add Comment with id {} and empty caption {string}")
    public void addCommentWithIdAndEmptyCaption(int id_status, String caption) {
    addCommentAPI.postAddCommenWithIdemptyCaption(id_status,caption);
    }

    @Given("Add Comment with id {} and integer caption {}")
    public void addCommentWithIdAndIntegerCaption(int id_status, int caption) {
    addCommentAPI.postAddCommenWithIdIntCaption(id_status,caption);
    }

    @Given("Add Comment with id {} and float caption {}")
    public void addCommentWithIdAndFloatCaption(int id_status, float caption) {
        addCommentAPI.postAddCommenWithIdFltCaption(id_status,caption);
    }
}
