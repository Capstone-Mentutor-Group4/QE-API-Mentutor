package Mentutor.Utils;

import io.cucumber.java.en.And;
import net.serenitybdd.rest.SerenityRest;
import static org.hamcrest.CoreMatchers.equalTo;

public class MentutorResponses {
    public static String ID_USER = "id_user";
    public static String ID_CLASS = "id_class";
    public static String NAME = "data.name";
    public static String EMAIL = "data.email";
    public static String ROLE = "data.role";
    public static String CLASS = "data.class_name";
    public static String TOKEN = "data.token";

    public static String ERROR_MESSAGE = "'message error'";
    public static String MESSAGE = "message";

    @And("Validate response body should display message {string}")
    public void validateResponseBodyShouldDisplayMessage(String message) {
        SerenityRest.and().body(MentutorResponses.MESSAGE,equalTo(message));
    }

    @And("Validate response body should display error message {string}")
    public void validateResponseBodyShouldDisplayErrorMessage(String error) {
        SerenityRest.and().body(MentutorResponses.ERROR_MESSAGE,equalTo(error));
    }
}
