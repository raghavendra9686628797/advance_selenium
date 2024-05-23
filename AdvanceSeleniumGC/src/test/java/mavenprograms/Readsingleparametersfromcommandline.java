package mavenprograms;

import org.testng.annotations.Test;

public class Readsingleparametersfromcommandline {
@Test
public void readparameters() {
	String url=System.getProperty("url");
	System.out.println("given url is :"+url);
}
}
