package TestNgPrograms;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ConfigurationAnnotation_3 {
@BeforeSuite
public void testBS() {
	System.out.println("Before suit");
}
@AfterSuite
public void testAS()
{
System.out.println("After suit");	
}
@BeforeClass
public void testBC() {
	System.out.println("Befoer class");
} 
@AfterClass
public void testAc() {
	System.out.println("After class");
}
@BeforeMethod
public void testBM() {
	System.out.println("Before method");
}
@AfterMethod
public void testAM() {
	System.out.println("After method");
}
@Test
public void test() {
	System.out.println("Test case");
}
@Test
public void test1() {
	System.out.println("Test case-2");
}
}