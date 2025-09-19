package learnings;

import files.payLoads;
import io.restassured.path.json.JsonPath;

public class ComplexJson {
    public static void main(String[] args) {
        String respone = payLoads.complexJson();
        JsonPath js = new JsonPath(respone);
        int count = js.getInt("courses.size()");
        System.out.println(count);
        int totalPrice = js.getInt("dashboard.purchaseAmount");
        System.out.println(totalPrice);
        String firstCourseTitle = js.get("courses[0].title");
        System.out.println(firstCourseTitle);
        for (int i = 0; i < count; i++) {
            System.out.println(js.get("courses[" + i + "].title").toString() + "course and it's price " + js.getInt("courses[" + i + "].price"));
        }
    }
}
