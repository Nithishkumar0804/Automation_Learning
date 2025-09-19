import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Scanner;

public class Locators2 {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        String password = getPassword(driver);
        driver.findElement(By.id("inputUsername")).sendKeys(name);

        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.cssSelector(".go-to-login-btn")).click();
        Thread.sleep(500);
        driver.findElement(By.className("submit")).click();

        Thread.sleep(2000);
        String str1 = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(str1, "You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello " + name + ",");
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        sc.close();
        driver.close();


    }

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText = driver.findElement(By.cssSelector("form p")).getText();
        String[] passwordArray = passwordText.split("'");
        String password = passwordArray[1].split("'")[0];
        return password;
    }

}
