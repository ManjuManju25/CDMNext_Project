package Analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	private int retryCount = 0;
	private int maxRetryCount = 1;
	// Rerunning failed TC's 1 more time
	// Below method returns 'true' if the test method has to be retried else 'false'
	// and it takes the 'Result' as parameter of the test method that just ran

	public boolean retry(ITestResult result) {
		if (retryCount < maxRetryCount) {
			retryCount++;
			return true;
		}
		return false;
	}

}
