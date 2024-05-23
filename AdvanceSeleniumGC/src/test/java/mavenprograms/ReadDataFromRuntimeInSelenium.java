package mavenprograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ReadDataFromRuntimeInSelenium {
	@Test
	public void seleniumtest() {
		String url=System.getProperty("url");
		String username=System.getProperty("username");
		String password=System.getProperty("password");
		String browser=System.getProperty("browser");
				WebDriver d=null;
		if (browser.equals("chrome")) {
			d=new ChromeDriver();
		}
		else if (browser.equals("firefox")) {
			d=new FirefoxDriver();
		}
		else if (browser.equals("edge")) {
			d=new EdgeDriver();
		}
		else {
			System.out.println("enter a valid browser");
		}
		d.get(url);
		d.findElement(By.name("user_name")).sendKeys(username);
		d.findElement(By.name("user_password")).sendKeys(password);
		d.findElement(By.id("submitButton")).click();
	}
}
