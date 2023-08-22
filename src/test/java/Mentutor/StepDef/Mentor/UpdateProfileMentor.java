package Mentutor.StepDef.Mentor;

import Mentutor.Utils.Constants;
import Mentutor.Utils.MentutorResponses;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class UpdateProfileMentor {
    @Steps
    MentorAPI mentorAPI;
//    @Given("Put Update User Mentor with valid data")
//    public void putUpdateUserMentorWithValidData() {
//        File json = new File(Constants.JSON_REQ_BODY +"/Register/RegisterUser.json");
//        mentorAPI.putUpdateMentor(json);
//    }

    @Given("Mentor set request update profile with valid JSON {string}")
    public void mentorSetRequestUpdateProfileWithValidJson(String jsonName) {
        File json = new File (MentorAPI.MENTOR_UPDATE + ""+jsonName+"");
        mentorAPI.setUpdateMentorProfile(json);
    }

    @Given("Mentor set request update profile with valid JSON {string} and without authorization")
    public void mentorSetRequestUpdateProfileWithValidJSONAndWithoutAuthorization(String jsonName) {
        File json = new File (MentorAPI.MENTOR_UPDATE + ""+jsonName+"");
        mentorAPI.setUpdateWithoutAuth(json);
    }

    @Given("Mentor set request update profile with invalid Images extention valid on JSON {string}")
    public void mentorSetRequestUpdateProfileWithInvalidImagesExtentionValidOnJSON(String jsonName) {
        File json = new File (MentorAPI.MENTOR_UPDATE + ""+jsonName+"");
        mentorAPI.setUpdateInvalidImages(json);
    }

    @When("User send request put update data")
    public void userSendRequestPutUpdateData() {
        SerenityRest.when().put(MentorAPI.UPDATE_USER_PROFILE);
    }

    @And("Validate json schema update profile mentor")
    public void validateJsonSchemaUpdateProfileMentor() {
        File json = new File (Constants.JSON_SCHEMA+"/Mentor/UpdateProfileMentorJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
