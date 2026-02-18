package com.framework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;
	public static ExtentReports getReport() {
		if(extent==null) {
			String path=System.getProperty("user.dir")+"/test-output/ExtentReport.html";
			ExtentSparkReporter reporter=new ExtentSparkReporter(path);
			reporter.config().setReportName("Automation Test Report");
			reporter.config().setDocumentTitle("Swag Labs Results");
			
			extent=new ExtentReports();
			extent.attachReporter(reporter);
			
			extent.setSystemInfo("Tester", "Arya");
			extent.setSystemInfo("Framework", "Selenium+TestNG");
			
			
		}
		return extent;
	}
	

}
