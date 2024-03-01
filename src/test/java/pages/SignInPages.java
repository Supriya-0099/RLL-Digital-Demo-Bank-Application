package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPages{

	WebDriver driver;
	
	@FindBy(xpath="//input[@id='username']")
	static WebElement TxtBox_Username;
	
	@FindBy(xpath="//input[@id='password']")
	static WebElement TxtBox_Password;
	
	@FindBy(xpath="//button[@id='submit']")
	static WebElement Btn_SignIn;
	
	@FindBy(xpath="//img[@class='user-avatar rounded-circle']")
	static WebElement Profile_Icon;
	
	@FindBy(xpath="(//a[@class='nav-link'])[5]")
	static WebElement Logout;
	
	public SignInPages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterSignInDetails()
	{
		TxtBox_Username.sendKeys("vergil@gmail.com");
		TxtBox_Password.sendKeys("Demo@123");
		Btn_SignIn.click();
	}
	
	public void enterMultipleSignIn(String u, String p)
	{
		TxtBox_Username.sendKeys(u);
		TxtBox_Password.sendKeys(p);
		Btn_SignIn.click();
	}
	
	public void logout()
	{
		Profile_Icon.click();
		Logout.click();
	}
	
	
}
