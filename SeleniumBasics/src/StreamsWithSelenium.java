import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsWithSelenium {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//table[@class='table table-bordered']/thead/tr/th[1]")).click();
        List<WebElement> vegElement = driver.findElements(By.xpath("//tbody/tr/td[1]"));

        List<String> orginalList = vegElement.stream().map(i -> i.getText()).collect(Collectors.toList());
        List<String> sortedList = orginalList.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(orginalList.equals(sortedList));

        List<String> price;
        do {
            List<WebElement> vegiesElement = driver.findElements(By.xpath("//tbody/tr/td[1]"));
            price = vegiesElement.stream().filter(i -> i.getText().contains("Potato")).map(i -> getPrice(i)).collect(Collectors.toList());
            price.forEach(System.out::println);
            if (price.size() < 1) {
                driver.findElement(By.cssSelector("[aria-label=Next]")).click();
            }
        }
        while (price.size() < 1);
        StreamsWithSelenium.filters(driver);
    }

    private static String getPrice(WebElement i) {
        String price = i.findElement(By.xpath("following-sibling::td[1]")).getText();
        return price;
    }

    private static void filters(WebDriver driver) {
        driver.findElement(By.id("search-field")).sendKeys("Rice");
        List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));

        //filter it to compare with retrived result to check whether it matches or not
        List<WebElement> filteredList = veggies.stream().filter(i -> i.getText().contains("Rice")).collect(Collectors.toList());
        Assert.assertEquals(veggies.size(), filteredList.size());
    }

}
