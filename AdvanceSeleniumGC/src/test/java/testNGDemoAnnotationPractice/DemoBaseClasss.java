package testNGDemoAnnotationPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class DemoBaseClasss {
	@BeforeSuite
	public void testBS() {
		System.out.println("--connect to datbase & report config--");
	}
	@AfterSuite
	public void testAS()
	{
	System.out.println("--disconnect to datbase & report backup--");	
	}
	@BeforeClass
	public void testBC() {
		System.out.println("--launch browser--");
	} 
	@AfterClass
	public void testAc() {
		System.out.println("--closr browser--");
	}
	@BeforeMethod
	public void testBM() {
		System.out.println("--Login--");
	}
	@AfterMethod
	public void testAM() {
		System.out.println("--logout--");
	}
}
