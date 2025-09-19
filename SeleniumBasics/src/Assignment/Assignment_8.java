package Assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

public class Assignment_8 {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a country to select:");
        String country = sc.next();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("autocomplete")).sendKeys(country);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-menu-item-wrapper")));

        List<WebElement> autosuggest = driver.findElements(By.className("ui-menu-item-wrapper"));
        boolean found = false;
        for (WebElement cunt : autosuggest) {
            //System.out.println(cunt.getText());
            if (cunt.getText().toLowerCase().startsWith(country.toLowerCase())) {
                cunt.click();
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("found");
        } else {
            System.out.print("not found");
        }
        sc.close();
    }

}
