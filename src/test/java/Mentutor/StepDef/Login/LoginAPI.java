package Mentutor.StepDef.Login;

import Mentutor.Utils.Constants;
import io.cucumber.java.en.And;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;


import java.io.File;

public class LoginAPI {

    public static String LOGIN = Constants.BASE_URL+"/login";

    @Step("Post Login Mentor")
    public void postLoginMentor(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Post Login Mentee")
    public void postLoginMentee(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }


    @And("Set token to Token Mentor")
    public void setTokenToMentorToken() {
        SerenityRest.when().post(LoginAPI.LOGIN);
        Constants.TOKEN_MENTOR = SerenityRest.then().extract().path("data.token");
    }
    @And("Set token to Token Mentee")
    public void setTokenToBaseMenteeToken() {
        SerenityRest.when().post(LoginAPI.LOGIN);
        Constants.TOKEN_MENTEE = SerenityRest.then().extract().path("data.token");
    }

    @Step("Post Login Admin")
    public void postLoginAdmin(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
}
