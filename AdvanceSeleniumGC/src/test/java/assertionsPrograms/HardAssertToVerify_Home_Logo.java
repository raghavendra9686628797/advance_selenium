package assertionsPrograms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.objectRepositoryutility.LoginPage;

public class HardAssertToVerify_Home_Logo {
	@Test
	public void verifyHometest() {
		System.out.println("--test start--");
		String expectedres="Home";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		LoginPage lplib=new LoginPage(driver);
		lplib.LoginAction("admin", "admin");
		String actualres=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		Assert.assertEquals(actualres, expectedres);
		driver.close();
		
	}
	@Test
	public void verifyLogo() {
		System.out.println("--test start--");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		LoginPage lplib=new LoginPage(driver);
		lplib.LoginAction("admin", "admin");
		boolean logo=driver.findElement(By.xpath("//img[@title=\"vtiger-crm-logo.gif\"]")).isEnabled();
		Assert.assertTrue(logo);
		driver.close();
	}
}
