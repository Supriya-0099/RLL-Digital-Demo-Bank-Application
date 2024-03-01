package mystepdefs;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.*;


public class transfer {

	WebDriver driver;
	transferpages tba;
	private static final Logger logger = LogManager.getLogger(transfer.class);
	
	ExtentTest test;
    ExtentReports extent = new ExtentReports();
    
//    @Before
//    public void setUp() {
//    	ExtentSparkReporter spark = new ExtentSparkReporter("target/transfer.html");
//    	extent.attachReporter(spark);
//    	
//    	//System.setProperty("webdriver.chrome.driver", "drivers/msedgedriver.exe");
//        driver = new EdgeDriver();  
//        driver.manage().window().maximize();
//        
//        logger.info("chromedriver path is initiated & in signin page");
//    	
//    }
//    
//    @After
//    public void tearDown() {
//    	extent.flush();
//    	driver.quit();
//    }
	
	@Given("User is on Transfer between Accounts page")

	public void user_is_on_transfer_between_accounts_page() {
		System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
		 driver =new  EdgeDriver();

    	driver.get("http://dbankdemo.com/bank/login");
		
    	tba = PageFactory.initElements(driver,transferpages.class);
    	tba.enterUsername("kavya@gmail.com");
    	tba.enterPassword("Deepu@123");
    	tba.clickSignInButton();
	
    	test = extent.createTest("transfer");
        test.pass("The user is on transfer b/w accounts page");
        
	    tba.clickonTransferBetweenAcnts();
	    
	    logger.info("user is on transfer page");
	    
	}

	@When("Validating Reset button of Transfer between Accounts page")
	public void validating_reset_button_of_transfer_between_accounts_page() throws InterruptedException {
		Thread.sleep(200);
		tba.enterAcntsDetails(1, 2, "10");
		tba.clickonReset();
		Assert.assertTrue(tba.validate_Reset_Btn(), "Assert failed- Reset button not working");
		logger.info("validating reset button of transfer b/w accounts page");
	}

	@Then("Validating Submit button without any data")
	public void validating_submit_button_without_any_data() {
		tba.clickonSubmit();
		Assert.assertTrue(tba.validate_fromAccount_DrpDwn(), "Assert failed- Reading empty fields");
		logger.info("validating submit button without data");
		test.pass("The user validating submit button without data");
	}

	@Then("Validating Submit button with amount as zero")
	public void validating_submit_button_with_amount_as_zero() throws InterruptedException {
		Thread.sleep(2000);
		tba.enterAcntsDetails(1, 2, "0");
		tba.clickonSubmit();
		System.out.println(tba.captureError());
		Assert.assertTrue(tba.validate_fromAccount_DrpDwn(), "Assert failed- Accepting amount as 0");
		logger.info("validating submit button with 0 amount");
		test.pass("validating submit button with 0 amount");
		
	}

	@Then("Validating succesful Transfer between Accounts transaction with valid credentials")
	public void validating_succesful_transfer_between_accounts_transaction_with_valid_credentials() throws InterruptedException {
		Thread.sleep(2000);
		tba.enterAcntsDetails(2, 1, "20");
		try {
		tba.clickonSubmit();
		}
		catch(Exception e) {
		Assert.assertFalse(tba.validate_fromAccount_DrpDwn(), "Assert failed- Unsuccessful Transaction");
		}
		logger.info("validation successfull");
		test.pass("validating successful transfer b/w accounts");
		driver.quit();
	}
	
}
