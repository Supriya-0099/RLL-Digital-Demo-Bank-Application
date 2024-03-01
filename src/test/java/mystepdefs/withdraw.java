package mystepdefs;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

//import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.checkingpages;
import pages.withdrawpage;



public class withdraw {

    private static final Logger logger = LogManager.getLogger(withdraw.class);
    private WebDriver driver;
    public withdrawpage Withdraw_Method;
    


    public withdraw() {
        //driver=new EdgeDriver();
    	//Withdraw_Method = new withdrawpage(driver);
        SoftAssert s = new SoftAssert();
    }


		
		
	
	@Given("User navigates to the URL")
	
	public void user_navigates_to_the_url() {
		System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
		 driver =new  EdgeDriver();
		 Withdraw_Method = PageFactory.initElements(driver,withdrawpage.class);
		 
		logger.info("User navigates to the URL");
		driver.get("http://dbankdemo.com/bank/login"); //url 
		
	}

	@When("User performs the login process")
	public void user_performs_the_login_process() {   //id , pass
		logger.info("User performs the login process");

			Withdraw_Method.performLogin("hariniseeta@gmail.com", "Seeta@2034");
      
	}
	    

	@Then("User clicks on withdraw")
	public void click_Withdraw() {
		logger.info("User clicks on withdraw link");
			Withdraw_Method.clickonWithdraw();
       	
		
	}
	
	@Then("check RestButton")
	public void select_Reset_Button() {
		logger.info("check ResetButton");
			Withdraw_Method.clickselectaccount();
			Withdraw_Method.clickonReset();
	
		
		
	}
		
	@Then("select DropDown button and test")
	public void select_DropDown_button()  {
		logger.info("select DropDown button and test");
		
			Withdraw_Method.clickselectaccount();
		
	}
	
	@Then("check withdraw with no value in input")
	public void empty_Input_amount()  {
		logger.info("check withdraw with no value in input");

			Withdraw_Method.clickselectaccount();
			Withdraw_Method.withdrawcheck("");

        
	}
	@Then("check withdraw with zero amount")
	public void invalid_input_amount()  {
		logger.info("check withdraw with invalid amount");
		Withdraw_Method.clickselectaccount();
		Withdraw_Method.invalid_input_Zero("0");
		
		
		System.out.println(Withdraw_Method.captureError_Zero_text());
		logger.error(Withdraw_Method.captureError_Zero_text());
		
		
	}
	
	
	
	@Then("check withdraw with exceed bank amount")
	public void Exceed_bank_balance()  {
		logger.info("check withdraw with exceed bank amount");
		
			Withdraw_Method.clickselectaccount();
			Withdraw_Method.exceedbankbalance("10000000000000000");
			
			System.out.println(Withdraw_Method.captureError_maximum_amount_Text());
			
			logger.error(Withdraw_Method.captureError_maximum_amount_Text());
			
   
		
	}
	
	
	
	@Then("give valid amount and deposite")
	public void Withdraw_Amount_from_Bank_account() throws InterruptedException {
		logger.info("give valid amount and deposite");
			Withdraw_Method.clickselectaccount();
			Withdraw_Method.withdrawcheck("120");
      

        
		driver.quit();
}
	
}



