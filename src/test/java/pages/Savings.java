package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Savings {
	 WebDriver driver;
	 @FindBy(xpath="//*[@id=\"username\"]")
	     WebElement UserNameInput;
	@FindBy(xpath="//*[@id=\"password\"]")
	    static WebElement PasswordInput;
	@FindBy(xpath= "//*[@id=\"submit\"]")
     WebElement signInButton;

	
     @FindBy(xpath="//*[@id=\"savings-menu\"]")
    static WebElement Savings;
    
    @FindBy(xpath="//*[@id=\"view-savings-menu-item\"]")
    static WebElement ViewSavings;
    
      @FindBy(css="#transactionTable_filter > label > input")
	 WebElement Searchbox_transaction;
	
	@FindBy(xpath="//*[@id=\"transactionTable\"]/tbody")
	 WebElement no_match_txt;

	
    public Savings (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
    
     public void clickTheSavings() {
    	 Savings.click();
		}
     public void clickTheViewSavings() {
    	 ViewSavings.click();
     }
     
	public void searchTransactionDetails(String u)  {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Searchbox_transaction.sendKeys(u);
	}
				
	public String capturetext()
	{
		String captured_txt=no_match_txt.getText();
		return captured_txt;
		
	}


	public void searchtrn(String string) {
		// TODO Auto-generated method stub
		
	}


	public void enterLoginDetails(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	}


				