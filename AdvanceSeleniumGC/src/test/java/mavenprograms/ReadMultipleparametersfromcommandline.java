package mavenprograms;

import org.testng.annotations.Test;

public class ReadMultipleparametersfromcommandline {
	@Test
	public void readparameters() {
		String url=System.getProperty("url");
		String username=System.getProperty("username");
		String password=System.getProperty("password");
		String browser=System.getProperty("browser");
		System.out.println("given url is :"+url);
		System.out.println("given username is :"+username);
		System.out.println("given password is :"+password);
		System.out.println("given browser is :"+browser);
	}
}
