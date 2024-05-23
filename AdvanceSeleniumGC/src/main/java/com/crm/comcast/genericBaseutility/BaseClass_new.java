package com.crm.comcast.genericBaseutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.LoginPage;

public class BaseClass_new {

	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	public DataBaseUtility dlib=new DataBaseUtility();
	public FileUtility flib=new FileUtility();
	public WebDriverUtility wlib=new WebDriverUtility();


	
	@BeforeSuite
	public void testBS() {
		System.out.println("--connect to datbase & report config--");
		dlib.getDbConnection();
		
	}
	
	@BeforeClass
	public void testBC() throws IOException {
		System.out.println("--launch browser--");
		//driver=new ChromeDriver();
		String BROWSER=flib.getDataFromPropertiesFile("browser");
		String URL=flib.getDataFromPropertiesFile("url");
		driver=wlib.openBrowser(driver, BROWSER);
		//maximizing window
		wlib.maximizeWindow(driver);
		driver.get(URL);
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
		//implicit wait
				wlib.waitForPageToLoad(driver);
	}
	@BeforeMethod
	public void testBM() throws IOException {
		
		System.out.println("--Login--");
		LoginPage lplib=new LoginPage(driver);
		String USERNAME=flib.getDataFromPropertiesFile("username");
		System.out.println(USERNAME);
		String PASSWORD=flib.getDataFromPropertiesFile("password");
		System.out.println(PASSWORD);
		
		lplib.LoginAction(USERNAME, PASSWORD);
	}
	
	@AfterMethod
	public void testAM() {
		HomePage hlib=new HomePage(driver);
		hlib.logout(driver);
		System.out.println("--logout--");
		
	}
	
	@AfterClass
	public void testAc() {
		System.out.println("--closr browser--");
		driver.quit();
	}
	
	@AfterSuite
	public void testAS()
	{
	System.out.println("--disconnect to datbase & report backup--");
	dlib.closeConnection();

	}
}
