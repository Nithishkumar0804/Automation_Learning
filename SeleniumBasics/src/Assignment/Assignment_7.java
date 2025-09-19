package Assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Assignment_7 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        System.out.println(driver.findElements(By.xpath("//table[@name='courses']/tbody/tr")).size());
        System.out.println(driver.findElements(By.xpath("//table[@id='product']/tbody/tr[1]/th")).size());
        List<WebElement> tableData = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[3]/td"));
        for (int i = 0; i < tableData.size(); i++) {
            System.out.print(tableData.get(i).getText() + " | ");
        }
    }

}
