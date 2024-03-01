package mystepdefs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.Savings;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;
public class savings_stepdef {
    WebDriver driver;
    Savings bankComponent;
    
    private static final Logger logger = LogManager.getLogger(savings_stepdef.class);
    ExtentSparkReporter spark = new ExtentSparkReporter("target/savings.html");
    
    static ExtentTest test;
    static ExtentReports extent = new ExtentReports();
    
    @BeforeAll
    public static void before() {
   	  test = extent.createTest("SavingsAccount");
    }
    @Before
    public void bef() {
        extent.attachReporter(spark);

    }
    
    @Given("I am on the sign in page-")
    public void i_am_on_the_sign_in_page() {
    	driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://dbankdemo.com/bank/login");
        logger.info("Chromedriver is initiated");
    }

    @When("I enter Username and password-")
    public void i_enter_username_and_password() {
        bankComponent = PageFactory.initElements(driver, Savings.class);
        bankComponent.enterUsername("vergil@gmail.com");
        bankComponent.enterPassword("Demo@123");
        logger.info("User is entering to user name and password");
    }

    @Then("I click on sign in button-")
    public void i_click_on_sign_in_button() {
        bankComponent.clickSignInButton();
        logger.info("User is entering to signin button");
    }

    @When("I click on Savings")
    public void i_click_on_savings() {
        // Write code here that turns the phrase above into concrete actions
    
    	bankComponent.clickTheSavings();
    	logger.info("User is entering to Savings");
    }


    @When("Select View Savings")
    public void select_view_Savings() {
        bankComponent.clickTheViewSavings();
        logger.info("User is entering to View Savings");
        
    }

    @Then("Validate Search box with Amount")
    public void validate_search_box_with_amount() throws InterruptedException {
        // Implement validation code for Search box with Amount
    	
    	bankComponent.searchTransactionDetails("50000");
    	driver.findElement(By.xpath("//*[@id=\"transactionTable_filter\"]/label/input")).clear();
    	 logger.info("User is entering to Search box with Amount");
    	 test.pass("Validate Search box with Amount");
    }
    @Then("Validate Search box with negative TRN")
    public void validate_search_box_with_negative_trn() throws InterruptedException {
        // Implement validation code for Search box with negative TRN
    	bankComponent.searchTransactionDetails("-845590980");
    	 driver.findElement(By.xpath("//*[@id=\"transactionTable_filter\"]/label/input")).clear();
    	 logger.info("User is entering to Validate Search box with negative TRN");

    	 test.pass("Validate sarch box with negative TRN");
    }


    @Then("Validate Search box with category")
public void validate_search_box_with_category() throws InterruptedException {
        // Implement validation code for Search box with category
    	bankComponent.searchTransactionDetails("Income");
    	driver.findElement(By.xpath("//*[@id=\"transactionTable_filter\"]/label/input")).clear();
    	logger.info("User is entering to Validate Search box with category");

    	 test.pass("Validate Search box with category");
    }

    @Then("Validate Search box with date")
    public void validate_search_box_with_date() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
   
    	bankComponent.searchTransactionDetails("2024-02-23 05:13 ");
    	logger.info("User is entering to Validate Search box with date");

    	 test.pass("Validate Search box with date");
    	 extent.flush();
    	 driver.quit();
    }
}