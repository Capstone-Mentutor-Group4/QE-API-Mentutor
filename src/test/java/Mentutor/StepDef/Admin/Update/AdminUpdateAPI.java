package Mentutor.StepDef.Admin.Update;

import Mentutor.Utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

import static org.apache.commons.io.FileUtils.getFile;

public class AdminUpdateAPI {
    public static String UPDATE_USER = Constants.BASE_URL + "/admin/users/{id_user}";

    @Step("Update User")
    public void putUpdateUser( int id_user,String name, String email, String password, String images,int id_class){
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_ADMIN)
                .pathParam("id_user",id_user)
                .multiPart("name", name)
                .multiPart("email", email)
                .multiPart("password", password)
                .multiPart("images", new File(Constants.IMAGES+images))
                .multiPart("id_class", id_class);
    }
    @Step("Put Update without Authorization")
    public void putUpdateUnauth(int id_user,String name, String email, String password, String images,int id_class){
        SerenityRest.given()
                .pathParam("id_user",id_user)
                .multiPart("name", name)
                .multiPart("email", email)
                .multiPart("password", password)
                .multiPart("images", new File(Constants.IMAGES+images))
                .multiPart("id_class", id_class);
    }
    @Step("Update User")
    public void putUpdateUnregist( int id_user,String name, String email, String password, String images,int id_class) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_ADMIN)
                .pathParam("id_user", id_user)
                .multiPart("name", name)
                .multiPart("email", email)
                .multiPart("password", password)
                .multiPart("images", new File(Constants.IMAGES + images))
                .multiPart("id_class", id_class);
    }
    @Step("Update User")
    public void putUpdateNumericName( int id_user,int name, String email, String password, String images,int id_class) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_ADMIN)
                .pathParam("id_user", id_user)
                .multiPart("name", name)
                .multiPart("email", email)
                .multiPart("password", password)
                .multiPart("images", new File(Constants.IMAGES + images))
                .multiPart("id_class", id_class);
    }
    @Step("Update User")
    public void putUpdateSpecCharName( int id_user,String name, String email, String password, String images,int id_class) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_ADMIN)
                .pathParam("id_user", id_user)
                .multiPart("name", name)
                .multiPart("email", email)
                .multiPart("password", password)
                .multiPart("images", new File(Constants.IMAGES + images))
                .multiPart("id_class", id_class);
    }
    @Step("Update User")
    public void putUpdateEmptyName( int id_user,String name, String email, String password, String images,int id_class) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_ADMIN)
                .pathParam("id_user", id_user)
                .multiPart("name", name)
                .multiPart("email", email)
                .multiPart("password", password)
                .multiPart("images", new File(Constants.IMAGES + images))
                .multiPart("id_class", id_class);
    }

    @Step("Update User")
    public void putUpdateNumericPass( int id_user,String name, String email, int password, String images,int id_class) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_ADMIN)
                .pathParam("id_user", id_user)
                .multiPart("name", name)
                .multiPart("email", email)
                .multiPart("password", password)
                .multiPart("images", new File(Constants.IMAGES + images))
                .multiPart("id_class", id_class);
    }
    @Step("Update User")
    public void putUpdateSpecCharPass( int id_user,String name, String email, String password, String images,int id_class) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_ADMIN)
                .pathParam("id_user", id_user)
                .multiPart("name", name)
                .multiPart("email", email)
                .multiPart("password", password)
                .multiPart("images", new File(Constants.IMAGES + images))
                .multiPart("id_class", id_class);
    }


}
