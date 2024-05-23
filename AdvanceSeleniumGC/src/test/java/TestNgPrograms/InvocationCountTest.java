package TestNgPrograms;

import java.util.Random;

import org.testng.annotations.Test;

public class InvocationCountTest {
@Test(invocationCount = 5)
public void demoTest() {
	
	System.out.println("invocation count test");
}

}
