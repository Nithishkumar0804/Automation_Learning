package Assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Assignment_3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.finsdElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.cssSelector("span.checkmark")).click();
        //driver.switchTo().alert().accept();
        WebElement websel = driver.findElement(By.cssSelector("select.form-control"));
        Select sel = new Select(websel);
        sel.selectByIndex(0);
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.xpath("//input[@name='signin']")).click();
        //driver.switchTo().alert().accept();

        List<WebElement> lisObj = driver.findElements(By.xpath("//div[@class='card-footer']"));
        for (WebElement ele : lisObj) {
            driver.findElement(By.xpath("//div[@class='card-footer']/button")).click();
        }
        driver.findElement(By.cssSelector("nav-link.btn.btn-primary")).click();

    }

}