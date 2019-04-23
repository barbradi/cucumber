package org.santander.cucumber.demo;

import courgette.api.CourgetteOptions;
import courgette.api.CourgetteRunLevel;
import courgette.api.junit.Courgette;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;


@RunWith(Courgette.class)
@CourgetteOptions(
        threads = 10,
        runLevel = CourgetteRunLevel.SCENARIO,
        rerunFailedScenarios = true,
        rerunAttempts = 1,
        showTestOutput = true,
        reportTargetDir = "reports",
        cucumberOptions = @CucumberOptions(
                features = {"src/test/resources/features"},
                glue = {"org.santander.cucumber.demo.stepDefs"},
                plugin = {
                        "pretty",
                        "json:reports/cucumber-report/cucumber.json",
                        "html:reports/cucumber-report/cucumber.html",
                        "junit:reports/cucumber-report/cucumber.xml"
                })
)
public class DemoTestParallel {
}
