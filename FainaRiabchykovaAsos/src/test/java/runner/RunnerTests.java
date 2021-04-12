package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/smoke.feature",
        glue = "stepdefinitions",
        // tags = "~@Ignore"
        plugin={"pretty", "html:target/cucumber-html-report",
                "json:target/cucumber-report.json"},
        dryRun=false
)

public class RunnerTests
{
}
