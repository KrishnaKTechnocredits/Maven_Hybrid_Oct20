package base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

	@Override
	public void onFinish(ITestContext result) {
		System.out.println("Test Execuiton is about to finish");
	}

	@Override
	public void onStart(ITestContext result) {
		System.out.println("Test Execuiton is about to start");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	@Override
	public void onTestFailure(ITestResult result) {
		PredefinedActions.capatureScreenShot(result.getName());
		PredefinedActions.close();
		System.out.println("On Fail " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("On skip " + result.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		PredefinedActions.start();
		System.out.println("On Test start " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		PredefinedActions.close();
		System.out.println("On Test Success " + result.getName());
	}

}
