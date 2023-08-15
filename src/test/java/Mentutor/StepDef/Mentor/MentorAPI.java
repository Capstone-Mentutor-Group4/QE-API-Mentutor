package Mentutor.StepDef.Mentor;

import Mentutor.Utils.Constants;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class MentorAPI {

    public static String UPDATE_USER_PROFILE = Constants.BASE_URL + "/users";
    public static String MENTOR_UPDATE = Constants.JSON_REQ_BODY + "/Mentor/UpdateProfile/";
    public static String CREATE_NEW_TASK = Constants.BASE_URL + "/mentors/tasks";
    public static String UPDATE_TASK = Constants.BASE_URL + "/mentors/tasks/{id}";
    public static String GET_ALL_TASK_BY_ID_MENTOR = Constants.BASE_URL + "/mentors/tasks";
    public static String GET_DETAIL_TASK = Constants.BASE_URL + "/mentors/tasks/{id}";
    public static String SUBMIT_SCORE = Constants.BASE_URL + "/mentors/submission/{sub}";
    public static String ADD_MENTOR_COMMENT = Constants.BASE_URL + "/forum/{forum}";

    //Step Def Update profile by Mentor
    @Step("Put Update Profile User Mentor")
    public void setUpdateMentorProfile(File json){
        JsonPath fileJson = new JsonPath(json);
        File images = new File(Constants.UPLOAD_IMAGE + "gambar1.jpg");
        SerenityRest.given()
                .header("Authorization","Bearer "+ Constants.TOKEN_MENTOR)
                .contentType("multipart/form-data")
                .multiPart("name", fileJson.get("name").toString())
                .multiPart("email", fileJson.get("email").toString())
                .multiPart("password", fileJson.get("password").toString())
                .multiPart("images", images);
    }

    @Step("Put Update Profile Without Authorization")
    public void setUpdateWithoutAuth(File json){
        JsonPath fileJson = new JsonPath(json);
        File images = new File(Constants.UPLOAD_IMAGE + "gambar1.jpg");
        SerenityRest.given()
                .contentType("multipart/form-data")
                .multiPart("name", fileJson.get("name").toString())
                .multiPart("email", fileJson.get("email").toString())
                .multiPart("password", fileJson.get("password").toString())
                .multiPart("images", images);
    }

    @Step("Put Update Profile User Mentor With Invalid Images Extension")
    public void setUpdateInvalidImages(File json) {
        JsonPath fileJson = new JsonPath(json);
        File images = new File(Constants.UPLOAD_FILE + "tes1.pdf");
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_MENTOR)
                .contentType("multipart/form-data")
                .multiPart("name", fileJson.get("name").toString())
                .multiPart("email", fileJson.get("email").toString())
                .multiPart("password", fileJson.get("password").toString())
                .multiPart("images", images);
    }

}
