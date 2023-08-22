package Mentutor.StepDef.Admin.GetProfileUser;

import Mentutor.Utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GetProfileAPI {
    public static String GET_PROFILE_USER = Constants.BASE_URL+"/admin/users/{id_user}";

    @Step("Get Profile User")
    public void getProfileUser(int id_user){
        SerenityRest.given()
                .pathParam("id_user",id_user)
                .headers("Authorization", "Bearer " + Constants.TOKEN_ADMIN);
    }
    @Step("Get Profile User without Token")
    public void getProfileUserWithoutAuth(int id_user){
        SerenityRest.given().pathParam("id_user",id_user);
    }
    @Step("Get Profile with Unregisted Id")
    public void getProfileUserUnregist(int id_user){
        SerenityRest.given()
                .pathParam("id_user",id_user)
                .headers("Authorization", "Bearer " + Constants.TOKEN_ADMIN);
    }
}
