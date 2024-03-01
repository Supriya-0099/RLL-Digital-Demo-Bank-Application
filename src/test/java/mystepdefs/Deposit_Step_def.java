package mystepdefs;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.apache.logging.log4j.LogManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BaseClass;
import pages.deposit_pages;

import pages.SignInPages;

public class Deposit_Step_def {
	WebDriver driver;
	private static final Logger logger = LogManager.getLogger(Deposit_Step_def.class);
	ExtentSparkReporter spark = new ExtentSparkReporter("target/error.html");
	ExtentTest test;
	ExtentReports extent = new ExtentReports();
	
	SignInPages sip;
	deposit_pages ds;
	
	
	@Given("User is on Deposit page")
	public void user_is_on_deposit_page() {
		System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
		 driver =new  EdgeDriver();
		 driver.get("http://dbankdemo.com/bank/login");
		
		extent.attachReporter(spark);
		test = extent.createTest("MyFirstTest");
	    sip = new SignInPages(driver);
	    ds = new deposit_pages(driver);
	    sip.enterSignInDetails();
	    ds.clickonDeposit();
	    logger.info("user is in Deposit page");
	}

	@When("Validating Reset button")
	public void validating_reset_button() throws InterruptedException  {
	Thread.sleep(3000);
		ds.clickonReset();
		Assert.assertTrue(ds.validate_Reset_Btn(), "Assert failed- Reset button not working");
		logger.info("Validating Reset button");
	}

	@Then("Validating Submit button with no data")
	public void validating_submit_button_with_no_data()  {
		ds.clickonSubmit();
	
		Assert.assertTrue(ds.validate_dropdown(), "Assert failed- Reading empty fields");
		logger.info(" user Validates submit button with no data");
		test.pass(" user Validates submit button with no data");
		
	}

	@Then("Validating Submit button with Amount field as zero")
	public void validating_submit_button_with_amount_field_as_zero() {
		ds.enterDepositDetails("405175", "0");
		ds.clickonSubmit();
		test.pass(" user Validates submit button with amount zero");

		Assert.assertTrue(ds.validate_error(), "Assert failed- Reading amount as 0");
		System.out.println(ds.captureError());
		//logger.error(ds.captureError());
	}

	@Then("Validating succesful deposit transaction with valid credentials")
	public void validating_succesful_deposit_transaction_with_valid_credentials() {
		ds.enterDepositDetails("405175", "100");
		ds.clickonSubmit();
		test.pass("user Validates succesful deposit transaction with valid credentials");
		logger.info(" user Validates succesful deposit transaction with valid credentials");
		extent.flush();
		driver.quit();
	
	}

	
}
