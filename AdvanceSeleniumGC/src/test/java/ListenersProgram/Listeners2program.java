package ListenersProgram;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.listnerutility.ListenerImplementation;
@Listeners(com.comcast.crm.listnerutility.ListenerImplementation.class)
public class Listeners2program {
@Test(retryAnalyzer =com.comcast.crm.listnerutility.retryListenerimplementation.class)
public void amazon() {
	System.out.println("==Test Start==");
	WebDriver d= new ChromeDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	d.get("https://www.amazon.in/");
	Assert.assertEquals("", d.getTitle());
	d.quit();
	System.out.println("==Test end==");
}
@Test
public void flipkart() {
	System.out.println("==Test Start==");
	WebDriver d= new ChromeDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	d.get("https://www.flipkart.com/");
	d.quit();
	System.out.println("==Test end==");
}
@Test
public void myntra() {
	System.out.println("==Test Start==");
	WebDriver d= new ChromeDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	d.get("https://www.myntra.com/");
	d.quit();
	System.out.println("==Test end==");
}
}
