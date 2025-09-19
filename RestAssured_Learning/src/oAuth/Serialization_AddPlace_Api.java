package oAuth;

import pojoClasses.serialization.AddPlace;
import pojoClasses.serialization.Location;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Serialization_AddPlace_Api {
    public static void main(String[] args) {
        AddPlace addPlace = new AddPlace();
        Location location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        addPlace.setLocation(location);
        addPlace.setAccuracy(50);
        addPlace.setName("Frontline house");
        addPlace.setPhoneNumber("(+91) 983 893 3937");
        addPlace.setAddress("29, side layout, cohen 09");
        addPlace.setWebsite("http://google.com");
        addPlace.setLanguage("French-IN");
        List<String> types = new ArrayList<>();
        types.add("shoe park");
        types.add("shop");
        addPlace.setTypes(types);

        String response = given().log().all().body(addPlace).queryParam("key", "qaclick123")
                .when().post(" https://rahulshettyacademy.com/maps/api/place/add/json").then().statusCode(200)
                .extract().response().asString();
        System.out.println(response);
    }
}
