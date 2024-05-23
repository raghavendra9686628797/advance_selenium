package TestNgPrograms;

import org.testng.annotations.Test;

public class PriorityTest {
@Test(priority = -1)
public void regesterTest() {
	System.out.println("resgesterd test");
}
@Test(priority = 0)
public void loginTest() {
	System.out.println("login test");
}
@Test(priority = 1)
public void searchTest() {
	System.out.println("Search test");
}
@Test(priority = 2)
public void addToCartTest() {
	System.out.println("Add to Cart test");
}
@Test(priority = 3)
public void placeOrderTest() {
	System.out.println("Place order test");
}
@Test(priority = 4)
public void logoutTest() {
	System.out.println("Logout test");
}
}
