package Mentutor.StepDef.Mentee.GetTask;

import Mentutor.Utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GetTaskAPI {
    public static String GET_ALL_TASK_MENTEE = Constants.BASE_URL+"/mentees/tasks";

    @Step("Get All Task by Mentee")
    public void setGetAllTaskMentee(){
        SerenityRest.given().headers("Authorization", "Bearer " + Constants.TOKEN_MENTEE);
    }
}
