package Mentutor.StepDef.Admin.Delete;

import Mentutor.utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class AdminDeleteAPI {
    public static String DELETE_CLASS = Constants.BASE_URL+"/admin/classes/{id_class}";
    public static String DELETE_USER = Constants.BASE_URL+"/admin/users/{id_user}";

    @Step("Delete class with valid id class")
    public void deleteClass(int id_class){
        SerenityRest.given()
                .headers("Authorization","Bearer "+Constants.TOKEN_ADMIN)
                .pathParam("id_class",id_class);
    }
    @Step("Delete class with invalid id class")
    public void deleteClasswithInvalidId(int id_class){
        SerenityRest.given()
                .headers("Authorization","Bearer "+Constants.TOKEN_ADMIN)
                .pathParam("id_class",id_class);
    }
    @Step("Delete user with valid id user")
    public void deleteUser(int id_user){
        SerenityRest.given()
                .pathParam("id_user",id_user)
                .headers("Authorization", "Bearer "+Constants.TOKEN_ADMIN);
    }
    @Step("Delete user with invalid id user")
    public void deleteInvalidUser(int id_user){
        SerenityRest.given()
                .pathParam("id_user",id_user)
                .headers("Authorization", "Bearer "+Constants.TOKEN_ADMIN);
    }
    @Step("Delete user with valid id user without token")
    public void deleteUserWithoutAuth(int id_user){
        SerenityRest.given()
                .pathParam("id_user",id_user);
    }

}
