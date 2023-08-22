package Mentutor.StepDef.Admin.UpdateClass;

import Mentutor.utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class AdminClassAPI {
    public static String UPDATE_CLASS = Constants.BASE_URL+"/admin/classes/{id_class}";

    @Step("Update Class Name")
    public void putUpdateClass(int id_class,String class_name,String status){
        SerenityRest.given().headers("Authorization", "Bearer " + Constants.TOKEN_ADMIN)
                .pathParam("id_class",id_class)
                .multiPart("class_name",class_name)
                .multiPart("status", status);
    }
    @Step("Update Class Status")
    public void putUpdateStatus(int id_class,String class_name,String status){
        SerenityRest.given().headers("Authorization", "Bearer " + Constants.TOKEN_ADMIN)
                .pathParam("id_class",id_class)
                .multiPart("class_name",class_name)
                .multiPart("status",status);
    }
    @Step("Update Class empty Name")
    public void putUpdateClassEmptyName(int id_class,String class_name,String status){
        SerenityRest.given().headers("Authorization", "Bearer " + Constants.TOKEN_ADMIN)
                .pathParam("id_class",id_class)
                .multiPart("class_name",class_name)
                .multiPart("status",status);
    }
    @Step("Update Class empty Name")
    public void putUpdateEmptyStatus(int id_class,String class_name,String status){
        SerenityRest.given().headers("Authorization", "Bearer " + Constants.TOKEN_ADMIN)
                .pathParam("id_class",id_class)
                .multiPart("class_name",class_name)
                .multiPart("status",status);
    }

}
