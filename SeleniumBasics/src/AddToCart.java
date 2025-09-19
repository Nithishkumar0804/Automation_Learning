import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AddToCart {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        AddToCart obj = new AddToCart();

        //ImplicitWait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        String item[] = {"Cucumber", "Beetroot", "Beans", "Potato"};
        obj.addItems(driver, item);
        driver.findElement(By.cssSelector("[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        //Explicit Wait
        WebDriverWait wai = new WebDriverWait(driver, Duration.ofSeconds(7));
        wai.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='promoInfo']")));

        System.out.println(driver.findElement(By.cssSelector("[class='promoInfo']")).getText());

    }


    public void addItems(WebDriver driver, String[] item) {
        List<String> itemsNeed = Arrays.asList(item);
        List<WebElement> wholeCart = driver.findElements(By.cssSelector("h4.product-name"));
        int j = 0;
        for (int i = 0; i < wholeCart.size(); i++) {
            String[] wholeCartArray = wholeCart.get(i).getText().split("-");
            String wholeCartSinleItem = wholeCartArray[0].trim();
            if (itemsNeed.contains(wholeCartSinleItem)) {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == item.length) {
                    break;
                }
            }
        }

    }

}
