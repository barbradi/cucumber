package org.santander.cucumber.demo;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"org.santander.cucumber.demo.stepDefs"},
        plugin = {
                "json:reports/result.json",
                "html:reports/result.html"
        })
public class DemoTest {
}
