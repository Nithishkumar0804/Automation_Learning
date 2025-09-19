import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLink {

    public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
        // TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> links = driver.findElements(By.cssSelector("[class='gf-li'] a"));
        SoftAssert a = new SoftAssert();
        for (int i = 0; i < links.size(); i++) {
            String url = links.get(i).getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int responseCode = conn.getResponseCode();
            System.out.println("Response code: " + responseCode);
            a.assertTrue(responseCode < 400, "The " + links.get(i).getText() + " Link is failed with the status code :" + responseCode);
        }
        a.assertAll();

    }

}
