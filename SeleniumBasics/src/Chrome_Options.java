import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome_Options {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ChromeOptions option = new ChromeOptions();
        option.setAcceptInsecureCerts(true);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(option);
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());

    }

}
