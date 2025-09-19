package oAuth;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import pojoClasses.deserialization.GetCourses;
import pojoClasses.deserialization.api;
import pojoClasses.deserialization.webAutomation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ClientCredOAuth_DeSerialization {
    public static void main(String[] args) {
        //Authorization server
        String response = given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").formParam("grant_type", "client_credentials")
                .formParam("scope", "trust")
                .when().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
        JsonPath js = new JsonPath(response);

        //Endpoint for getting courses using access token
        String accessToken = js.getString("access_token");
        GetCourses courses = given().queryParam("access_token", accessToken)
                .when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
                .as(GetCourses.class);

        //Accessing the data using objects
        System.out.println(courses.getLinkedIn());

        List<api> apiCourses = courses.getCourses().getApi();
        for (int i = 0; i < apiCourses.size(); i++) {
            if (apiCourses.get(i).getCourseTitle().equals("Rest Assured Automation using Java")) {
                System.out.println(apiCourses.get(i).getPrice());
            }
        }
        String[] expected = {"Selenium Webdriver Java", "Cypress", "Protractor"};
        List<String> expectedCourse = Arrays.asList(expected);
        List<String> actual = new ArrayList<>();
        List<webAutomation> webAutomations = courses.getCourses().getWebAutomation();
        for (int i = 0; i < webAutomations.size(); i++) {
            actual.add(webAutomations.get(i).getCourseTitle());
        }
        Assert.assertTrue(actual.equals(expectedCourse));
    }
}
