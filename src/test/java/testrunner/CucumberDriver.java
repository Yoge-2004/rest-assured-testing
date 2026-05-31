package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features/petstore_scenario.feature",
        glue = "stepdefinitions",
        plugin = {
                "pretty",
                "html:reports/CucumberReport.html",
                "json:reports/CucumberReport.json",
                "junit:reports/CucumberReport.xml"
        },
        monochrome = false
)
public class CucumberDriver extends AbstractTestNGCucumberTests {}
