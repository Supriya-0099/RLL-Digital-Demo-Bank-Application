package mystepdefs;


import org.apache.logging.log4j.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.apache.logging.log4j.Logger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

 
public class checking  {
	private static final Logger logger = LogManager.getLogger(checking.class);
 WebDriver driver;
 checkingpages Bankcomponent;
 ExtentTest test;
 private ExtentReports extent = new ExtentReports();

// @Before
// public void setUp() {
//	 ExtentSparkReporter spark = new ExtentSparkReporter("target/checking.html");
//	 extent.attachReporter(spark);
//	 //
//	 System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
//	 driver =new  EdgeDriver();
//	 logger.info("Chromedriver is initiated");
//	  }
// 
 @After
 public void tearDown() {
	 extent.flush();

 }
@Given("I am on the sign in page")
public void i_am_on_the_sign_in_page() throws Throwable{
	System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
	 driver =new  EdgeDriver();
         driver.get("http://dbankdemo.com/bank/login");
		 logger.info("user is in login page");
		 test = extent.createTest("CheckingTRN");
		 test.pass("The user is on sign in page");
		 }

@When("I enter Username and password")	
public void i_enter_username_and_password() throws Throwable{
	Bankcomponent = PageFactory.initElements(driver,checkingpages.class);
	 Bankcomponent.enterUsername("hari@gmail.com");
	 Bankcomponent.enterPassword("Harika@2309");
	 logger.info("user enter Username and password");
}

@Then("I click on sign in button")
public void i_click_on_sign_in_button() {
	Bankcomponent.clickSignInButton();
	logger.info("user clicks Signin button");
	test.pass("the user clicked sign in button" );
}

 @When("I click on Checking")
public void i_click_on_checking() throws Throwable {
    Bankcomponent.clickTheChecking();
    logger.info("user click the checking");
}

 @When("Select View Checking")
public void select_view_checking() throws Throwable {
    Bankcomponent.clickTheViewChecking();
    logger.info("user clicks view checking");
}
 
@Then("Validate Search box with valid TRN")
public void validate_search_box_with_valid_trn() throws Throwable {
  Bankcomponent.searchTransactionDetails("845590969");
  driver.findElement(By.xpath("//*[@id=\"transactionTable_filter\"]/label/input")).clear();
  logger.info("user gives valid TRN in search box");
  test.pass("the user validates the search box with valid TRN");
 }
 
@And("Validate Search box with invalid TRN")
public void validate_search_box_with_invalid_trn()  throws Throwable {
  Bankcomponent.searchTransactionDetails("845590970");
  driver.findElement(By.xpath("//*[@id=\"transactionTable_filter\"]/label/input")).clear();	
  logger.info("user gives invalid TRN in search box");
}


@And("Validate Search box with empty TRN")
public void validate_search_box_with_empty_trn() throws Throwable {
	Bankcomponent.searchTransactionDetails("");
	logger.info("user gives empty TRN in search box");
	test.pass("the user validates thesearch boxwith empty TRN");
}

@And("Validate Search box with TRN search with spaces")
public void validate_search_box_with_trn_search_with_spaces() throws Throwable{
	Bankcomponent.searchTransactionDetails("8 45590969");
	logger.info("user gives TRN with spaces in search box");
	driver.quit();
}
}
