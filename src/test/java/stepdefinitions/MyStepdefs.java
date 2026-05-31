package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import data.MockDataGenerator;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.*;

public class MyStepdefs {

    Response response;
    Map<String, Object> samplePayLoad;
    long petId;

    @Before
    public void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        response = null;
        samplePayLoad = null;
        petId = 0L;
    }

    @Given("the details of the pet")
    public void theDetailsOfThePet() {
        samplePayLoad = MockDataGenerator.createSampleData();
        requestSpecification = given()
                .contentType(ContentType.JSON)
                .body(samplePayLoad);
    }

    @When("the data are sent using POST request")
    public void theDataAreSentUsingPOSTRequest() {
        response = when().post("/pet");
    }

    @Then("check whether the status code is {int}")
    public void checkWhetherTheStatusCodeIs(int arg0) {
        response.then().statusCode(arg0);
    }

    @Given("the identifier of the pet")
    public void theIdentifierOfThePet() {
        samplePayLoad = MockDataGenerator.createSampleData();
        Response createResponse = given()
                .contentType(ContentType.JSON)
                .body(samplePayLoad)
                .post("/pet");

        createResponse.then().statusCode(200);
        petId = createResponse.jsonPath().getLong("id");
        samplePayLoad.put("id", petId);
    }

    @When("the pet id is used to fetch with GET request")
    public void thePetIdIsUsedToFetchWithGETRequest() {
        response = given()
                .accept(ContentType.JSON)
                .get("/pet/{id}", petId);
    }

    @Then("verify the pet details")
    public void verifyThePetDetails() {
        Assert.assertNotNull(response, "No response available for verification");
        Assert.assertEquals(response.jsonPath().getLong("id"), ((Number) samplePayLoad.get("id")).longValue());
        Assert.assertEquals(response.jsonPath().getString("name"), samplePayLoad.get("name"));
        Assert.assertEquals(response.jsonPath().getString("status"), samplePayLoad.get("status"));
    }

    @When("the data are sent using PUT request")
    public void theDataAreSentUsingPUTRequest() {
        Response createResponse = given()
                .contentType(ContentType.JSON)
                .body(samplePayLoad)
                .post("/pet");

        createResponse.then().statusCode(200);
        petId = createResponse.jsonPath().getLong("id");
        samplePayLoad.put("id", petId);
        samplePayLoad.put("name", "doggie-updated");
        samplePayLoad.put("status", "pending");

        response = given()
                .contentType(ContentType.JSON)
                .body(samplePayLoad)
                .put("/pet");
    }

    @When("the pet id is used to delete using DELETE request")
    public void thePetIdIsUsedToDeleteUsingDELETERequest() {
        given()
                .delete("/pet/{id}", petId)
                .then()
                .statusCode(200);

        response = given()
                .accept(ContentType.JSON)
                .get("/pet/{id}", petId);
    }
}
