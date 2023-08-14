package Mentutor.StepDef.Login;

import Mentutor.Utils.Constants;
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

}
