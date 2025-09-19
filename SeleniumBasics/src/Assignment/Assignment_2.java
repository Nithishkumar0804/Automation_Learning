package Assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_2 {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Rahulshetty");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Rahulshetty@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("Rahulshetty@12345");
        driver.findElement(By.id("exampleCheck1")).click();
        driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']/option[1]")).click();
        driver.findElement(By.xpath("//input[@id='inlineRadio1']")).click();
        driver.findElement(By.xpath("//input[@type='date']")).sendKeys("22-04-2002");
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
    }

}
