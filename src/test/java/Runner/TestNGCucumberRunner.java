package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"Steps", "Hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/html",
                "json:target/cucumber.json"
        }
)

public class TestNGCucumberRunner extends AbstractTestNGCucumberTests  {

}