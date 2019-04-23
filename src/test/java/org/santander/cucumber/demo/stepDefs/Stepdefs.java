package org.santander.cucumber.demo.stepDefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.javacrumbs.jsonunit.core.Option;
import org.santander.cucumber.demo.config.SharedData;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.get;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static net.javacrumbs.jsonunit.core.util.ResourceUtils.resource;

public class Stepdefs {

    @Autowired
    private SharedData sharedData;

    private String jsonString;

    @When("I retrieve current weather information")
    public void iRetrieveCurrentWeatherInformation() {
        Response response = get("/weather");
        response.then().assertThat().statusCode(200);
        jsonString = response.getBody().asString();
        sharedData.setJsonResponse(jsonString);
    }

    @Then("I have {int} counties weather information")
    public void iHaveCountiesWeatherInformation(int numberOfCounties) {
        assertThatJson(sharedData.getJsonResponse())
                .when(Option.IGNORING_ARRAY_ORDER)
                .isEqualTo(resource("expectedJsons/json.json"));
    }
}