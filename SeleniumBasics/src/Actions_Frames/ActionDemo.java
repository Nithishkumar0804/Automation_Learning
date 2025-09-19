package Actions_Frames;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().sendKeys("protien").build().perform();
        a.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).doubleClick().build().perform();
    }


}
