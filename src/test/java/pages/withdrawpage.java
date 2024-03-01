package pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class withdrawpage {
	
	 WebDriver driver;
	 
	 
		@FindBy(xpath="//input[@id='username']")
		private WebElement Input;

		@FindBy(xpath="//input[@id='password']")
		private WebElement passwordInput;

		@FindBy(xpath="//button[@id='submit']")
		private WebElement loginButton;
		
		@FindBy(id="withdraw-menu-item")
		private WebElement withdrawlink;
		
		@FindBy(id="selectedAccount")
		private WebElement selectaccount;
		
		@FindBy(xpath="//option[contains(text(),'Harini (Savings)')]")
		private WebElement selectbankaccount;
		
		@FindBy(xpath="//input[@id='amount']")
		private WebElement amountinput;
		
		@FindBy(xpath="(//button[@type='submit'])[3]")
		private WebElement submit;
		
		@FindBy(xpath="(//button[@type='reset'])[1]")
		private WebElement Btn_Reset;
		
		@FindBy(xpath="//span[contains(text(),'The withdraw amount ($0.00) must be greater than $')]")
		private WebElement Error_zero_Amt;
		
		
		@FindBy(xpath="//span[contains(text(),'The withdraw amount ($10000000000000000.00) is grea')]")
		private WebElement Exceed_amount_balance;
		
		
		
		

		
		
		
		
		
		
		
		
		public withdrawpage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
//		public void navigateToURL(String url) {
//			driver.get(url);
//		}
		
		
		public void performLogin(String input, String password) {
			Input.sendKeys(input);
			passwordInput.sendKeys(password);
			loginButton.click();
		}
		public void clickonWithdraw() {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			withdrawlink.click();
		}
		public void clickselectaccount()  {
	
			selectaccount.click();
			selectbankaccount.click();
		}
			
		public void withdrawcheck(String amount) {
			
				amountinput.sendKeys(amount);
				submit.click();
				
			}
		
		public void clickonReset() {
			Btn_Reset.click();
		}
		public void invalid_input_Zero(String amount_0) {
			amountinput.sendKeys(amount_0);
			submit.click();
			amountinput.clear();
			
		}
		
		public void exceedbankbalance(String amount_exceed) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			amountinput.sendKeys(amount_exceed);
			submit.click();
			amountinput.clear();
		}
		
		
		
	  
	    
	    public String captureError_Zero_text()
		{
			String errortxt=Error_zero_Amt.getText();
			return errortxt;
		}
	    public String captureError_maximum_amount_Text()
	   	{
	   		String errortxt=Exceed_amount_balance.getText();
	   		return errortxt;
	   	}
	} 
	
	 
	 
	 
	 
	 