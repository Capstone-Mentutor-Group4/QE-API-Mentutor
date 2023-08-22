package Mentutor.StepDef.Mentee.UpdateProfile;

import Mentutor.utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class UpdateMenteeAPI {
    public static String UPDATE_PROFILE_MENTEE = Constants.BASE_URL+"/users";

    @Step("Put update profile mentee")
    public void putUpdateProfile(String name, String email, String password, String images){
        SerenityRest.given().header("Authorization", "Bearer " + Constants.TOKEN_MENTEE)
//                .pathParam("id_user",id_user)
                .multiPart("name", name)
                .multiPart("email", email)
                .multiPart("password", password)
                .multiPart("images", new File(Constants.IMAGES+images));
    }

    @Step("Put update profile mentee with numeric name")
    public void putUpdateProfileNumericName(int name, String email, String password, String images){
        SerenityRest.given().header("Authorization", "Bearer " + Constants.TOKEN_MENTEE)
//                .pathParam("id_user",id_user)
                .multiPart("name", name)
                .multiPart("email", email)
                .multiPart("password", password)
                .multiPart("images", new File(Constants.IMAGES+images));
    }
    @Step("Put update profile mentee with Special Character name")
    public void putUpdateProfileSpecCharName(String name, String email, String password, String images){
        SerenityRest.given().header("Authorization", "Bearer " + Constants.TOKEN_MENTEE)
                .multiPart("name", name)
                .multiPart("email", email)
                .multiPart("password", password)
                .multiPart("images", new File(Constants.IMAGES+images));
    }
    @Step("Put update profile mentee with empty name")
    public void putUpdateProfileEmptyName(String name, String email, String password, String images){
        SerenityRest.given().header("Authorization", "Bearer " + Constants.TOKEN_MENTEE)
                .multiPart("name", name)
                .multiPart("email", email)
                .multiPart("password", password)
                .multiPart("images", new File(Constants.IMAGES+images));
    }
    @Step("Put update profile mentee with numeric email")
    public void putUpdateProfileNumericEmail(String name, int email, String password, String images){
        SerenityRest.given().header("Authorization", "Bearer " + Constants.TOKEN_MENTEE)
                .multiPart("name", name)
                .multiPart("email", email)
                .multiPart("password", password)
                .multiPart("images", new File(Constants.IMAGES+images));
    }
    @Step("Put update profile mentee with Special Character on email")
    public void putUpdateProfileSpecCharEmail(String name, String email, String password, String images){
        SerenityRest.given().header("Authorization", "Bearer " + Constants.TOKEN_MENTEE)
                .multiPart("name", name)
                .multiPart("email", email)
                .multiPart("password", password)
                .multiPart("images", new File(Constants.IMAGES+images));
    }
    @Step("Put update profile mentee without Token")
    public void putUpdateProfileWithoutToken(String name, String email, String password, String images){
        SerenityRest.given()
                .multiPart("name", name)
                .multiPart("email", email)
                .multiPart("password", password)
                .multiPart("images", new File(Constants.IMAGES+images));
    }
    @Step("Put update profile mentee with Numeric on password")
    public void putUpdateProfileNumericPass(String name, String email, int password, String images){
        SerenityRest.given().header("Authorization", "Bearer " + Constants.TOKEN_MENTEE)
                .multiPart("name", name)
                .multiPart("email", email)
                .multiPart("password", password)
                .multiPart("images", new File(Constants.IMAGES+images));
    }
    @Step("Put update profile mentee with Special Character on password")
    public void putUpdateProfileSpecCharPass(String name, String email, String password, String images){
        SerenityRest.given().header("Authorization", "Bearer " + Constants.TOKEN_MENTEE)
                .multiPart("name", name)
                .multiPart("email", email)
                .multiPart("password", password)
                .multiPart("images", new File(Constants.IMAGES+images));
    }
    @Step("Put update profile mentee with empty password")
    public void putUpdateProfileEmptyPass(String name, String email, String password, String images){
        SerenityRest.given().header("Authorization", "Bearer " + Constants.TOKEN_MENTEE)
                .multiPart("name", name)
                .multiPart("email", email)
                .multiPart("password", password)
                .multiPart("images", new File(Constants.IMAGES+images));
    }

}
