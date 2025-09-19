import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DriverScope {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());

        // Limiting the driver Scope
        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerdriver.findElements(By.tagName("a")).size());

        WebElement columnFooter = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        // System.out.println(clmFtr.findElements(By.tagName("a")).size());

        List<WebElement> li = columnFooter.findElements(By.tagName("a"));
        Actions a = new Actions(driver);
        for (WebElement link : li) {
            a.keyDown(Keys.CONTROL).click(link).build().perform();
        }
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        while (it.hasNext()) {
            String winid = it.next();
            driver.switchTo().window(winid);
            System.out.println(driver.getTitle());

        }

    }

}
