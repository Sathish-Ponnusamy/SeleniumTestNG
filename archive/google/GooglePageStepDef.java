package stepdefs;

import google.GooglePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import opencart.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GooglePageStepDef {

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

//    @Given("I am on the google home page to perform the accessibility testing using AXE")
//    public void i_am_on_the_google_home_page_to_perform_the_accessibility_testing_using_axe(){
//        driver.get("www.google.com");
//        GooglePage GooglePage = new GooglePage(driver);
//    }

//    @Given("Enter the keyword for google search")
//    public void enter_the_keyword_for_google_search() {
//        GooglePage.enterSearchKeyword("Algorithm");
//        GooglePage.clickSearchButton();
//    }

//    @When("I click on the search button")
//    public void i_click_on_the_search_button()  {
//        GooglePage.clickSearchResult();
//    }

    @Given("I am on the google home page to perform the accessibility testing using AXE")
    public void i_am_on_the_google_home_page_to_perform_the_accessibility_testing_using_axe() {
        System.out.println("Given Conditions 1");
    }

    @Given("Enter the keyword for google search")
    public void enter_the_keyword_for_google_search() {
        System.out.println("Given Conditions 2");
    }

    @When("I click on the search button")
    public void i_click_on_the_search_button() {
        System.out.println("When Conditions");
    }

}