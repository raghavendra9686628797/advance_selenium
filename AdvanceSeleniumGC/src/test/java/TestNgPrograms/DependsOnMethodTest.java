package TestNgPrograms;

import org.testng.annotations.Test;

public class DependsOnMethodTest {
	@Test
	public void regesterTest() {
		System.out.println("resgesterd test");
	}
	@Test(dependsOnMethods = "regesterTest")
	public void loginTest() {
		System.out.println("login test");
	}
	@Test(dependsOnMethods = "loginTest")
	public void searchTest() {
		System.out.println("Search test");
	}

	@Test(dependsOnMethods = "searchTest")
	public void logoutTest() {
		System.out.println("Logout test");
	}
}
