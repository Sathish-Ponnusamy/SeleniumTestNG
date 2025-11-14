package opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class LoginPage {
    private final Thread thread = new Thread();
    private WebDriver driver;

    //Locators
    private By emailInputLocator = By.id("input-email");
    private By passwordInputLocator = By.id("input-password");
    private By loginButtonLocator = By.xpath("//input[@type='submit']");
    private By forgottenPasswordLinkLocator = By.linkText("Forgotten Password");
//    private By LogoutLinkLocator = By.linkText("Logout");
//*[@id="content"]/div/div[2]/div/form/input
    private By LogoutLinkLocator = By.xpath("//*[@id=\"column-right\"]/div/a[13]");

    //constructor
    public LoginPage(WebDriver driver) throws InterruptedException {
        this.driver=driver;
//        driver.manage().timeouts().pageLoadTimeout(100,SECONDS);
        thread.sleep(5000);
    }

    //Methods
    public void enterEmail(String email){
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
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
        return getForgotPwdPageURL();
    }

}
