package com.comcast.crm.listnerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.crm.comcast.genericBaseutility.BaseClass_new;

public class ListenerImplementation implements ITestListener,ISuiteListener{
	public static  ExtentReports report;
	public static  ExtentTest test;
	public void onStart(ISuite suite) {
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./Advancereport/report_"+time+".html");
		spark.config().setDocumentTitle("sample test result");
		spark.config().setReportName("e-report");
		spark.config().setTheme(Theme.DARK);
		// add environment information and create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "windows-11");
		report.setSystemInfo("browser", "chrome-107");
	}
	public void onTestStart(ITestResult result) {
test=report.createTest(result.getMethod().getMethodName());
UtilityClassObject.setTest(test);
	}
public void onTestFailure(ITestResult result) {
	String testName=result.getMethod().getMethodName();
	String time=new Date().toString().replace(" ", "_").replace(":", "_");
	TakesScreenshot ts=(TakesScreenshot)BaseClass_new.sdriver;
	String filepath=ts.getScreenshotAs(OutputType.BASE64);
test.addScreenCaptureFromBase64String(filepath,testName+"-"+time);
}
public void onFinish(ISuite suite) {
	report.flush();
}
}
