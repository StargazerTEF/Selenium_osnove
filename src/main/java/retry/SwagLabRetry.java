package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class SwagLabRetry implements IRetryAnalyzer {
    private int count = 0;
    private int maxCount = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count < maxCount) {
            count++;
            return true;
        }
        return false;
    }
}

