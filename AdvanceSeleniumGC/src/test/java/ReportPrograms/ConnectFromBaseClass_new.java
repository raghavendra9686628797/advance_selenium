package ReportPrograms;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.crm.comcast.genericBaseutility.BaseClass_new;
@Listeners(com.comcast.crm.listnerutility.ListenerImplementation.class)
public class ConnectFromBaseClass_new extends BaseClass_new {
	@Test
	public void test1() {
		
		
		
		UtilityClassObject.getTest().log(Status.INFO,"login to app");
		UtilityClassObject.getTest().log(Status.INFO,"navigate to org page");
		UtilityClassObject.getTest().log(Status.INFO,"create org");
		if ("HDFC".equals("HDFC")) {
			UtilityClassObject.getTest().log(Status.PASS,"==org created😊==");
		}else {
			UtilityClassObject.getTest().log(Status.FAIL,"==org not created😒");
	}
		
	}
	@Test
	public void test3() {
		
		
		
		UtilityClassObject.getTest().log(Status.INFO,"login to app");
		UtilityClassObject.getTest().log(Status.INFO,"navigate to org page");
		UtilityClassObject.getTest().log(Status.INFO,"create org");
		if ("TEST_3".equals("TEST_3")) {
			UtilityClassObject.getTest().log(Status.PASS,"==org created😊==");
		}else {
			UtilityClassObject.getTest().log(Status.FAIL,"==org not created😒");
	}
		
	}
	@Test
	public void test2() {
		
		
		
		UtilityClassObject.getTest().log(Status.INFO,"login to app");
		UtilityClassObject.getTest().log(Status.INFO,"navigate to org page");
		UtilityClassObject.getTest().log(Status.INFO,"create org");
		if ("Test-2".equals("Test_2")) {
			UtilityClassObject.getTest().log(Status.PASS,"==org created😊==");
		}else {
			UtilityClassObject.getTest().log(Status.FAIL,"==org not created😒");
	}
		
	}
}
