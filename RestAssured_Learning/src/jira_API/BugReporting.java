package jira_API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.File;

import static io.restassured.RestAssured.given;

public class BugReporting {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://rnithishkumar080422.atlassian.net/";

        // Create a issue
        String response = given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic cm5pdGhpc2hrdW1hcjA4MDQyMkBnbWFpbC5jb206QVRBVFQzeEZmR0YwcnBTNEZwOWhNQXNubEFhT2lEWVY0M0pqaFJicEg1eWFfdTlaaDF2aW5Kc2U1Vzd0NGczZ1pPQ3ZHbk1OcG9QejJTU29wdkJRQkVTMzBQUFFSTjh6T08tcUNvLVlXRVcwQkV6b3gya0Y0djl3WFNWUmF5cGNmWl9kTFR2dTBwNy1SUTFWZHJvNnF3bEFXVGZlVWhDc0ppY3hGVEtsbEJOVzdoYmhFU3ZaYVprPUIxNUUxNTgy")
                .body("{\n" +
                        "    \"fields\": {\n" +
                        "       \"project\": {\n" +
                        "          \"key\": \"RAL\"\n" +
                        "       },\n" +
                        "       \"summary\": \"Links not working\",\n" +
                        "       \"issuetype\": {\n" +
                        "            \"name\": \"Bug\"\n" +
                        "       }\n" +
                        "   }\n" +
                        "}")
                .when()
                .post("rest/api/3/issue")
                .then().log().all()
                .assertThat().statusCode(201)
                .extract().response().asString();

        JsonPath js = new JsonPath(response);
        String issueId = js.getString("id");
        System.out.println(issueId);

        //add attachments
        given().log().all()
                .pathParam("key", js.getString("id"))
                .header("Authorization", "Basic cm5pdGhpcs2hrdW1hcjA4MDQyMkBnbWFpbC5jb206QVRBVFQzeEZmR0YwcnBTNEZwOWhNQXNubEFhT2lEWVY0M0pqaFJicEg1eWFfdTlaaDF2aW5Kc2U1Vzd0NGczZ1pPQ3ZHbk1OcG9QejJTU29wdkJRQkVTMzBQUFFSTjh6T08tcUNvLVlXRVcwQkV6b3gya0Y0djl3WFNWUmF5cGNmWl9kTFR2dTBwNy1SUTFWZHJvNnF3bEFXVGZlVWhDc0ppY3hGVEtsbEJOVzdoYmhFU3ZaYVprPUIxNUUxNTgy")
                .header("X-Atlassian-Token", "no-check")
                .multiPart("file", new File("C:\\Users\\rnith\\Pictures\\Screenshots\\Screenshot 2025-09-07 142347.png"))
                .when()
                .post("rest/api/3/issue/{key}/attachments")
                .then().log().all()
                .assertThat().statusCode(200);

        //get the issue by id
        given().log().all().pathParam("key", js.getString("id")).header("Accept", "application/json").header("Authorization", "Basic cm5pdGhpc2hrdW1hcjA4MDQyMkBnbWFpbC5jb206QVRBVFQzeEZmR0YwcnBTNEZwOWhNQXNubEFhT2lEWVY0M0pqaFJicEg1eWFfdTlaaDF2aW5Kc2U1Vzd0NGczZ1pPQ3ZHbk1OcG9QejJTU29wdkJRQkVTMzBQUFFSTjh6T08tcUNvLVlXRVcwQkV6b3gya0Y0djl3WFNWUmF5cGNmWl9kTFR2dTBwNy1SUTFWZHJvNnF3bEFXVGZlVWhDc0ppY3hGVEtsbEJOVzdoYmhFU3ZaYVprPUIxNUUxNTgy")
                .when().get("rest/api/3/issue/{key}").then().log().all().statusCode(200);
    }
}
