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
    public static String MENTOR_TASK = Constants.JSON_REQ_BODY + "/Mentor/AddTask/";
    public static String UPDATE_TASK = Constants.BASE_URL + "/mentors/tasks/{id}";
    public static String UPDATE_MENTOR_TASK = Constants.JSON_REQ_BODY + "/Mentor/UpdateTask/";
    public static String GET_ALL_TASK_BY_ID_MENTOR = Constants.BASE_URL + "/mentors/tasks";
    public static String GET_DETAIL_TASK = Constants.BASE_URL + "/mentors/tasks/{id}";
    public static String SUBMIT_SCORE = Constants.BASE_URL + "/mentors/submission/{sub}";
    public static String ADD_MENTOR_COMMENT = Constants.BASE_URL + "/forum/{id_status}";
    public static String MENTOR_COMMENT = Constants.JSON_REQ_BODY + "/Mentor/AddComment/";

    //Step Def Update profile by Mentor
    @Step("Put Update Profile User Mentor")
    public void setUpdateMentorProfile(File json) {
        JsonPath fileJson = new JsonPath(json);
        File images = new File(Constants.UPLOAD_IMAGE + "gambar1.jpg");
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTOR)
                .contentType("multipart/form-data")
                .multiPart("name", fileJson.get("name").toString())
                .multiPart("email", fileJson.get("email").toString())
                .multiPart("password", fileJson.get("password").toString())
                .multiPart("images", images);
    }

    @Step("Put Update Profile Without Authorization")
    public void setUpdateWithoutAuth(File json) {
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
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTOR)
                .contentType("multipart/form-data")
                .multiPart("name", fileJson.get("name").toString())
                .multiPart("email", fileJson.get("email").toString())
                .multiPart("password", fileJson.get("password").toString())
                .multiPart("images", images);
    }

    @Step("Post Create Task By Mentor")
    public void setCreateTaskMentor(File json) {
        JsonPath fileJson = new JsonPath(json);
        File images = new File(Constants.UPLOAD_IMAGE + "test1.PNG");
        File file = new File(Constants.UPLOAD_FILE + "tes1.pdf");
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTOR)
                .contentType("multipart/form-data")
                .multiPart("title", fileJson.get("title").toString())
                .multiPart("description", fileJson.get("description").toString())
                .multiPart("images", images)
                .multiPart("file", file)
                .multiPart("due_date", fileJson.get("due_date").toString());
    }

    public void setCreateNewTaskValid(String title, String description, String images, String file, String time) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTOR).log().all()
                .contentType("multipart/form-data")
                .multiPart("title", title)
                .multiPart("description", description)
                .multiPart("images", new File(Constants.UPLOAD_IMAGE + images))
                .multiPart("file", new File(Constants.UPLOAD_FILE + file))
                .multiPart("due_date", time);
    }

    public void setCreateTaskMentorIncomplete(String title, String description, String images, String file, String time) {
        if (images == null) {
            SerenityRest.given()
                    .headers("Authorization", "Bearer " + Constants.TOKEN_MENTOR).log().all()
                    .contentType("multipart/form-data")
                    .multiPart("title", title)
                    .multiPart("description", description)
                    .multiPart("file", new File(Constants.UPLOAD_FILE + file))
                    .multiPart("due_date", time);
        } else if (file == null) {
            SerenityRest.given()
                    .headers("Authorization", "Bearer " + Constants.TOKEN_MENTOR).log().all()
                    .contentType("multipart/form-data")
                    .multiPart("title", title)
                    .multiPart("description", description)
                    .multiPart("images", new File(Constants.UPLOAD_IMAGE + images))
                    .multiPart("due_date", time);
        }
    }

    @Step("Get All Task By Mentor")
    public void setGetAllTaskByMentor() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTOR)
                .log().all();
    }

    @Step("Get All Task Without Token Mentor")
    public void setGetAllWithoutToken() {
        SerenityRest.given()
                .log().all();
    }

    @Step("Get Detail Task with Task id")
    public void setGetDetailTask(int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTOR)
                .pathParam("id", id).log().all();
    }

    @Step("Get Detail Task with Invalid Task id")
    public void setGetDetailInvalid(String id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTOR)
                .pathParam("id", id).log().all();
    }

    @Step("Get Detail Task without Token Mentor")
    public void setGetDetailTaskWithoutToken(int id) {
        SerenityRest.given().log().all()
                .pathParam("id", id);
    }

    @Step("Put Update Task By Mentor")
    public void setUpdateTaskMentor(int id, File json) {
        JsonPath fileJson = new JsonPath(json);
        File images = new File(Constants.UPLOAD_IMAGE + "test2.PNG");
        File file = new File(Constants.UPLOAD_FILE + "tes2.pdf");
        SerenityRest.given()
                .pathParam("id", id)
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTOR)
                .contentType("multipart/form-data")
                .multiPart("title", fileJson.get("title").toString())
                .multiPart("description", fileJson.get("description").toString())
                .multiPart("images", images)
                .multiPart("file", file)
                .multiPart("due_date", fileJson.get("due_date").toString());
    }

    public void setUpdateTaskInvalid(String id, File json) {
        JsonPath fileJson = new JsonPath(json);
        File images = new File(Constants.UPLOAD_IMAGE + "test2.PNG");
        File file = new File(Constants.UPLOAD_FILE + "tes2.pdf");
        SerenityRest.given()
                .pathParam("id", id)
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTOR)
                .contentType("multipart/form-data")
                .multiPart("title", fileJson.get("title").toString())
                .multiPart("description", fileJson.get("description").toString())
                .multiPart("images", images)
                .multiPart("file", file)
                .multiPart("due_date", fileJson.get("due_date").toString());
    }

    public void setUpdateTaskWithoutID(File json) {
        JsonPath fileJson = new JsonPath(json);
        File images = new File(Constants.UPLOAD_IMAGE + "test2.PNG");
        File file = new File(Constants.UPLOAD_FILE + "tes2.pdf");
        int id = 0;
        SerenityRest.given()
                .pathParam("id", id)
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTOR)
                .contentType("multipart/form-data")
                .multiPart("title", fileJson.get("title").toString())
                .multiPart("description", fileJson.get("description").toString())
                .multiPart("images", images)
                .multiPart("file", file)
                .multiPart("due_date", fileJson.get("due_date").toString());
    }

    public void setUpdateTaskValid(int id, String title, String description, String images, String file, String time) {
        SerenityRest.given()
                .pathParam("id", id)
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTOR).log().all()
                .contentType("multipart/form-data")
                .multiPart("title", title)
                .multiPart("description", description)
                .multiPart("images", new File(Constants.UPLOAD_IMAGE + images))
                .multiPart("file", new File(Constants.UPLOAD_FILE + file))
                .multiPart("due_date", time);
    }

    @Step("Post Submit Score By Mentor")
    public void setSubmitScore(int task, int sub, int score) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTOR)
                .pathParam("sub", sub)
                .multiPart("id_task", task)
                .multiPart("score", score)
                .log().all();
    }

    @Step("Post Submit Score By Mentor Invalid")
    public void setSubmitScoreInvalid(String task, int sub, int score) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTOR)
                .pathParam("sub", sub)
                .multiPart("id_task", task)
                .multiPart("score", score)
                .log().all();
    }

    public void setSubmitScoreFloat(int task, int sub, float score) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTOR)
                .pathParam("sub", sub)
                .multiPart("id_task", task)
                .multiPart("score", score)
                .log().all();
    }

    public void setSubmitScoreString(int task, int sub, String score) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTOR)
                .pathParam("sub", sub)
                .multiPart("id_task", task)
                .multiPart("score", score)
                .log().all();
    }

    public void setSubmitScoreEmpty(int task, int sub) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTOR)
                .pathParam("sub", sub)
                .multiPart("id_task", task)
                .log().all();
    }

    @Step("Post Add Comment Valid By Mentor")
    public void setAddCommentValid(int id_status, File json) {
        JsonPath fileJson = new JsonPath(json);
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTOR)
                .pathParam("id_status", id_status)
                .multiPart("caption", fileJson.get("caption").toString())
                .log().all();
    }

    public void setAddMentorCommentValid(int id_status, String caption) {
        SerenityRest.given()
                .headers("Authorization","Bearer "+ Constants.TOKEN_MENTOR)
                .pathParam("id_status",id_status)
                .multiPart("caption", caption)
                .log().all();
    }

//    @Step("Post Add Comment Invalid By Mentor")
//    public void setAddCommentInvalid(String id, File json) {
//        {
//            JsonPath fileJson = new JsonPath(json);
//            SerenityRest.given()
//                    .headers("Authorization", "Bearer " + Constants.TOKEN_MENTOR)
//                    .pathParam("forum", id)
//                    .multiPart("comment", fileJson.get("comment").toString())
//                    .log().all();
//        }
//    }
}