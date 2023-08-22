package Mentutor.StepDef.Forum;

import Mentutor.Utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ForumAPI {
    public static String FORUM_STATUS = Constants.BASE_URL + "/forum";
    public static String GET_ALL_STATUS = Constants.BASE_URL + "/forum";

    //STEP DEF FOR FORUM
    @Step ("Post add status with valid data by Mentee")
    public void addStatusValidData(String caption, String images) {
        if (images == null){
            SerenityRest.given()
                    .headers("Authorization","Bearer "+Constants.TOKEN_MENTEE).log().all()
                    .contentType("multipart/form-data")
                    .multiPart("caption",caption);
        } else {
            SerenityRest.given()
                    .headers("Authorization","Bearer "+Constants.TOKEN_MENTEE).log().all()
                    .contentType("multipart/form-data")
                    .multiPart("caption",caption)
                    .multiPart("images", new File(Constants.UPLOAD_IMAGE +images));
        }
    }

    @Step ("Post add status with valid data without Token Mentee")
    public void addStatusValidDataWithoutAuth(String caption, String images) {
        SerenityRest.given()
                .contentType("multipart/form-data")
                .multiPart("caption",caption)
                .multiPart("images", new File (Constants.UPLOAD_IMAGE +images));
    }

    public void addStatusValidDataWithAdmin(String caption, String images) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.TOKEN_ADMIN).log().all()
                .contentType("multipart/form-data")
                .multiPart("caption", caption)
                .multiPart("images", new File(Constants.UPLOAD_IMAGE + images));
    }

    public void addStatusValidDataWithMentor(String caption, String images) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTOR).log().all()
                .contentType("multipart/form-data")
                .multiPart("caption", caption)
                .multiPart("images", new File(Constants.UPLOAD_IMAGE + images));
    }

    @Step ("Post add status with numeric caption")
    public void addStatusValidDataWithNumeric(int caption, String images) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTEE).log().all()
                .contentType("multipart/form-data")
                .multiPart("caption", caption)
                .multiPart("images", new File(Constants.UPLOAD_IMAGE + images));
    }


    @Step ("Post add status no images")
    public void addStatusValidDataWithoutImages(String caption) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTEE).log().all()
                .contentType("multipart/form-data")
                .multiPart("caption", caption);
//                .multiPart("images", new File(Constants.UPLOAD_IMAGE + images));
    }

    public void addStatusEmpty() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTEE).log().all()
                .contentType("multipart/form-data");
    }

    @Step ("Get All Status using valid path with authorization")
    public void getAllStatus() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTEE).log().all();
    }

    @Step("Get All Status without Auth")
    public void getAllStatusWithoutAuth(){
        SerenityRest.given();
    }

    @Step ("Get All Status using valid path with Token Mentor")
    public void getAllStatusWithMentor() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTOR).log().all();
    }

    @Step ("Get All Status using valid path with Token Mentor")
    public void getAllStatusWithAdmin() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constants.TOKEN_ADMIN).log().all();
    }
}

