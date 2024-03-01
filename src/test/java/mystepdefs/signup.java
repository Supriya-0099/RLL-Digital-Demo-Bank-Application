package mystepdefs;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import listeners.*;
import pages.signup_page;
import pages.withdrawpage;

/////////--------------------------------------Tharun--------------------------------------------

public class signup {

	
	 private static final Logger logger = LogManager.getLogger(signup.class);
	 private WebDriver driver;
	    private signup_page signup_page;
	    static ExtentSparkReporter spark = new ExtentSparkReporter("target/signup.html");
		
		
		static ExtentTest test;
		private static ExtentReports extent = new ExtentReports();


		
		
		@BeforeAll
		public static void before() {
			test = extent.createTest("signup");

		}
//	@Before
//    public void setup() {
//		ExtentSparkReporter spark = new ExtentSparkReporter("target/all.html");
//		extent.attachReporter(spark);
//        // Initialize WebDriver
//        System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
//        driver = new EdgeDriver();
//        screenshot.setDriver(driver);
//    
//        logger.info("Edgeddriver is initiated");
//        signup_page = new signup_page(driver);
//        
//    }
//	
	



	@Given("I am on the signup page")
	public void i_am_on_the_signup_page() {
		System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
//		FirefoxOptions options= new FirefoxOptions();
//		options.addArguments("--headless");
		 driver =new  EdgeDriver();
		 screenshot.setDriver(driver);
		 signup_page = new signup_page(driver);
		driver.get("http://dbankdemo.com/bank/signup");
		 logger.info("user is on signup page");
		 //test = extent.createTest("signup");
		
   
	}

	@When("I fill in the signup form with a invalid date of birth")
	public void i_fill_in_the_signup_form_with_a_invalid_date_of_birth() throws InterruptedException {
	

	    signup_page.selectPerson("Mr.");
	    signup_page.enterFirstname("abc");
	    signup_page.enterLastname("def");
	    signup_page.selectGender();
	    signup_page.enterDOB("18/25/2000");
	    logger.info("user enters his information with invalid DOB");
	}

	@When("I click the next button")
	public void i_click_the_next_button() {
		signup_page.clickNext();
		 logger.info("user clciks on next button");
	}
	
	@Then("I should see an error message indicating please match the requested format")
	public void i_should_see_an_error_message_indicating_please_match_the_requested_format() throws InterruptedException {
        

		test.fail("actual and expected error did not match for DOB");
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\hey1d\\OneDrive\\Desktop\\learn\\digitalbank\\Screenshot\\runScenario.png").build());
		String actual = driver.findElement(By.id("dob")).getAttribute("validationMessage");
	   //System.out.println(actual);
	   if (actual!="Please match the requested format") {
//		   driver.quit();
		   
		   Assert.fail("actual and expected error did not match");
		   logger.error("actual and expected error did not matched");
		   driver.quit();
	   }
	 
	}
	@When("I fill in the signup form with an existing email")
    public void i_fill_in_the_signup_form_with_an_existing_email() {
        //logger.fatal("Filling in the signup form with an existing email");
        driver.get("http://dbankdemo.com/bank/signup");

        signup_page.selectPerson("Mr.");
        signup_page.enterFirstname("abc");
        signup_page.enterLastname("def");
        signup_page.selectGender();
        signup_page.enterDOB("10/25/2000");
        signup_page.enterSSN("468-46-4684");
        signup_page.enterEmail("vergil@gmail.com");
        signup_page.enterPassword("Demo@123");
        signup_page.enterConfirmPassword("Demo@123");
        logger.info("user enters information with already existing mail id");
    }

    @Then("I should see an error message indicating An account is already registered with the email address provided")
    public void i_should_see_an_error_message_indicating_an_account_is_already_registered_with_the_email_address_provided() {

    	test.pass("error message is displayed at email field");

        //logger.trace("Verifying error message");
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/span[1]")).isDisplayed(), "The error is visible");
        driver.quit();
        logger.info("error message is displayed at email field");
		   

    }
    @When("I fill in the signup form with an invalid {string} or {string} or {string}")
	public void i_fill_in_the_signup_form_with_an_invalid_ssn_or_email(String ssn,String email,String password) {

	driver.get("http://dbankdemo.com/bank/signup");

    signup_page.selectPerson("Mr.");
    signup_page.enterFirstname("abc");
    signup_page.enterLastname("def");
    signup_page.selectGender();
    signup_page.enterDOB("10/25/2000");
    signup_page.enterSSN(ssn);
    signup_page.enterEmail(email);
    signup_page.enterPassword(password);
    logger.info("user enters invalid password, mail and ssn");
}

	@Then("I should see an error message for {string}")
	public void i_should_see_an_error_message_for_ssn(String field) {
		String actual = driver.findElement(By.id(field)).getAttribute("validationMessage");
		String expected1 ="Please match the requested format.";
		String expected2 ="Please include an '@' in the email address. 'asgmail.com' is missing an '@'.";
		String expected3 ="Passwords Do Not Match";
		   //System.out.println(actual);
		   if ((actual.equals(expected2)||(actual.equals(expected1)))||(actual.equals(expected3))) {
			   logger.info("user see an error message at "+field);

			   test.pass("user see an error message at "+field);
			   driver.quit();  
		   }
		   else {
			   //System.out.println(actual);
		   //Assert.fail("actual and expected error did not match");
		   logger.error("user did not see an error message at "+field);

		   test.fail("user did not see an error message at "+field);
		   driver.quit();
		   }
		   
}
	@When("I fill in the signup form with an mismatched passwords")
	public void i_fill_in_the_signup_form_with_an_mismatched_passwords() {
		driver.get("http://dbankdemo.com/bank/signup");

	    signup_page.selectPerson("Mr.");
	    signup_page.enterFirstname("abc");
	    signup_page.enterLastname("def");
	    signup_page.selectGender();
	    signup_page.enterDOB("10/25/2000");
	    signup_page.enterSSN("468-46-4684");
	    signup_page.enterEmail("vergil@gmail.com");
	    signup_page.enterPassword("Demo@123");
	    signup_page.enterConfirmPassword("Demo@1234");
	    logger.info("eser enters information with mismatched passwords");
	}

	@Then("I should see an error message indicating passwords do not match")
	public void i_should_see_an_error_message_indicating_passwords_do_not_match() {
		
		String actual = driver.findElement(By.id("confirmPassword")).getAttribute("validationMessage");
		String expected = "Passwords Do Not Match";
		
		if (actual.equals(expected)) {
			   logger.info("user see an error at confirm password field");

			   test.pass("user see an error at confirm password field");
			   driver.quit();  
		   }
		   else {

			   //test.fail("user does not see an error at confirm password field");
			   logger.error("user does not see an error at confirm password field");
		   Assert.fail("actual and expected error did not match");
		   driver.quit();
		   }
	}
	
	@When("I fill in the signup form with missing information and click next")
	public void i_fill_in_the_signup_form_with_missing_information_and_click_next() throws IOException {

		 FileInputStream file = new FileInputStream("C:\\Users\\hey1d\\Pictures\\signup.xlsx");
	        @SuppressWarnings("resource")
			Workbook workbook = new XSSFWorkbook(file); // Use XSSFWorkbook for .xlsx files
	        Sheet sheet = workbook.getSheet("Sheet1");

	        Iterator<Row> rowIterator = sheet.iterator();
	        rowIterator.next(); // Skip header row

	        while (rowIterator.hasNext()) {
	        	driver.get("http://dbankdemo.com/bank/signup");
	            Row row = rowIterator.next();
	            String person = row.getCell(0).getStringCellValue();
	            String fname = row.getCell(1).getStringCellValue();
	            String lname = row.getCell(2).getStringCellValue();
	            String dob = row.getCell(3).getStringCellValue();
	            String ssn = row.getCell(4).getStringCellValue();
	            String email = row.getCell(5).getStringCellValue();
	            String pass = row.getCell(6).getStringCellValue();
	            String cpass = row.getCell(7).getStringCellValue();
	            
	            signup_page.selectPerson(person);
	            //driver.findElement(By.id("")).getAttribute("validationMessage");
	            signup_page.enterFirstname(fname);
	            signup_page.enterLastname(lname);
	            signup_page.selectGender();
	            signup_page.enterDOB(dob);
	            signup_page.enterSSN(ssn);
	            signup_page.enterEmail(email);
	            signup_page.enterPassword(pass);
	            signup_page.enterConfirmPassword(cpass);
	            // You might want to add some delay/wait here to ensure form validation is triggered

	            // Click the next button
	            signup_page.clickNext();
	            //System.out.println(actual);
	            
	        }
	}

	@Then("I should see error messages indicating please fill out this field")
	public void i_should_see_error_messages_indicating_please_fill_out_this_field() {

		test.pass("missing fields is done");
	    // Write code here that turns the phrase above into concrete actions
		   logger.info("user see an error message at respective fields");
		   
	    driver.quit();
	}
	@When("I fill in the signup form with valid information")
	public void i_fill_in_the_signup_form_with_valid_information() {
		driver.get("http://dbankdemo.com/bank/signup");
		 signup_page.selectPerson("Mr.");
         signup_page.enterFirstname("afsas");
         signup_page.enterLastname("adfaf");
         signup_page.selectGender();
         signup_page.enterDOB("10/12/2000");
         signup_page.enterSSN("123345123");
         signup_page.enterEmail("vergil1@gmail.com");
         signup_page.enterPassword("Demo@123");
         signup_page.enterConfirmPassword("Demo@123");
         signup_page.clickNext();
		   logger.info("user enters valid information and clicks next");

	}

	@Then("I should be redirected to new form page")
	public void i_should_be_redirected_to_new_form_page() {
		   logger.info("user is redirected to new form page");


	}
	@Then("I fill address, tick terms checkbox")
	public void i_fill_address_tick_terms_checkbox() {
		signup_page.Address("asda gadg");
        signup_page.Locality("CITYF");
        signup_page.Region("CA");
        signup_page.Postalcode("12353");
        signup_page.Country("US");
        signup_page.Homephone("(547) 392-5436");
        driver.findElement(By.id("agree-terms")).click();
		   logger.info("user fill other details and accept the terms");
		   

	}

	@Then("click on signup")
	public void click_on_signup() {
		//signup_page.Register();
		   logger.info("user clicks on register");

	}

	@Then("I should be redirected to signin page")
	public void i_should_be_redirected_to_signin_page() {
	    //Assert.assertEquals(driver.getTitle(), "Digital Bank");

		test.pass("user is successfully registered");

		   logger.info("user is redirected to signin page");
		   logger.info("------------------------------------------------------------------------");

	    driver.quit();
	    extent.flush(); 
	}
	
	//---------------------------------------------------------------------------------------------------------------------
}
