package Mentutor.StepDef.Mentee.AddComments;

import Mentutor.utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class AddCommentAPI {
    public static String ADD_COMMENT_MENTEE = Constants.BASE_URL+"/forum/{id_status}";

    @Step("Add Comment with valid id by Mentee")
    public void postAddCommentMentee(int id_status, String caption){
        SerenityRest.given()
                .pathParam("id_status",id_status)
                .headers("Authorization", "Bearer "+Constants.TOKEN_MENTEE)
                .multiPart("caption",caption);
    }
    @Step("Add Comment with unregisted id by Mentee")
    public void postAddCommenUnregistId(int id_status, String caption) {
        SerenityRest.given()
                .pathParam("id_status", id_status)
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTEE)
                .multiPart("caption", caption);
    }
    @Step("Add Comment without id by Mentee")
    public void postAddCommenWithoutId(int id_status, String caption) {
        SerenityRest.given()
                .pathParam("id_status", id_status)
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTEE)
                .multiPart("caption", caption);
    }
    @Step("Add Comment with id and Special Character caption by Mentee")
    public void postAddCommenWithIdSpecChar(int id_status, String caption) {
        SerenityRest.given()
                .pathParam("id_status", id_status)
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTEE)
                .multiPart("caption", caption);
    }
    @Step("Add Comment with id and empty caption by Mentee")
    public void postAddCommenWithIdemptyCaption(int id_status, String caption) {
        SerenityRest.given()
                .pathParam("id_status", id_status)
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTEE)
                .multiPart("caption", caption);
    }

    @Step("Add Comment with id and integer caption by Mentee")
    public void postAddCommenWithIdIntCaption(int id_status, int caption) {
        SerenityRest.given()
                .pathParam("id_status", id_status)
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTEE)
                .multiPart("caption", caption);
    }
    @Step("Add Comment with id and float caption by Mentee")
    public void postAddCommenWithIdFltCaption(int id_status, float caption) {
        SerenityRest.given()
                .pathParam("id_status", id_status)
                .headers("Authorization", "Bearer " + Constants.TOKEN_MENTEE)
                .multiPart("caption", caption);
    }
}
