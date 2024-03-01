package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class transferpages {

	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"username\"]")
    WebElement UserNameInput;
    
    @FindBy(xpath="//*[@id=\"password\"]")
    static WebElement PasswordInput;
    
    @FindBy(xpath= "//*[@id=\"submit\"]")
    WebElement signInButton;
	
	@FindBy(id="transfer-menu-item")
	static WebElement Link_TransferBetweenAccounts;

	@FindBy(xpath="//*[@id=\"fromAccount\"]")
	static WebElement DrpDwn_fromAcnt;

	@FindBy(xpath="//select[@id='toAccount']")
	static WebElement DrpDwn_toAcnt;

	@FindBy(xpath="//input[@id='amount']")
	static WebElement TxtBox_Amt;
	
	@FindBy(xpath="//button[@class='btn btn-danger btn-sm']")
	static WebElement Btn_Reset;

	@FindBy(xpath="//button[@class='btn btn-primary btn-sm']")
	static WebElement Btn_Submit;
	
	@FindBy(xpath="//div[@class='sufee-alert alert with-close alert-danger alert-dismissible fade show']/child::span[2]")
	static WebElement Error_0_Amt; 
	
	public transferpages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickonTransferBetweenAcnts()
	{
		Link_TransferBetweenAccounts.click();
	}
	
	public void enterAcntsDetails(int dd1_index, int dd2_index, String amt)
	{
		Select dd1 = new Select(DrpDwn_fromAcnt);
		dd1.selectByIndex(dd1_index);
		Select dd2 = new Select(DrpDwn_toAcnt);
		dd2.selectByIndex(dd2_index);
		TxtBox_Amt.clear();
		TxtBox_Amt.sendKeys(amt);
	}
	
	public void enterUsername(String username) {
        UserNameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        PasswordInput.sendKeys(password);
    }
	
    public void clickSignInButton() {
    	signInButton.click();
    
    }
	
	public void clickonReset()
	{
		Btn_Reset.click();
	}
	
	public void clickonSubmit()
	{
		Btn_Submit.click();
	}
	
	public String captureError()
	{
		String errortxt=Error_0_Amt.getText();
		return errortxt;
	}
	
	public boolean validate_fromAccount_DrpDwn()
	{
		return DrpDwn_fromAcnt.isDisplayed();
	}

	public boolean validate_Reset_Btn()
	{
		return TxtBox_Amt.getText().isEmpty();
	}
}
