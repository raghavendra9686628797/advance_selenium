package Assaignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DDT_CreateOrganisation {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("C:/Users/RAGHAVENDRA/OneDrive/Desktop/TestYantra/AdvanceAutomation/DDTproperty.properties");
		Properties p=new Properties();
		p.load(fis);
		String browser=p.getProperty("browser");
		String url=p.getProperty("url");
		String username=p.getProperty("username");
		String password=p.getProperty("password");
		String organizationname=p.getProperty("organizationname");
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
		
		d.findElement(By.linkText("Organizations")).click();
		
		d.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		d.findElement(By.name("accountname")).sendKeys(organizationname);
	WebElement dropdown = d.findElement(By.name("industry"));
		Select s=new Select(dropdown);
		s.selectByValue("Education");
		dropdown=d.findElement(By.name("accounttype"));
		 s=new Select(dropdown);
		s.selectByValue("Partner");
		d.findElement(By.name("button")).click();
		
	}

}
