package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features", //path details
        glue = {"stepDefinitions"},      //we can add multiple  packages also
        tags="@activity4"
)

public class TestRunner_Activity4 {
}
