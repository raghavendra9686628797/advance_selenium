package dataDrivenTesting;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;

public class ReadDataFromExcelandPropertyWithGeneric {
public static void main(String[] args) throws IOException {
	FileUtility flib=new FileUtility();
	ExcelUtility elib=new ExcelUtility();
	String browser=flib.getDataFromPropertiesFile("browser");
	String username=flib.getDataFromPropertiesFile("username");
	String password=flib.getDataFromPropertiesFile("password");
	String url=flib.getDataFromPropertiesFile("url");
	String orgname=elib.readDataFromExcelFile("org", 4, 3);
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
	d.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
	d.findElement(By.name("accountname")).sendKeys(orgname);
	d.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
	d.quit();
}
}
