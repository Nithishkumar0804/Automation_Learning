package libraryAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class DataDrivenJsonAndExcel {
    @Test
    public void addABookFromHashMap() {
        RestAssured.baseURI = "http://216.10.245.166";
        HashMap<String, Object> obj = new HashMap<>();
        obj.put("name", "Learn Appium Automation with Java");
        obj.put("isbn", "jgwid");
        obj.put("aisle", "45678");
        obj.put("author", "bgyhnmj");

        String response = given().log().all().header("Content-Type", "application/json")
                .body(obj).when().post("/Library/Addbook.php").then().log()
                .all().assertThat().statusCode(200).extract().response().asString();
        JsonPath js = new JsonPath(response);
        String id = js.get("ID");
        System.out.println(id);
    }
}