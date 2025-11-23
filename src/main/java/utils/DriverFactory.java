package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
public class DriverFactory {
    public static WebDriver getDriver() {
        String gridUrl = System.getProperty("selenium.grid.url");

        if (gridUrl != null && !gridUrl.isEmpty()) {
            System.out.println("Running tests remotely on Selenium Grid: " + gridUrl);
            try {
                // Set the desired browser capability (e.g., Chrome)
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setBrowserName("chrome");

                // Connect to the Grid Hub using the URL from the CI environment
                return new RemoteWebDriver(new URL(gridUrl), caps);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to connect to Remote WebDriver.", e);
            }
        } else {
            // Default to local execution if the property is not set
            System.out.println("Running tests locally.");
            return new ChromeDriver();
        }
    }
}
