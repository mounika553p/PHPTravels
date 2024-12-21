package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.TestBase;

import java.io.File;

public class ITestListenerImpl implements ITestListener {
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test Started");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test Success");
    }

    public void onTestFailure(ITestResult iTestResult) {
        //TODO: upload failure screenshots to report portals
        System.out.println("Test Failure");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("");
    }

    public void onStart(ITestContext iTestContext) {
        System.out.println("");
    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println("");
    }
}
