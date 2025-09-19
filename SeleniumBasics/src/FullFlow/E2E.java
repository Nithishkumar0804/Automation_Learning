package FullFlow;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class E2E {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //(OR)
        //driver.get("https://www.spicejet.com");

        //from to To Destination
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='MAA']")).click();
        Thread.sleep(100);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")).click();

        //Calender
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
        //to check the return date is Enabled or Disabled
        if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")) {
            System.out.println("Enable");
        } else {
            System.out.println("Disabled");
        }
        //To Enable Senior Citizen
        driver.findElement(By.cssSelector("input[name*=SeniorCitizenDiscount]")).click();

        //To add passenger
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(100);
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();

        //To select currency
        WebElement dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select obj = new Select(dropdown);
        obj.selectByIndex(1);

        //To Search
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();


        //driver.quit();
    }

}
