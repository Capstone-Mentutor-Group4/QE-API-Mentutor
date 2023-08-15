package Mentutor.StepDef.Admin.Register;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import Mentutor.Utils.Constants;

import java.io.File;

public class AdminAPI {
    public static String REGISTER_USER = Constants.BASE_URL + "/admin/users";
    public static String REGISTER_CLASS = Constants.BASE_URL + "/admin/classes";


    @Step("Post Register User")
    public void postRegisterUser(File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.TOKEN_ADMIN)
                .contentType(ContentType.JSON).body(json);
    }

    @Step("Post Register Class")
    public void postRegisterClass(String className) {
        SerenityRest.given()
                .headers("Authorization","Bearer "+Constants.TOKEN_ADMIN).log().all()
                .contentType("multipart/form-data")
                .multiPart("class_name",className);
    }
    @Step("Post Register Class without token")
    public void postRegisterClassWithoutToken(String className) {
    SerenityRest.given().multiPart("class_name",className);
    }

    @Step("Post Register Class with empty name")
    public void postRegistemptyName(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Post Register Class with numeric name")
    public void postRegistNumericName(int className){
        SerenityRest.given()
                .headers("Authorization","Bearer "+Constants.TOKEN_ADMIN).log().all()
                .multiPart("class_name",className);
    }
    @Step("Post Register Class with special character name")
    public void postRegisterSpecCharName(String className){
        SerenityRest.given()
                .headers("Authorization","Bearer "+Constants.TOKEN_ADMIN).log().all()
                .multiPart("class_name",className);
    }
}
