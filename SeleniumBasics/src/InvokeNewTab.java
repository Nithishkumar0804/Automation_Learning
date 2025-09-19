import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class InvokeNewTab {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        //invoking new tab
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parent = it.next();
        String child = it.next();
        driver.switchTo().window(child);
        driver.get("https://rahulshettyacademy.com/");
        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
        System.out.println(courseName);
        driver.switchTo().window(parent);
        WebElement name = driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(courseName);

        //WebElement Screenshot
        File file = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("E:\\screenshot2.jpg"));


        //Hight and Width
        System.out.println(name.getRect().getHeight());
        System.out.println(name.getRect().getWidth());
    }

}
