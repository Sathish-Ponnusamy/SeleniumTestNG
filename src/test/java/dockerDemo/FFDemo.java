package dockerDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FFDemo {

    public static WebDriver driver;
    @Parameters({"os","Linux"})
    @Test
    public void TestApp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setPlatform(Platform.LINUX);
        cap.setBrowserName("firefox");
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Learn Automation");
        Thread.sleep(5000);
        driver.quit();
    }
}
