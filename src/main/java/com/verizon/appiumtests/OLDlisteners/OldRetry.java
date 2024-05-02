package com.verizon.appiumtests.OLDlisteners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.lang.invoke.MethodHandles;

public class OldRetry implements IRetryAnalyzer {
    private final static Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    public int maxRetryCount = 1;
    private int retryCount = 0;

    // Below method returns 'true' if the test method has to be retried else 'false'
    //and it takes the 'Result' as parameter of the test method that just ran
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            logger.info("Retrying test " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus()) + " for the " + (retryCount + 1) + " time(s).");
            retryCount++;
            return true;
        }
        return false;
    }

    public String getResultStatusName(int status) {
        String resultName = null;
        if (status == 1)
            resultName = "SUCCESS";
        if (status == 2)
            resultName = "FAILURE";
        if (status == 3)
            resultName = "SKIP";
        return resultName;
    }
}
