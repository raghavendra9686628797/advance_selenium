package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDT_2 {
public static void main(String[] args) throws IOException {
	// step:1 get the java representation object of physical file
			FileInputStream fis=new FileInputStream("C:/Users/RAGHAVENDRA/OneDrive/Desktop/TestYantra/AdvanceAutomation/DDTproperty.properties");
			//step:2 using property class load all the keys
			Properties p=new Properties();
			p.load(fis);
			//step:3 get the values based on key
			String browser=p.getProperty("browser");
			String url=p.getProperty("url");
			String username=p.getProperty("username");
			String password=p.getProperty("password");
			 
			//launch browser
			WebDriver d=new ChromeDriver();
			d.get(url);
			d.findElement(By.name("user_name")).sendKeys(username);
			d.findElement(By.name("user_password")).sendKeys(password);
			d.findElement(By.id("submitButton")).click();
			
			d.findElement(By.linkText("Organizations")).click();
			d.quit();
}
}
