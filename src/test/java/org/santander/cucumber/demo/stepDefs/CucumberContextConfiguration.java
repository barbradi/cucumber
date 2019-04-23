package org.santander.cucumber.demo.stepDefs;

import cucumber.api.java.Before;
import org.santander.cucumber.demo.config.ApplicationConfig;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = ApplicationConfig.class)
public class CucumberContextConfiguration {

    @Before
    public void setup(){
        // dummy method to load spring context
    }
}
