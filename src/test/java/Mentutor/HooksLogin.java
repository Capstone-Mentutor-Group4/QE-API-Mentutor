package Mentutor;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import Mentutor.Utils.Constants;

import java.io.File;

public class HooksLogin {
    @Before("@TokenMentee")
    public void loginMentee(){
        File json = new File(Constants.REQ_BODY+"/Login/LoginMentee.json");
        Response response= SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .post(Constants.BASE_URL+"/login");
        JsonPath jsonPath = response.jsonPath();
        Constants.TOKEN_MENTEE = jsonPath.get("data.token");
    }

    @Before("@TokenAdmin")
    public void loginAdmin(){
        File json = new File(Constants.REQ_BODY+"/Login/LoginAdmin.json");
        Response response= SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .post(Constants.BASE_URL+"/login");
        JsonPath jsonPath = response.jsonPath();
        Constants.TOKEN_ADMIN = jsonPath.get("data.token");
    }

    @After("@TokenMentee")
    public void resetTokenUser() {
        Constants.TOKEN_MENTEE = null;
    }
    @After("@TokenAdmin")
    public void resetTokenAdmin() {
        Constants.TOKEN_ADMIN = null;
    }
}
