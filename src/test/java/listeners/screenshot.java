package listeners;

import mystepdefs.signup;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.io.IOException;

public class screenshot implements ITestListener {
    private static WebDriver driver;
    private static signup signup;
    public static void setDriver(WebDriver driver) {
    	screenshot.driver = driver;
    }

  

    public void onFinish(ITestContext context) {
        if (driver != null) {
            driver.quit();
        }
    }


 
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());

        // Check if WebDriver instance is initialized
        if (driver == null) {
            System.out.println("WebDriver instance is null. Cannot capture screenshot.");
            return;
        }

        shot(result.getMethod().getMethodName() + ".png");
          
    }
    private static void shot(String filename) {
		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		try {
		FileHandler.copy(src, new File("Screenshot\\"+filename));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
