package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetry {
	private int retryCount = 0;
    private static final int maxRetryCount = 3;

    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

}
