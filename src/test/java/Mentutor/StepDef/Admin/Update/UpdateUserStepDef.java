package Mentutor.StepDef.Admin.Update;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
//import org.apache.commons.lang3.RandomStringUtils;

public class UpdateUserStepDef {
    @Steps
    AdminUpdateAPI adminUpdateAPI;

//    String GenerateText = RandomStringUtils.randomAlphabetic(5);

    @Given("Update user with valid id {int} set request body name {string}, email {string}, password {string}, images {string} and id_class {int}")
    public void updateUserWithValidIdSetRequestBodyNameEmailPasswordImagesAndId_class(int id_user, String name, String email, String password, String images, int id_class) {
        adminUpdateAPI.putUpdateUser(id_user,name, email, password, images, id_class);
    }
    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(AdminUpdateAPI.UPDATE_USER);
    }

    @Given("Update user without Authorization and valid id {} set request body name {string}, email {string}, password {string}, images {string} and id_class {}")
    public void updateUserWithoutAuthorization(int id_user, String name, String email, String password, String images, int id_class) {
        adminUpdateAPI.putUpdateUnauth(id_user,name, email, password, images, id_class);
    }

    @Given("Update user with unregisted id {} set request body name {string}, email {string}, password {string}, images {string} and id_class {}")
    public void updateUserWithUnregistedIdSetRequestBodyNameEmailPasswordImagesAndId_class(int id_user, String name, String email, String password, String images, int id_class) {
        adminUpdateAPI.putUpdateUnregist(id_user,name, email, password, images, id_class);
    }


    @Given("Update user with  id {} set request body numeric name {}, email {string}, password {string}, images {string} and id_class {}")
    public void updateUserWithIdSetRequestBodyNumericNameEmailPasswordImagesAndId_class(int id_user, int name, String email, String password, String images, int id_class) {
        adminUpdateAPI.putUpdateNumericName(id_user,name, email, password, images, id_class);
    }

    @Given("Update user with  id {} set request body Special Character name {string}, email {string}, password {string}, images {string} and id_class {}")
    public void updateUserWithIdSetRequestBodySpecialCharacterNameEmailPasswordImagesAndId_class(int id_user, String name, String email, String password, String images, int id_class) {
        adminUpdateAPI.putUpdateSpecCharName(id_user,name, email, password, images, id_class);
    }

    @Given("Update user with  id {} set request body empty name {string}, email {string}, password {string}, images {string} and id_class {}")
    public void updateUserWithIdSetRequestBodyEmptyNameEmailPasswordImagesAndId_class(int id_user, String name, String email, String password, String images, int id_class) {
        adminUpdateAPI.putUpdateEmptyName(id_user,name, email, password, images, id_class);
    }

    @Given("Update user with  id {} set request body name {string}, email {string}, numeric password {}, images {string} and id_class {}")
    public void updateUserWithIdSetRequestBodyNameEmailNumericPasswordImagesAndId_class(int id_user, String name, String email, int password, String images, int id_class) {
        adminUpdateAPI.putUpdateNumericPass(id_user, name, email, password, images, id_class);
    }

    @Given("Update user with  id {} set request body name {string}, email {string}, Special Character password {string}, images {string} and id_class {}")
    public void updateUserWithIdSetRequestBodyNameEmailSpecialCharacterPasswordImagesAndId_class(int id_user, String name, String email, String password, String images, int id_class) {
        adminUpdateAPI.putUpdateSpecCharPass(id_user, name, email, password, images, id_class);
    }


}
