package libraryAPI;

import files.payLoads;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LibraryAPI {
    @Test
    public void addABook() {
        RestAssured.baseURI = "http://216.10.245.166";
        String response = given().log().all().header("Content-Type", "application/json")
                .body(payLoads.addBook("gyh", "34567")).when().post("/Library/Addbook.php").then().log()
                .all().assertThat().statusCode(200).extract().response().asString();
        JsonPath js = new JsonPath(response);
        String id = js.get("ID");
        System.out.println(id);

    }
}
