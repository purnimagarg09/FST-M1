package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features", //path details
        glue = {"stepDefinitions"},      //we can add multiple  packages also
        tags="@SmokeTest",
       // plugin = {"json: test-reports/json-report.json"},
       // plugin = {"html: test-reports"},
        plugin = {"pretty"},
        monochrome = true
)
public class TestRunner_Activity6 {
}
