package Actions_Frames;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandle {
    public static void main(String[] agrs) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> window = driver.getWindowHandles();
        Iterator<String> it = window.iterator();
        String parentW = it.next();
        String ChildW = it.next();
        driver.switchTo().window(ChildW);
        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        String email1 = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim();
        String email = email1.split(" ")[0];
        driver.switchTo().window(parentW);
        driver.findElement(By.id("username")).sendKeys(email);
        Thread.sleep(2000);
        driver.quit();


    }

}
