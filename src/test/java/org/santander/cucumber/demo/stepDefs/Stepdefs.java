package org.santander.cucumber.demo.stepDefs;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.javacrumbs.jsonunit.core.Option;
import org.santander.cucumber.demo.config.SharedData;
import org.santander.cucumber.demo.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static io.restassured.RestAssured.get;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static net.javacrumbs.jsonunit.core.util.ResourceUtils.resource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

public class Stepdefs {

    @Autowired
    private SharedData sharedData;

    @Autowired
    private ObjectMapper objectMapper;

    private String jsonString;

    @When("I retrieve current weather information")
    public void iRetrieveCurrentWeatherInformation() {
        Response response = get("/weather");
        response.then().assertThat().statusCode(200);
        jsonString = response.getBody().asString();
        sharedData.setJsonResponse(jsonString);
    }

    @Then("I have {int} counties weather information")
    public void iHaveCountiesWeatherInformation(int numberOfCounties) throws IOException {
        assertThatJson(sharedData.getJsonResponse())
                .when(Option.IGNORING_ARRAY_ORDER)
                .isEqualTo(resource("expectedJsons/json.json"));

        Weather weather = objectMapper.readValue(sharedData.getJsonResponse(), Weather.class);
        assertThat(weather.getCounties())
                .filteredOn(county -> county.isRaining() == false)
                .extracting("name","temperature")
                .contains(
                        tuple("Buckinghamshire", 3),
                        tuple("Cambridgeshire", 4));


    }
}