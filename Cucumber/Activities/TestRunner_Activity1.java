package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features", //path details
        glue = {"stepDefinitions"},      //we can add multiple  packages also
        tags="@activity1",
        //any word prefixed with @ is considered a tag. Tags can only be defined in feature file
        //To run specific feature file within Features folder, we can use tags or to run specific scenarios within feature file
        //multiple tags using and/or  "@basic and @basicscenario1"
        publish = true

        // to get a report link at the end of test run, available for 24 hours
)

public class TestRunner_Activity1 {
}
