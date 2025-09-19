package Actions_Frames;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        Actions a = new Actions(driver);
        WebElement sourece = driver.findElement(By.id("draggable"));
        WebElement destination = driver.findElement(By.id("droppable"));
        a.dragAndDrop(sourece, destination).build().perform();
        driver.switchTo().defaultContent();

    }

}
