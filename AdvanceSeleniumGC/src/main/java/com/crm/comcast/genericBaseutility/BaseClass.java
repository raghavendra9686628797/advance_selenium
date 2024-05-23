package com.crm.comcast.genericBaseutility;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.LoginPage;

public class BaseClass {
	public static WebDriver sdriver;
	public WebDriver driver=null;
	public DataBaseUtility dlib=new DataBaseUtility();
	public FileUtility flib=new FileUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public LoginPage lplib=new LoginPage(driver);
	public HomePage hlib=new HomePage(driver);
	
	@BeforeSuite
	public void testBS() {
		System.out.println("--connect to datbase & report config--");
		dlib.getDbConnection();
	}
	@AfterSuite
	public void testAS()
	{
	System.out.println("--disconnect to datbase & report backup--");
	dlib.closeConnection();
	}
	@BeforeClass
	public void testBC() throws IOException {
		System.out.println("--launch browser--");
		driver=new ChromeDriver();
		//String BROWSER=flib.getDataFromPropertiesFile("browser");
		//driver=wlib.openBrowser(driver, BROWSER);
		//maximizing window
		wlib.maximizeWindow(driver);
		
		//implicit wait
				wlib.waitForPageToLoad(driver);
	} 
	@AfterClass
	public void testAc() {
		System.out.println("--closr browser--");
		driver.quit();
	}
	@BeforeMethod
	public void testBM() throws IOException {
		
		System.out.println("--Login--");
		String URL=flib.getDataFromPropertiesFile("url");
		String USERNAME=flib.getDataFromPropertiesFile("username");
		System.out.println(USERNAME);
		String PASSWORD=flib.getDataFromPropertiesFile("password");
		System.out.println(PASSWORD);
		
		driver.get(URL);
		lplib.getUsernameEdit().sendKeys(USERNAME);
		lplib.getPasswordEdit().sendKeys(PASSWORD);
		//lplib.LoginAction(driver, URL,USERNAME, PASSWORD);
	}
	@AfterMethod
	public void testAM() {
		System.out.println("--logout--");
		hlib.logout(driver);
	}
}
