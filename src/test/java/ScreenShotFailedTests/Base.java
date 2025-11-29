package ScreenShotFailedTests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Base {
    public static WebDriver driver;
    public static void initialization(){
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
    }
    public static void failed(String testMethodName) throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        String screenshotName = testMethodName + "_" + timestamp + ".png";
        // Using relative path from the project root
        FileUtils.copyFile(scrFile, new File("target/screenshot/" + screenshotName));
    }

}
