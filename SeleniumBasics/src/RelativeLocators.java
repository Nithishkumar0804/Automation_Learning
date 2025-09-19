import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameElement = driver.findElement(By.cssSelector(".form-control.ng-untouched.ng-pristine.ng-invalid"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameElement)).getText());

        WebElement icecreamElement = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(icecreamElement)).click();

        WebElement emplyStatus = driver.findElement(By.xpath("//label[text()='Employment Status: ']"));
        driver.findElement(with(By.tagName("input")).toRightOf(emplyStatus)).click();

        WebElement dateofBirthElement = driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dateofBirthElement)).click();
    }

}
