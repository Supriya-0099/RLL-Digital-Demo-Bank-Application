package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseClass {

public static WebDriver driver = null;
	
	public static WebDriver getDriver()
	{
		return driver;
	}

//	@Before
//	public static void getBrowser()
//	{
//	    driver = new EdgeDriver();
//		
//		driver.manage().window().maximize();
//		driver.get("http://dbankdemo.com/bank/login");	
//	}
//	
//	@After
//	public static void teardown()
//	{
//		driver.close();
//	}
//	
//	
}
