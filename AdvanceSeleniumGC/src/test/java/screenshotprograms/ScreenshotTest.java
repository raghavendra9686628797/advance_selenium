package screenshotprograms;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ScreenshotTest {
@Test
public void Screenshot() throws IOException {
	WebDriver d=new ChromeDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	d.get("https://www.amazon.in/");
	TakesScreenshot ts=(TakesScreenshot)d;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File trg=new File("./screenShots/ssc.png");
	FileHandler.copy(src, trg);
	WebElement flag=d.findElement(By.xpath("//span[@class=\"icp-nav-flag icp-nav-flag-in icp-nav-flag-lop\"]"));
	 ts=(TakesScreenshot)flag;
	 src=ts.getScreenshotAs(OutputType.FILE);
	 trg=new File("./screenShots/ssc1.png");
	FileHandler.copy(src, trg);
	d.close();
}

}
