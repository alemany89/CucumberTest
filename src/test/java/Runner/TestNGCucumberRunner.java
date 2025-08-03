package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"Steps", "Hooks"},
        plugin = { "pretty", "html:target/index.html" }
)

public class TestNGCucumberRunner extends AbstractTestNGCucumberTests  {

}