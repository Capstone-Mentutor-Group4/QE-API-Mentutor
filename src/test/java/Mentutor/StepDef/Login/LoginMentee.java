package Mentutor.StepDef.Login;

import Mentutor.Utils.Constants;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class LoginMentee {

    @Steps
    LoginAPI loginAPI;
    @Given("Post login mentee with valid json")
    public void postLoginMenteeWithValidJson() {
        File json = new File(Constants.JSON_REQ_BODY +"/Login/LoginMentee.json");
        loginAPI.postLoginMentee(json);
    }
}
