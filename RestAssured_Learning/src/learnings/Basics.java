package learnings;

import files.payLoads;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basics {
    public static void main(String[] args) {
        //adding a place
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(payLoads.addPlace())
                .when().post("/maps/api/place/add/json").then().assertThat().statusCode(200)
                .body("scope", equalTo("APP")).header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
        JsonPath js = new JsonPath(response);
        String placeId = js.getString("place_id");

        //updating the place
        String newAddress = "Salem ,TN";
        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body("{\n" +
                        "\"place_id\":\"" + placeId + "\",\n" +
                        "\"address\":\"" + newAddress + "\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n").when().put("/maps/api/place/update/json").then().log().all().assertThat().statusCode(200)
                .body("msg", equalTo("Address successfully updated"));

        //getting the updated place
        String response1 = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId).when().get("/maps/api/place/get/json")
                .then().assertThat().statusCode(200).extract().response().asString();
        JsonPath js1 = new JsonPath(response1);
        String actualAddress = js1.getString("address");
        Assert.assertEquals(actualAddress, newAddress);
    }
}
