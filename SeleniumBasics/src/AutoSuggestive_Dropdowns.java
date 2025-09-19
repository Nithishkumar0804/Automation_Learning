import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public class AutoSuggestive_Dropdowns {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub\
        System.out.print("Enter the Location:");
        Scanner sc = new Scanner(System.in);
        String loc = sc.next();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys(loc);
        Thread.sleep(3000);
        List<WebElement> li = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
        for (WebElement i : li) {
            System.out.println(i.getText() + " ");
            if (i.getText().equalsIgnoreCase(loc)) {
                i.click();
                break;
            }
        }
        sc.close();


    }

}
