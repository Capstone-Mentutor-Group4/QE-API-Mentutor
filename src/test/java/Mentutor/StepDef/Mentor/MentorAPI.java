package Mentutor.StepDef.Mentor;

import Mentutor.Utils.Constants;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class MentorAPI {

    public static String UPDATE_USER_PROFILE = Constants.BASE_URL + "/users";
    public static String CREATE_NEW_TASK = Constants.BASE_URL + "/mentors/tasks";
    public static String UPDATE_TASK = Constants.BASE_URL + "/mentors/tasks/{id}";
    public static String GET_ALL_TASK_BY_ID_MENTOR = Constants.BASE_URL + "/mentors/tasks";
    public static String GET_DETAIL_TASK = Constants.BASE_URL + "/mentors/tasks/{id}";
    public static String SUBMIT_SCORE = Constants.BASE_URL + "/mentors/submission/{sub}";
    public static String ADD_MENTOR_COMMENT = Constants.BASE_URL + "/forum/{forum}";
    @Step("Put Update Profile User Mentor")
    public void putUpdateMentor(File json){
        SerenityRest.given()
                .header("Authorization","Bearer "+ Constants.TOKEN_MENTOR)
                .contentType(ContentType.JSON).body(json);
    }
}
