package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class checkingpages {
	 WebDriver driver;
	 @FindBy(xpath="//*[@id=\"username\"]")
	     WebElement UserNameInput;
	@FindBy(xpath="//*[@id=\"password\"]")
	    static WebElement PasswordInput;
	@FindBy(xpath= "//*[@id=\"submit\"]")
     WebElement signInButton;

	
     @FindBy(xpath="//*[@id=\"checking-menu\"]")
    static WebElement Checking;
    
    @FindBy(xpath="//*[@id=\"view-checking-menu-item\"]")
    static WebElement ViewChecking;
    
      @FindBy(xpath="//*[@id='transactionTable_filter']/label/input")
	 WebElement Searchbox_transaction;
	
	@FindBy(xpath="//*[@id=\"transactionTable\"]/tbody/tr/td")
	 WebElement no_match_txt;
	
	
    public checkingpages(WebDriver driver) {
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
    
     public void clickTheChecking() {
		Checking.click();
		}
     public void clickTheViewChecking() {
    	 ViewChecking.click();
     }
     
	public void searchTransactionDetails(String u) {
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
			
    
