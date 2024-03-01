package pages;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestBase {

public static WebDriver driver;
public static ExtentReports er;
public static ExtentTest et;	



	@BeforeClass
	public static void getBrowser()
	{
	    driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://dbankdemo.com/bank/login");	
	}
	
	@AfterClass
	public static void teardown()
	{
		driver.quit();
	}
	
	@BeforeTest
	public void getnameMethod(ITestContext context)
	{
		et=	er.createTest(context.getName());
	}
	
	@BeforeSuite  // this method will be executed before suite begins its execution
	public void InitalizeExtentReport()
	{
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter("reportpom.html");
		er = new ExtentReports();
		er.attachReporter(sparkreporter);
		// on the report display more information about OS, browser, java etc
		er.setSystemInfo("OS", System.getProperty("os.name"));
		er.setSystemInfo("JAVA", System.getProperty("java.version"));
		
	}

	@AfterSuite
	public void generateReports() throws IOException
	{
		er.flush();
		Desktop.getDesktop().browse(new File("reportpom.html").toURI());
	}
	
	
	@AfterMethod()
	public void generateTestStatus(Method m,ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE )
		{
			et.fail(result.getThrowable());
		}
		else if (result.getStatus() == ITestResult.SUCCESS) {
			et.pass(m.getName() + " is passed");
		}
	}

}
