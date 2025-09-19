import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class Crossbrowser {
    @Test
    public void homapege() throws URISyntaxException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        WebDriver driver = new RemoteWebDriver(new URI("http://10.247.212.36:4444").toURL(), caps);
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        driver.close();
    }

}
