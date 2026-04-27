package listner;

import com.aventstack.extentreports.MediaEntityBuilder;
import utility.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utility.ScreenshotUtil;

public class Listener implements ISuiteListener, ITestListener{
    ExtentReports ex = ExtentManager.ConfigureExtentReport();
    ExtentTest test;

    @Override
    public void onStart(ISuite suite) {

    }

    @Override
    public void onFinish(ISuite suite) {
        ex.flush();
    }
    @Override
    public void onTestStart(ITestResult result) {
        test = ex.createTest(result.getMethod().getMethodName());
        System.out.println(test);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String base64Screenshot = ScreenshotUtil.captureScreenshotBase64();
        test.fail("Test Failed: " + result.getName());
        test.fail("Screenshot",
                MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());

//        String testName = result.getMethod().getMethodName();
//        System.out.println("Test Failed: " + testName);
//        test.fail("Test Failed: " + testName);
//        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
    }

}
