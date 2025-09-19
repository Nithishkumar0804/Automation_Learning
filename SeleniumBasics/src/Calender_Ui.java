import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Calender_Ui {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String date = "20";
        String month = "7";
        String year = "2026";
        String dateArray[] = {month, date, year};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.className("react-date-picker__inputGroup")).click();
        driver.findElement(By.className("react-calendar__navigation__label")).click();
        driver.findElement(By.className("react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
        driver.findElements(By.cssSelector(".react-calendar__tile")).get(Integer.parseInt(month) - 1).click();
        driver.findElement(By.xpath("//abbr[text()='" + date + "']")).click();


        List<WebElement> li = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        for (int i = 0; i < li.size(); i++) {
            System.out.print(li.get(i).getDomAttribute("value") + "/");
            Assert.assertEquals(li.get(i).getDomAttribute("value"), dateArray[i]);
        }

    }

}
