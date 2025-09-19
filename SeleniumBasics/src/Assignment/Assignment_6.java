package Assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_6 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("checkBoxOption2")).click();
        String labeltext = driver.findElement(By.xpath("//label[@for='benz']")).getText();

        WebElement forSel = driver.findElement(By.id("dropdown-class-example"));
        Select sel = new Select(forSel);
        sel.selectByVisibleText(labeltext);
        driver.findElement(By.id("name")).sendKeys(labeltext);

        driver.findElement(By.cssSelector("input.btn-style")).click();
        driver.switchTo().alert().accept();
    }

}
