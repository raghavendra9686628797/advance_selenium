package ReportPrograms;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MultipleTest {
	ExtentReports report;
	@BeforeSuite
	public void configBs() {
		//spark report configuration
				ExtentSparkReporter spark=new ExtentSparkReporter("./Advancereport/report.html");
				spark.config().setDocumentTitle("sample test result");
				spark.config().setReportName("e-report");
				spark.config().setTheme(Theme.DARK);
				// add environment information and create test
				report=new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("os", "windows-11");
				report.setSystemInfo("browser", "chrome-107");
	}
	@Test
	public void test1() {
		
		ExtentTest test = report.createTest("test1");
		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to org page");
		test.log(Status.INFO,"create org");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"==org created😊==");
		}else {
			test.log(Status.FAIL,"==org not created😒");
	}
		
	}
	@Test
	public void test3() {
		
		ExtentTest test = report.createTest("test3");
		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to org page");
		test.log(Status.INFO,"create org");
		if ("TEST_3".equals("TEST_3")) {
			test.log(Status.PASS,"==org created😊==");
		}else {
			test.log(Status.FAIL,"==org not created😒");
	}
		
	}
	@Test
	public void test2() {
		
		ExtentTest test = report.createTest("test2");
		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to org page");
		test.log(Status.INFO,"create org");
		if ("Test-2".equals("Test_2")) {
			test.log(Status.PASS,"==org created😊==");
		}else {
			test.log(Status.FAIL,"==org not created😒");
	}
		
	}
	@AfterSuite
	public void configAs() {
		report.flush();
	}
}
