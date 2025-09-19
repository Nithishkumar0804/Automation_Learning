package oAuth;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class OAuth_AuthorizationCode {
    public static void main(String[] args) throws InterruptedException {
        String currentUrl = "https://rahulshettyacademy.com/getCourse.php?state=dfjhqwfqfwgiugbkjbjiwudgiu&code=4%2F0AVGzR1BHU_BcL4Gs1rjM4Xdmx3OnjzTOw_ogJEEqVjv1g7eIaoDuNdMkeyqMuF1idOuKcw&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=1&prompt=none";
        String partialCode = currentUrl.split("code=")[1];
        String code = partialCode.split("&scope")[0];
        System.out.println("Authorization Code: " + code);

        // Exchange code for access token
        String response = given()
                .urlEncodingEnabled(false)
                .queryParams("code", code)
                .queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                .queryParams("grant_type", "authorization_code")
                .queryParams("state", "verifyfjdss")
                .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")
                .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
                .when().log().all()
                .post("https://www.googleapis.com/oauth2/v4/token")
                .asString();

        // Extract access token from the response
        JsonPath jsonPath = new JsonPath(response);
        String accessToken = jsonPath.getString("access_token");
        System.out.println("Access Token: " + accessToken);

        // Use the access token to get course details
        String courseResponse = given()
                .contentType("application/json")
                .queryParams("access_token", accessToken)
                .expect().defaultParser(Parser.JSON)
                .when()
                .get("https://rahulshettyacademy.com/getCourse.php")
                .asString();

        System.out.println("Course Response:\n" + courseResponse);
    }
}
