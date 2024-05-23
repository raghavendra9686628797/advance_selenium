package com.comcast.crm.orgtest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.LoginPage;
import com.comcast.crm.objectRepositoryutility.OrganizationPage;

public class CreateOrganizationTest {
@Test
public void createorgtestcase() throws IOException {
	//launch browser
	WebDriver d=new ChromeDriver();
	
	WebDriverUtility wlib=new WebDriverUtility();
	//maximizing window
	wlib.maximizeWindow(d);
	//implicit wait
	wlib.waitForPageToLoad(d);
	//read data from property file
FileUtility fu=new FileUtility();
String url=fu.getDataFromPropertiesFile("url");
String username=fu.getDataFromPropertiesFile("username");
String password=fu.getDataFromPropertiesFile("password");
//navigate to login page
//login into application
 LoginPage lp =new LoginPage(d);
 /* lp.getUsernameEdit().sendKeys(username);
 * lp.getPasswordEdit().sendKeys(password); lp.getLoginbtnEdit().click();
 * 					(or)
 */
	lp.LoginAction( url,username);
	//click on organization link
	HomePage hp=new HomePage(d);
	hp.getOrganizaton().click();
	//click on create new organization button
	OrganizationPage op=new OrganizationPage(d);
	op.getAddOrganizationButton().click();
	
	hp.logout(d);
	
}
}
