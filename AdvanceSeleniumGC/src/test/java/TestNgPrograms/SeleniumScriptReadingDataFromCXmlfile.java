package TestNgPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class SeleniumScriptReadingDataFromCXmlfile {
	@Test
	public void seleniumtest(XmlTest xmldata) {
		String url=xmldata.getParameter("url");
		String username=xmldata.getParameter("username");
		String password=xmldata.getParameter("password");
		String browser=xmldata.getParameter("browser");
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
