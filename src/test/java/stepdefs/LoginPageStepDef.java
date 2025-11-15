package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import opencart.Base;
import opencart.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoginPageStepDef {
    private WebDriver driver;
    private LoginPage loginPage;


    @Before
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
    }

    @After
    public void teardown(){
        if(driver!=null){
            driver.quit();
        }
    }


    @Given("I am on the OpenCart Login page")
    public void i_am_on_the_open_cart_login_page() throws InterruptedException {
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        loginPage = new LoginPage(driver);
    }

    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() throws InterruptedException {
        loginPage.enterEmail("Test@email.com");
        loginPage.enterPassword("test1234");
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button(){
        loginPage.clickLoginButton();
    }

    @Then ("I should be able to login successfully")
    public void i_should_be_able_to_login_successfully(){
        Assert.assertEquals(loginPage.checkLogoutLink(),true);
    }

    @Given ("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_username_and_password(String username, String password) {
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }


    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String string) {
        Assert.assertEquals(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(),true);
    }

    @When ("I click on the Forgotten Password link")
    public void i_click_on_the_Forgotten_Password_link(){
loginPage.clickForgottenPasswordLink();
    }

    @When("I click on the {string} link")
    public void i_click_on_the_link(String string) {
        loginPage.clickForgottenPasswordLink();
    }


    @Then("I should be redirected to the password reset page")
    public void i_should_be_redirected_to_the_password_reset_page(){
    Assert.assertEquals(loginPage.getForgotPwdPageURL().contains("account/forgotten"),true);
    }

}
