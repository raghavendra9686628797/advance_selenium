package organizationPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
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

public class CreateorganizationTest {
public static void main(String[] args) throws IOException {
	//read proprety file data(common data)
	FileInputStream fis=new FileInputStream("C:\\Users\\RAGHAVENDRA\\OneDrive\\Desktop\\TestYantra\\AdvanceAutomation\\DDTproperty.properties");
	Properties p= new Properties();
	p.load(fis);
	String browser = p.getProperty("browser");
	String url=p.getProperty("url");
	String username=p.getProperty("username");
	String password=p.getProperty("password");
	
	//read org name from xcel sheeet
	fis=new FileInputStream("C:\\Users\\RAGHAVENDRA\\OneDrive\\Desktop\\TestYantra\\AdvanceAutomation\\testscriptpractice.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet s=wb.getSheet("org");
	Row r=s.getRow(1);
	Cell c=r.getCell(2);
	String data=c.toString();
	String industry=r.getCell(4).toString();
	String type=r.getCell(5).toString();
	Random r1=new Random();
	int value=r1.nextInt(200);
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
	String name=data+value;
	d.findElement(By.name("accountname")).sendKeys(name);
	WebElement industrydropdown=d.findElement(By.name("industry"));
	Select sel=new Select(industrydropdown);
	sel.selectByValue(industry);
	WebElement acctype=d.findElement(By.name("accounttype"));
	sel=new Select(acctype);
	sel.selectByValue(type);
	d.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
	
	String orgname=d.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
	System.out.println(orgname);
	if (orgname.contains(name)) {
		System.out.println(data+" is present"+"\n"+"test case pass");
	} else {
		System.out.println(data+" is not present"+"\n"+"test case fail");
	}
	String org=d.findElement(By.id("dtlview_Organization Name")).getText();
	System.out.println(org);
	if (org.equals(name)) {
		System.out.println("org is created");
	}
	else {
		System.out.println("org not created");
	}
	d.quit();
}
}
