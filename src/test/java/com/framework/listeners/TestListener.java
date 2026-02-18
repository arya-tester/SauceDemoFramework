package com.framework.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.framework.base.BaseTest;
import com.framework.reports.ExtentManager;
import com.framework.utils.ScreenshotUtil;

public class TestListener implements ITestListener {
	ExtentReports extent;
	ExtentTest test;
	
	@Override
	public void onStart(ITestContext context) {
		extent=ExtentManager.getReport();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Failed");
		test.fail(result.getThrowable());
		
		//screenshot
		try {
			
			 // Get current test class object
	        Object testClass = result.getInstance();
	        
	        // Get driver from BaseTest
	        WebDriver driver = ((BaseTest) testClass).driver;
	        
			String path = ScreenshotUtil.takeScreenshot(
                   
					driver,
					result.getMethod().getMethodName());

            test.addScreenCaptureFromPath(path);
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
		
		@Override
		public void onTestSkipped(ITestResult result) {
			test.log(Status.SKIP, "Test Skipped");
		}
		
		public void onFinish(ITestContext context) {
			extent.flush();
			
		
		
		
	}

}
