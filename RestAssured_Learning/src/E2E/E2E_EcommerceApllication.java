package E2E;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class E2E_EcommerceApllication {
    public static void main(String[] args) {
        //Authorization and Login
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserEmail("rnithishkumar080417@gmail.com");
        loginRequest.setUserPassword("Rnithish21##");
        RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .setContentType(ContentType.JSON).build();
        RequestSpecification reqLogin = given().spec(req).body(loginRequest);
        LoginResponse loginResponse = reqLogin.when().post("/api/ecom/auth/login").then().extract().response().as(LoginResponse.class);
        String accessToken = loginResponse.getToken();
        String userID = loginResponse.getUserId();

        //Add a new Product
        RequestSpecification addProdSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addHeader("Authorization", accessToken).build();
        RequestSpecification addProdReq = given().spec(addProdSpec).formParam("productName", "Adidas shoe")
                .formParam("productAddedBy", userID).formParam("productCategory", "Sports")
                .formParam("productSubCategory", "Shoe").formParam("productPrice", "8000")
                .formParam("productDescription", "Addias Originals").formParam("productFor", "UniSex")
                .multiPart("productImage", new File("E:\\Auotmation Course Data\\Sports Shoe.jpeg"));
        String addProdRes = addProdReq.when().post("api/ecom/product/add-product").then().log().all().extract().response().asString();
        JsonPath js = new JsonPath(addProdRes);
        String productId = js.get("productId");

        //placing a order
        RequestSpecification createOrderSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addHeader("Authorization", accessToken).setContentType(ContentType.JSON).build();
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setCountry("IND");
        orderDetails.setProductOrderedId(productId);
        List<OrderDetails> orderDetailsList = new ArrayList<>();
        orderDetailsList.add(orderDetails);
        Orders orders = new Orders();
        orders.setOrders(orderDetailsList);
        RequestSpecification createReq = given().spec(createOrderSpec).body(orders);
        String createResponse = createReq.when().post("/api/ecom/order/create-order").then().extract().response().asString();

        //delete a product
        RequestSpecification deleteSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addHeader("Authorization", accessToken).build();
        RequestSpecification deleteReq = given().spec(deleteSpec).pathParam("productId", productId);
        String deleteResponse = deleteReq.when().delete("/api/ecom/product/delete-product/{productId}").then().extract().response().asString();
        System.out.println(deleteResponse);
    }
}
