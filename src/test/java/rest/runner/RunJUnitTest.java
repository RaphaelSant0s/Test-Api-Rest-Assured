package rest.runner;

import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"rest.stepDefinitions", "rest.core"},
                monochrome = true,
                plugin = {"pretty",
                        "html:target/cucumber-html-report",
                        "json:target/cucumber-json-report.json"},
                    features = "src/test/resources/features")
public class RunJUnitTest {
}
