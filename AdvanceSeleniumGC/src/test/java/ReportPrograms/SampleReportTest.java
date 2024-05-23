package ReportPrograms;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
@Test
public void test1() {
	//spark report configuration
	ExtentSparkReporter spark=new ExtentSparkReporter("./Advancereport/report.html");
	spark.config().setDocumentTitle("sample test result");
	spark.config().setReportName("e-report");
	spark.config().setTheme(Theme.DARK);
	// add environment information and create test
	ExtentReports report=new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("os", "windows-11");
	report.setSystemInfo("browser", "chrome-107");
	ExtentTest test = report.createTest("SampleReportTest");
	
	test.log(Status.INFO,"login to app");
	test.log(Status.INFO,"navigate to org page");
	test.log(Status.INFO,"create org");
	if ("HDFC".equals("HDFC")) {
		test.log(Status.PASS,"==org created😊==");
	}else {
		test.log(Status.FAIL,"==org not created😒");
}
	report.flush();
}
}
