package utils;

import ScreenShotFailedTests.Base;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class customListener extends Base implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            failed(result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
