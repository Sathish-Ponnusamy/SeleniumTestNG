package dockerDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.RetryAnalyzer;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeDemo {

    public static WebDriver driver;
    @Parameters({"os","Linux"})
    @Test(retryAnalyzer = utils.RetryAnalyzer.class)
    public void TestApp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setPlatform(Platform.LINUX);
        cap.setBrowserName("chrome");
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
        driver.get("https://www.google.com");
        Thread.sleep(5000);
        driver.findElement(By.name("q")).sendKeys("Learn Automation");

        driver.quit();
    }
}
