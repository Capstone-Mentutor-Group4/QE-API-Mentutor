package Mentutor.StepDef.Mentee.AssignTask;

import Mentutor.utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class AssignAPI {
    public static String ASSIGN_TASK_MENTEE = Constants.BASE_URL+"/mentees/submission/{id_task}";

    @Step("Assign Task Mentee with valid id data")
    public void postAssignTask(int id_task, String file){
        SerenityRest.given().headers("Authorization","Bearer "+ Constants.TOKEN_MENTEE)
                .pathParam("id_task",id_task)
                .multiPart("file", new File(Constants.FILE +file));
    }
    @Step("Assign Task Mentee with invalid id and valid data")
    public void postAssignTaskinvalidId(String id_task, String file){
        SerenityRest.given().headers("Authorization","Bearer "+ Constants.TOKEN_MENTEE)
                .pathParam("id_task",id_task)
                .multiPart("file", new File(Constants.FILE +file));
    }
    @Step("Assign Task Mentee with unregisted id and valid data")
    public void postAssignTaskUnregistId(int id_task, String file){
        SerenityRest.given().headers("Authorization","Bearer "+ Constants.TOKEN_MENTEE)
                .pathParam("id_task",id_task)
                .multiPart("file", new File(Constants.FILE +file));
    }
    @Step("Assign Task Mentee with valid id and invalid data")
    public void postAssignTaskInvalidData(int id_task, String file){
        SerenityRest.given().headers("Authorization","Bearer "+ Constants.TOKEN_MENTEE)
                .pathParam("id_task",id_task)
                .multiPart("file", new File(Constants.FILE +file));
    }
    @Step("Assign Task Mentee with Admin Token")
    public void postAssignTaskAdminToken(int id_task, String file){
        SerenityRest.given().headers("Authorization","Bearer "+ Constants.TOKEN_ADMIN)
                .pathParam("id_task",id_task)
                .multiPart("file", new File(Constants.FILE +file));
    }
    @Step("Assign Task Mentee without Token")
    public void postAssignTaskWithoutToken(int id_task, String file){
        SerenityRest.given().pathParam("id_task",id_task)
                .multiPart("file", new File(Constants.FILE +file));
    }
}
