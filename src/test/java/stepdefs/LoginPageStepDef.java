package stepdefs;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.deque.html.axecore.results.Node;
import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import opencart.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LoginPageStepDef {
    private WebDriver driver;
    private LoginPage loginPage;

    AxeBuilder axeBuilder = new AxeBuilder();

    //    ExtentReports reports = new ExtentReports();
//
//    // fluent
//    ExtentReports extent = new ExtentReports();
//    ExtentTest test = extent.createTest("MyFirstTest").createNode("Node").pass("Pass");
//    ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");

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
    public void i_have_entered_a_valid_username_and_password() throws InterruptedException, IOException {

        // Accessibility testing using AXE Libraries

        Results axeResults = axeBuilder.analyze(driver);
        List<Rule> violations = axeResults.getViolations();
//        System.out.println("getErrorMessage:" +axeResults.getErrorMessage());
//        System.out.println("getViolations: " +axeResults.getViolations());
//        System.out.println("violationFree: "+axeResults.violationFree());
//        Results results = new AXE.Builder(driver, axeScript).analyze();
//        for (Rule violation : violations) {
//            String impact = violation.getImpact();           // e.g. "critical"
//            String issue = violation.getDescription();        // e.g. "Ensures buttons have accessible names"
//
//            System.out.println("Impact: " + impact);
//            System.out.println("Issue: " + issue);
//            System.out.println("-----------");
//        }
//
//        for (Rule violation : violations) {
//            String impact = violation.getImpact();            // "moderate"
//            String issue = violation.getHelp();                // "Buttons must have discernible text"
//
//            System.out.println("Impact: " + impact);
//            System.out.println("Issue: " + issue);
//            System.out.println();
//        }
//
//        StringBuilder report = new StringBuilder();
//
//        for (Rule violation : violations) {
//            report.append("Impact: ").append(violation.getImpact()).append("\n")
//                    .append("Issue: ").append(violation.getDescription()).append("\n")
//                    .append("Help: ").append(violation.getHelp()).append("\n\n");
//        }
//
//        System.out.println(report.toString());
//
//        Files.write(Paths.get("axe-report.txt"), report.toString().getBytes());
//
//        ArrayNode jsonArray = new ObjectMapper().createArrayNode();
//
//        for (Rule v : violations) {
//            ObjectNode item = jsonArray.addObject();
//            item.put("impact", v.getImpact());
//            item.put("issue", v.getDescription());
//            item.put("Help", v.getHelp());
//            item.put("ID", v.getId());
//
//            ArrayNode nodes = item.putArray("nodes");
//
//            for (Node n : v.getNodes()) {
//                ObjectNode nodeObj = nodes.addObject();
//                nodeObj.put("html", n.getHtml());
//                nodeObj.put("target", n.getTarget().toString());
//            }
//
//            ArrayNode tags = item.putArray("Tags");
//
//            for (Node n : v.getNodes()) {
//                ObjectNode nodeObj = nodes.addObject();
//                nodeObj.put("html", n.getHtml());
//                nodeObj.put("target", n.getTarget().toString());
//            }
//            item.put("Tags", (BigDecimal) v.getTags());
//            ArrayNode tagArray = item.putArray("Tags");
//            v.getTags().forEach(tagArray::add);
//
//        }
//
//        System.out.println(jsonArray.toPrettyString());
//        Files.write(Paths.get("axe-report.json"), report.toString().getBytes());

        ObjectMapper mapper = new ObjectMapper();
        ArrayNode jsonArray = mapper.createArrayNode();

        for (Rule v : violations) {
            ObjectNode item = jsonArray.addObject();

            // Basic fields
            item.put("impact", v.getImpact());
            item.put("issue", v.getDescription());
            item.put("help", v.getHelp());
            item.put("id", v.getId());

            // Nodes (html + target)
            ArrayNode nodeArray = item.putArray("nodes");
            for (Node n : v.getNodes()) {
                ObjectNode nodeObj = nodeArray.addObject();
                nodeObj.put("html", n.getHtml());
                nodeObj.put("target", n.getTarget().toString());
            }

            // Tags
            ArrayNode tagArray = item.putArray("tags");
            v.getTags().forEach(tagArray::add);
        }

            // Write JSON to file
            String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray);
            Files.write(Paths.get("target/axe-report.json"), prettyJson.getBytes());

            System.out.println("axe-report.json file generated successfully!");

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
