package pages;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class deposit_pages{
	
	WebDriver driver;

	@FindBy(xpath="//a[@id='deposit-menu-item']")
	static WebElement Link_Deposit; 
	
	@FindBy(xpath="//select[@id='selectedAccount']")
	static WebElement DrpDwn_SelectAcnt; 
	
	@FindBy(xpath="//input[@id='amount']")
	static WebElement Txtbox_DepositAmt; 
	
	@FindBy(css="#right-panel > div.content.mt-3 > div > div > div > div > form > div.card-footer > button.btn.btn-danger.btn-sm")
	static WebElement Btn_Reset; 
	
	@FindBy(css="#right-panel > div.content.mt-3 > div > div > div > div > form > div.card-footer > button.btn.btn-primary.btn-sm")
	static WebElement Btn_Submit; 
	
	@FindBy(xpath="//div[@class='sufee-alert alert with-close alert-danger alert-dismissible fade show']/child::span[2]")
	static WebElement Error_0_Amt; 
	
	public static String title; 
	
	public deposit_pages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickonDeposit()
	{
		Link_Deposit.click();
	}
	
	public void enterDepositDetails(String ddtxt, String amt)
	{
		Select dd = new Select(DrpDwn_SelectAcnt);
		dd.selectByValue(ddtxt);
		Txtbox_DepositAmt.clear();
		Txtbox_DepositAmt.sendKeys(amt);
	}
	
	public void clickonReset() throws InterruptedException {
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		Btn_Reset.click();
	}
	
	public void clickonSubmit() {
		Btn_Submit.click();
	}
	 
	public boolean validate_error()
	{
		return Error_0_Amt.isDisplayed();
	}
	
	public String captureError()
	{
		String errortxt=Error_0_Amt.getText();
		return errortxt;
	}
	
	public boolean validate_dropdown()
	{
		return DrpDwn_SelectAcnt.isDisplayed();
	}
	
	public boolean validate_Reset_Btn()
	{
		return Txtbox_DepositAmt.getText().isEmpty();
	}
}
