package Assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Assignment_4 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> window = driver.getWindowHandles();
        Iterator<String> it = window.iterator();
        String parentW = it.next();
        String childW = it.next();
        driver.switchTo().window(childW);
        System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
        driver.switchTo().window(parentW);
        System.out.println(driver.findElement(By.cssSelector("[class='example'] h3")).getText());
    }

}
