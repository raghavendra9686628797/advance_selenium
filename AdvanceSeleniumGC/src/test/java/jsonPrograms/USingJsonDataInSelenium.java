package jsonPrograms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class USingJsonDataInSelenium {
@Test
public void json_data() throws FileNotFoundException, IOException, ParseException {
	JSONParser parse=new JSONParser();
	Object obj = parse.parse(new FileReader("C:/Users/RAGHAVENDRA/OneDrive/Desktop/TestYantra/AdvanceAutomation/appcommondata.json"));
	JSONObject map=(JSONObject) obj;
	String browser=(String) map.get("browser");
	String url=(String) map.get("url");
	String username=(String) map.get("username");
	String password=(String) map.get("password");
	System.out.println(username+"\t"+password);
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
	d.quit();
	
}
}
