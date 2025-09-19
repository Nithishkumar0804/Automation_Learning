import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class updatedDropdown {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	      /*
	      driver.findElement(By.id("divpaxinfo")).click();
	      Thread.sleep(100);
	      for(int i=0;i<3;i++) {
	    	  driver.findElement(By.id("hrefIncAdt")).click();
	      }
	      driver.findElement(By.id("btnclosepaxoption")).click();
	      */
        Assert.assertFalse(driver.findElement(By.cssSelector("input[name*=SeniorCitizenDiscount]")).isSelected());
        driver.findElement(By.cssSelector("input[name*=SeniorCitizenDiscount]")).click();
        System.out.println(driver.findElements(By.cssSelector("input[type=checkbox]")).size());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[name*=SeniorCitizenDiscount]")).isSelected());

        //System.out.println(driver.findElement(By.cssSelector("#ctl00_mainContent_view_date2")).isEnabled());
        //driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
        //System.out.println(driver.findElement(By.cssSelector("#ctl00_mainContent_view_date2")).isEnabled());

        driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
        if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")) {
            System.out.println("Enable");
        } else {
            System.out.println("Disabled");
        }


    }

}
