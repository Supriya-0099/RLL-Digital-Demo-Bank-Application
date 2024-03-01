package signin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import listeners.RetryAnalyzer;
import listeners.screenshot;
import pages.signinpage;


public class signin {
	private static final Logger logger = LogManager.getLogger(signin.class);
	 private WebDriver driver;
	    private signinpage signin;
	    static ExtentTest test;
	   
	   private static ExtentReports extent = new ExtentReports();

	    @Before
	    public void setUp() {
	    	ExtentSparkReporter spark = new ExtentSparkReporter("target/signin.html");
	    	extent.attachReporter(spark);
	    	
	    	//
	    	System.setProperty("webdriver.edge.driver", "C:\\Users\\DELL\\Desktop\\rll project\\digitalbank\\Drivers\\msedgedriver.exe");
	        driver = new EdgeDriver();
	        screenshot.setDriver(driver);
	        logger.info("Edgeddriver is initiated");
	        signin = new signinpage(driver);
	    }
	    @BeforeAll
	    public static void before () {
	    	test = extent.createTest("Signin");
	    }
	    @AfterAll
	    public static void after() {
	    	extent.flush();
	    }

	    @After
	    public void tearDown() {
	    	
	    	//driver.quit();
	    }
	    @Given("^the user is on the sign-in page$")
	    public void the_user_is_on_the_sign_in_page() {
	        driver.get("http://dbankdemo.com/bank/login");
	        logger.info("The user is on sign-in page");
	        
	        test.pass("The user is on sign-in page");
	        
	    }
	  

	    @When("^the user enters valid username and password$")
	    public void the_user_enters_valid_username_and_password() throws IOException {
	        FileInputStream file = new FileInputStream("C:/Users/DELL/Desktop/rll project/digitalbank/signin.xlsx");
	           Workbook workbook = new XSSFWorkbook (file);
	           Sheet sheet = workbook.getSheet("Sheet1");
	           
	           Iterator<Row> rowIterator = sheet.iterator();
	           rowIterator.next();
	           logger.info("the user enters valid username and password");
	           while (rowIterator.hasNext ()) {
	        	   driver.get("http://dbankdemo.com/bank/login");
	        	   Row row = rowIterator.next();
	        	   String username = row.getCell(0).getStringCellValue();
	        	   String password = row.getCell(1).getStringCellValue();
	        	   
	        	   signin.enterUsername(username);
	   	           signin.enterPassword(password);
	   	           
	           }
	        
	    }

	    @And("^clicks on the sign-in button$")
	    public void clicks_on_the_sign_in_button() {
	        signin.clickSignInButton();
	        logger.info("the user clicks on the sign-in button");
	    }

	  
	    @Then("the user should be successfully signed in")
	    public void the_user_should_be_successfully_signed_in() {
	        // Write code here that turns the phrase above into concrete actions
	    	logger.info("the user should be successfully signed in");
	        Assert.assertEquals(driver.getTitle(),"Digital Bank");
	        test.pass("The user is signed in successfully");
	       
	        Assert.fail();     
	        }
	    
	    @When("^the user enters an invalid username and valid password$")
	    public void the_user_enters_an_invalid_username_and_valid_password() {
	        signin.enterUsername("invalidUsername");
	        signin.enterPassword("Demo@123");
	        signin.clickSignInButton();
	      
	    }
	    @When("the user enters a valid username and invalid password")
	    public void the_user_enters_a_valid_username_and_invalid_password() {
	        signin.enterUsername("vergil@gmail.com");
	        signin.enterPassword("invalidPassword");
	    }
	    @When("the user leaves the username field empty and enters a valid password")
	    public void the_user_leaves_the_username_field_empty_and_enters_a_valid_password() {
	        signin.enterUsername("");
	        signin.enterPassword("Demo@123");
	    }
	    @Then("the user should not be signed in")
	    public void the_user_should_not_be_signed_in() {
	    	 Assert.assertEquals(driver.getTitle(),"Digital Bank");
	    	 test.pass("The user will not get signed in");
	    }
	    @When("checks the Remember Me option")
	    public void checks_the_remember_me_option() {
	        signin.checkRememberMe();
	    }
	    @When("the user enters a valid username and leaves the password field empty")
	    public void the_user_enters_a_valid_username_and_leaves_the_password_field_empty() {
	    	  signin.enterUsername("vergil@gmail.com");
		        signin.enterPassword("");
	    }
		      
	   

	}