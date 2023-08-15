package Mentutor.StepDef.Admin.GetUser;

import Mentutor.Utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GetUserAPI {
    public static String GET_ALL_USERS = Constants.BASE_URL+"/admin/users";

    @Step("Get All Users")
    public void getAllUser(){
        SerenityRest.given().headers("Authorization", "Bearer " + Constants.TOKEN_ADMIN);
    }
    @Step("Get All Users without Token")
    public void getAllUserWithoutAuth(){
        SerenityRest.given();
    }
}
