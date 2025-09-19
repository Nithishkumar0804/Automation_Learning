package learnings;

import files.payLoads;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumValidation {
    @Test
    public void sumValidation() {
        String respone = payLoads.complexJson();
        JsonPath js = new JsonPath(respone);
        int totalPrice = js.getInt("dashboard.purchaseAmount");
        int count = js.getInt("courses.size()");
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += (js.getInt("courses[" + i + "].price") * js.getInt("courses[" + i + "].copies"));
        }
        Assert.assertEquals(sum, totalPrice);
    }
}
