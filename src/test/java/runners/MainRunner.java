package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"classpath:features"}, glue = {"stepDefinitions"},
    tags = "@Placeholder",monochrome = false, dryRun = false,
    plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"})
public class MainRunner extends AbstractTestNGCucumberTests {
}
