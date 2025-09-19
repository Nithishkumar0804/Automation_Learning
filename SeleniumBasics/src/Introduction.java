import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Introduction {
    public static void main(String[] args )throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        System.out.println("Title: " + driver.getTitle());
        driver.findElement(By.id("inputUsername")).sendKeys("Nithishkumar");
        driver.findElement(By.name("inputPassword")).sendKeys("1234");
        driver.findElement(By.className("submit")).click();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Nithish");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("rnithishkumar080421@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("8870433424");
        
        driver.findElement(By.xpath("//input[@type='text'][1]")).clear();
        driver.findElement(By.xpath("//input[@type='text'][1]")).sendKeys("Nithishkumar");
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).clear();
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("rnithishkumar080417@gmail.com");
       
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        //System.out.println(driver.findElement(By.xpath("//form/p")).getText());
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.cssSelector(".go-to-login-btn")).click();
        
        Thread.sleep(1000);
        driver.findElement(By.id("inputUsername")).sendKeys("Rahual");
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.className("signInBtn")).click();
        
       //driver.quit();
    }
}
