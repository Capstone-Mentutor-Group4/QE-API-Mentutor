package Mentutor.StepDef.Admin.UpdateClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class AdminUpdateClass {
    @Steps
    AdminClassAPI adminClassAPI;

    @Given("Put update class with id {} and set class_name {string} and status {string}")
    public void putUpdateClassWithIdAndSetClass_name(int id_class, String class_name, String status) {
        adminClassAPI.putUpdateClass(id_class,class_name,status);
    }

    @When("Send request put update class")
    public void sendRequestPutUpdateClass() {
        SerenityRest.when().put(AdminClassAPI.UPDATE_CLASS);
    }


    @Given("Put update class with id {} and set class name {string} and set status to {string}")
    public void putUpdateClassWithIdAndSetClassNameAndSetStatusTo(int id_class,String status, String class_name) {
        adminClassAPI.putUpdateStatus(id_class,class_name,status);
    }

    @Given("Put update class with id {}, set class_name {string}  set status {string}")
    public void putUpdateClassWithIdSetClass_nameSetStatus(int id_class, String class_name, String status) {
        adminClassAPI.putUpdateClassEmptyName(id_class, class_name, status);
    }

    @Given("Put update class with id {}, set class_name {string} and set empty status {string}")
    public void putUpdateClassWithIdSetClass_nameAndSetEmptyStatus(int id_class, String class_name, String status) {
        adminClassAPI.putUpdateClassEmptyName(id_class, class_name, status);
    }
}
