package Mentutor;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "@Tugas or @TokenAdmin",
        plugin = {"pretty"},
        features = "classpath:features"
)
public class CucumberTestSuite {}
