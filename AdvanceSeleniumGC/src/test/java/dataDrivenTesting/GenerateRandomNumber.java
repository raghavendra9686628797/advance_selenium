package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GenerateRandomNumber {
public static void main(String[] args) throws IOException {
	Random r=new Random();
	int num=r.nextInt(1000);
	System.out.println(num);
	FileInputStream fis=new FileInputStream("C:/Users/RAGHAVENDRA/OneDrive/Desktop/TestYantra/AdvanceAutomation/DDTproperty.properties");
	Properties p=new Properties();
	p.load(fis);
	String browser=p.getProperty("browser");
	String url=p.getProperty("url");
	String username=p.getProperty("username");
	String password=p.getProperty("password");
	
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
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	d.get(url);
	d.findElement(By.name("user_name")).sendKeys(username);
	d.findElement(By.name("user_password")).sendKeys(password);
	d.findElement(By.id("submitButton")).click();
	
	d.findElement(By.linkText("Organizations")).click();
	
	d.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	FileInputStream fe=new FileInputStream("C:\\Users\\RAGHAVENDRA\\OneDrive\\Desktop\\TestYantra\\AdvanceAutomation\\TestScriptData.xlsx");
	Workbook wb = WorkbookFactory .create(fe);
	String organizationname = wb.getSheet("org").getRow(1).getCell(2).toString();
	organizationname=organizationname+""+num;
	d.findElement(By.name("accountname")).sendKeys(organizationname);
WebElement dropdown = d.findElement(By.name("industry"));
	Select s=new Select(dropdown);
	s.selectByValue("Education");
	dropdown=d.findElement(By.name("accounttype"));
	 s=new Select(dropdown);
	s.selectByValue("Partner");
	d.findElement(By.name("button")).click();
	//WebElement profile=d.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
	//Actions a=new Actions(d);
//	a.moveToElement(profile).perform();
//	d.findElement(By.xpath("//a[@href=\"index.php?module=Users&action=Logout\"]")).click();
	d.quit();
	
}
}
