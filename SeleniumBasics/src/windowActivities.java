import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class windowActivities {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select obj = new Select(dropdown);
        obj.selectByIndex(1);
        System.out.println(obj.getFirstSelectedOption().getText());
        obj.selectByVisibleText("AED");
        System.out.println(obj.getFirstSelectedOption().getText());
        obj.selectByValue("USD");
        System.out.println(obj.getFirstSelectedOption().getText());

    }

}
