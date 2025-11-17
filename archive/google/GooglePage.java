package google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static opencart.LoginPage.Timeouts;

public class GooglePage {
    private final Thread thread = new Thread();
    private static WebDriver driver;

    private static By SearchTextFieldLocator = By.name("q");
    private static By SearchButtonLocator = By.xpath("//input[@type='submit']");
    private static By SearchresultLocator = By.xpath("//div[@id='search']");

    public GooglePage(WebDriver driver)
    {
        this.driver= GooglePage.driver;
        GooglePage.driver.manage().window().maximize();
        Timeouts();
    }

    public static void enterSearchKeyword(String srchKeywrd){
        Timeouts();
//        WaitElement((WebElement) emailInputLocator);
        WebElement srchInput = driver.findElement(SearchTextFieldLocator);
        srchInput.sendKeys(srchKeywrd);
    }

    public static void clickSearchButton(){
        WebElement srchBtn = driver.findElement(SearchButtonLocator);
        srchBtn.click();
    }

    public static void clickSearchResult(){
        WebElement srchresult = driver.findElement(SearchresultLocator);
        srchresult.isDisplayed();
    }



}
