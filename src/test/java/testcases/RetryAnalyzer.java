package testcases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int retryCounter = 0;
	int retryMax = 2;

	@Override
	public boolean retry(ITestResult result) {
		if (retryCounter < retryMax) {
			retryCounter++;
			return true;
		} else {
			return false;
		}
	}

}
