package opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.sql.DriverManager.getDriver;
import static java.util.concurrent.TimeUnit.SECONDS;

public class LoginPage {
    private final Thread thread = new Thread();
    private static WebDriver driver;

    //Locators
    private By emailInputLocator = By.id("input-email");
    private By passwordInputLocator = By.id("input-password");
    private By loginButtonLocator = By.xpath("//input[@type='submit']");
    private By forgottenPasswordLinkLocator = By.linkText("Forgotten Password");
//    private By LogoutLinkLocator = By.linkText("Logout");
//*[@id="content"]/div/div[2]/div/form/input
//    private By LogoutLinkLocator = By.xpath("//*[@id=\"column-right\"]/div/a[13]");
    private By LogoutLinkLocator = By.cssSelector("#column-right > div > a:nth-child(13)");

    //constructor
    public LoginPage(WebDriver driver) throws InterruptedException {
        this.driver=driver;
        driver.manage().window().maximize();
        Timeouts();
    }


    public static void Timeouts() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
    }

    public static void WaitElement(WebElement webElement) {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement element=wait.until(ExpectedConditions.visibilityOf(webElement));
    }

//    private static Object getDriver() {
//        return null;
//    }

    //Methods
    public void enterEmail(String email){
//        Timeouts();
//        WaitElement((WebElement) emailInputLocator);
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
//        WaitElement((WebElement) passwordInputLocator);
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    public void clickForgottenPasswordLink(){
        WebElement forgottenPasswordLink = driver.findElement(forgottenPasswordLinkLocator);
        forgottenPasswordLink.click();
    }

    public boolean checkForgotPwdLink(){
        return driver.findElement(forgottenPasswordLinkLocator).isDisplayed();
    }

    public boolean checkLogoutLink(){
        return driver.findElement(LogoutLinkLocator).isDisplayed();
    }

    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public String getForgotPwdPageURL(){
        String forgotPwdPageUrl = driver.getCurrentUrl();
        return forgotPwdPageUrl;
    }

}
