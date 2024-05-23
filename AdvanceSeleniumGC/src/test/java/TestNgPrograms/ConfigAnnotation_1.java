package TestNgPrograms;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ConfigAnnotation_1 {
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
