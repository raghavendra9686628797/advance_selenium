package Contactmodule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithSupportDate {
public static void main(String[] args) throws IOException {
	//read proprety file data(common data)
		FileInputStream fis=new FileInputStream("C:\\Users\\RAGHAVENDRA\\OneDrive\\Desktop\\TestYantra\\AdvanceAutomation\\DDTproperty.properties");
		Properties p= new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
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
		d.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		d.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		 fis=new FileInputStream("C:\\Users\\RAGHAVENDRA\\OneDrive\\Desktop\\TestYantra\\AdvanceAutomation\\testscriptpractice (2).xlsx");
		 Workbook wb=WorkbookFactory.create(fis);
		 Sheet s=wb.getSheet("contacts");
		 String firstname=s.getRow(1).getCell(0).toString();
		 String lastname=s.getRow(1).getCell(1).toString();
		 d.findElement(By.name("firstname")).sendKeys(firstname);
		 d.findElement(By.name("lastname")).sendKeys(lastname);
		 //current date setting
		 
		 Date date=new Date();
		 SimpleDateFormat  sim=new SimpleDateFormat("yyyy-MM-dd");
		 String currentdate = sim.format(date);
		 //required date
		 Calendar cal=sim.getCalendar();
		 cal.add(Calendar.DAY_OF_MONTH,10);
		 String enddate=sim.format(cal.getTime());
		 System.out.println(enddate);
		 d.findElement(By.id("jscal_field_support_start_date")).sendKeys(currentdate);
		 d.findElement(By.id("jscal_field_support_end_date")).sendKeys(enddate);
		 d.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[2]")).click();
		 
		 
}
}
