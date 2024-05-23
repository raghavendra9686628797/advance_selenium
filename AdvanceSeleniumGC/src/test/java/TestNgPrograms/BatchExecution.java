package TestNgPrograms;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BatchExecution {
@Test
public void amazon() {
	System.out.println("==Test Start==");
	WebDriver d= new ChromeDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	d.get("https://www.amazon.in/");
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
