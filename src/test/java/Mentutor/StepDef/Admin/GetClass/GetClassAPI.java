package Mentutor.StepDef.Admin.GetClass;

import Mentutor.Utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GetClassAPI {
    public static String GET_ALL_CLASS = Constants.BASE_URL+"/admin/classes";

    @Step("Get All Class")
    public void getAllClass(){
        SerenityRest.given().headers("Authorization", "Bearer " + Constants.TOKEN_ADMIN);
    }
    @Step("Get All Class without Token")
    public void getAllClassWithoutAuth(){
        SerenityRest.given();
    }
}
