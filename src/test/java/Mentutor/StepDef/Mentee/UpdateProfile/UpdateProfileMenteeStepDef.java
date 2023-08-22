package Mentutor.StepDef.Mentee.UpdateProfile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class UpdateProfileMenteeStepDef {
    @Steps
    UpdateMenteeAPI updateMenteeAPI;


    @Given("Update user with valid request body name {string}, email {string}, password {string}, images {string}")
    public void updateUserWithValidRequestBodyNameEmailPasswordImages(String name, String email, String password, String images) {
        updateMenteeAPI.putUpdateProfile(name, email, password, images);
    }
    @When("Send request update mentee")
    public void sendRequestUpdateMentee() {
        SerenityRest.when().put(UpdateMenteeAPI.UPDATE_PROFILE_MENTEE);
    }

    @Given("Update user with valid set request body name {}, email {string}, password {string}, images {string}")
    public void updateUserWithValidSetRequestBodyNameEmailPasswordImages(int name, String email, String password, String images) {
        updateMenteeAPI.putUpdateProfileNumericName(name, email, password, images);
    }

    @Given("Update user with Special Charater on name {string}, email {string}, password {string}, images {string}")
    public void updateUserWithSpecialCharaterOnNameEmailPasswordImages(String name, String email, String password, String images) {
    updateMenteeAPI.putUpdateProfileSpecCharName(name, email, password, images);
    }

    @Given("Update user with empty on name {string},and valid email {string}, password {string}, images {string}")
    public void updateUserWithEmptyOnNameAndValidEmailPasswordImages(String name, String email, String password, String images) {
        updateMenteeAPI.putUpdateProfileEmptyName(name, email, password, images);
    }

    @Given("Update user with valid name {string},and numeric email {}, password {string}, images {string}")
    public void updateUserWithValidNameAndNumericEmailPasswordImages(String name, int email, String password, String images) {
        updateMenteeAPI.putUpdateProfileNumericEmail(name, email, password, images);
    }

    @Given("Update user with valid name {string},and Special Character email {string}, password {string}, images {string}")
    public void updateUserWithValidNameAndSpecialCharacterEmailPasswordImages(String name, String email, String password, String images) {
    updateMenteeAPI.putUpdateProfileSpecCharEmail(name, email, password, images);
    }

    @Given("Update user with valid name {string},and email {string}, password {string}, images {string}")
    public void updateUserWithValidNameAndEmailPasswordImages(String name, String email, String password, String images) {
    updateMenteeAPI.putUpdateProfileWithoutToken(name, email, password, images);
    }

    @Given("Update user with valid name {string},email {string}, and numeric password {}, images {string}")
    public void updateUserWithValidNameEmailAndNumericPasswordImages(String name, String email, int password, String images) {
        updateMenteeAPI.putUpdateProfileNumericPass(name, email, password, images);
    }

    @Given("Update user with valid name {string},email {string}, and Special Character password {string}, images {string}")
    public void updateUserWithValidNameEmailAndSpecialCharacterPasswordImages(String name, String email, String password, String images) {
        updateMenteeAPI.putUpdateProfileSpecCharPass(name, email, password, images);
    }

    @Given("Update user with valid name {string},email {string}, and empty password {string}, images {string}")
    public void updateUserWithValidNameEmailAndEmptyPasswordImages(String name, String email, String password, String images) {
        updateMenteeAPI.putUpdateProfileEmptyPass(name, email, password, images);
    }


}
