
package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepdefinitions"},
        plugin = {
                "pretty",                              // Console output
                "json:target/cucumber.json"           // JSON report required by cucumber-reporting
            },
            monochrome = true                          // Better console readability
        )

public class TestRunner extends AbstractTestNGCucumberTests {
}